package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RecommendationServiceTest {
    @Autowired
    RecommendationService service;

    @MockBean
    TailoredRecommendationsClient tailoredClient;

    @MockBean
    HotRightNowClient hotClient;

    @Test
    void getRecomms() {
        Movie[] expected = {new Movie("test1", "test1")};

        Mockito.when(tailoredClient.getRecomms("abc123")).thenReturn(expected);
        var result = service.get("abc123");
        Mockito.verify(tailoredClient).getRecomms("abc123");
    }

    @Test
    void getHotsNull() {
        Movie[] expectedHot = {new Movie("hot1", "hot1")};

        Mockito.when(tailoredClient.getRecomms("666aaa")).thenReturn(null);
        Mockito.when(hotClient.getHots()).thenReturn(expectedHot);
        var result = service.get("666aaa");
        Mockito.verify(tailoredClient).getRecomms("666aaa");
        Mockito.verify(hotClient).getHots();
    }

    @Test
    void getHotsEmpty() {
        Movie[] expected = {};
        Movie[] expectedHot = {new Movie("hot1", "hot1")};

        Mockito.when(tailoredClient.getRecomms("666aaa")).thenReturn(expected);
        Mockito.when(hotClient.getHots()).thenReturn(expectedHot);
        var result = service.get("666aaa");
        Mockito.verify(tailoredClient).getRecomms("666aaa");
        Mockito.verify(hotClient).getHots();
    }
}
