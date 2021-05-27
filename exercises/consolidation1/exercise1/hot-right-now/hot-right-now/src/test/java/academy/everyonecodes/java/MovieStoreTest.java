package academy.everyonecodes.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class MovieStoreTest {
    @Autowired
    MovieStore movieStore;

    @Test
    void getAll() {
        var result = movieStore.getAllHotRightNow();
        var expected = List.of(new Movie("test1 title", "test1 synopsis"), new Movie("test2 title", "test2 synopsis"));
        Assertions.assertEquals(expected, result);
    }
}
