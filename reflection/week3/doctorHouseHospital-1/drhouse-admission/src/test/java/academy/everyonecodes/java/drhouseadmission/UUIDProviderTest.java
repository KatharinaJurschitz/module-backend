package academy.everyonecodes.java.drhouseadmission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class UUIDProviderTest {
    @Autowired
    private UUIDProvider provider;

    @Test
    void provideUUID() {
        provider.provideUUID(new Patient("Lisa", "headache"));
        var result= provider.findUUID("Lisa");
        var snapshot= provider.getCacheSnapshot();
        var expected = snapshot.values().stream().findFirst();
        Assertions.assertEquals(expected, result);
    }
}
