package academy.everyonecodes.java.marathonintegration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marathon/integration")
public class MarathonIntegrationEndpoint {
    private MarathonTester tester;

    public MarathonIntegrationEndpoint(MarathonTester tester) {
        this.tester = tester;
    }

    @GetMapping
    TestResult get() {
        return tester.test();
    }
}
