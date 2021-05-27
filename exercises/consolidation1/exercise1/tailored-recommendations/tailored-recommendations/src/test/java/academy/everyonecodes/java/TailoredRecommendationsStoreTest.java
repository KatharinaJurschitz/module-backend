package academy.everyonecodes.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class TailoredRecommendationsStoreTest {
    @Autowired
    TailoredRecommendationsStore store;

    @Test
    void getRecommWithUuid() {
        var result = store.getRecommendations("123abc");
        var expected = List.of(new TailoredRecommendation("123abc", new Movie("test1", "test1")));
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getRecommWithoutUUid() {
        var result = store.getRecommendations("666aaa");
        List<TailoredRecommendation> expected = List.of();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void postRecomm() {
        TailoredRecommendation test = new TailoredRecommendation("123abc", new Movie("test2", "test2"));
        var result = store.postNewRecommendation(test);
        Assertions.assertEquals(test, result);
    }
}
