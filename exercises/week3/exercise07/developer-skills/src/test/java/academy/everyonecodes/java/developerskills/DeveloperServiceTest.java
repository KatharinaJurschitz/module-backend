package academy.everyonecodes.java.developerskills;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@SpringBootTest
public class DeveloperServiceTest {
    @Autowired
    DeveloperService service;

    @ParameterizedTest
    @MethodSource("inputData")
    void findBySkill(String input, List<Developer> expected) {
        var result = service.findBy(input);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of("CSS, HTML", List.of(new Developer("Sonia", Set.of("Python", "HTML", "CSS")), new Developer("Seth", Set.of("Javascript", "CSS", "HTML")))),
                Arguments.of("", List.of()),
                Arguments.of("C#", List.of()),
                Arguments.of("Java", List.of(new Developer("Sarah", Set.of("Java", "Spring-Boot"))))
        );
    }

    @Test
    void findAll() {
        var result = service.findAll();
        var expected = List.of(new Developer("Seth", Set.of("Javascript", "CSS", "HTML")),
                new Developer("Sarah", Set.of("Java", "Spring-Boot")),
                new Developer("Sonia", Set.of("Python", "HTML", "CSS")),
                new Developer("Tom", Set.of("Kotlin", "Python", "Javascript")));
        Assertions.assertEquals(expected, result);
    }
}
