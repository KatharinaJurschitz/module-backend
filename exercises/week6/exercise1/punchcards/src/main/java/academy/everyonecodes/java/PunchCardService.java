package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PunchCardService {
    private final PunchCardRepository punchCardRepository;

    public PunchCardService(PunchCardRepository punchCardRepository) {
        this.punchCardRepository = punchCardRepository;
    }

    private PunchCard createPunchCard() {
        var day = LocalDateTime.now().getDayOfWeek().toString();
        var time = LocalDateTime.now().format(DateTimeFormatter.ISO_TIME);
        return new PunchCard(day, time);
    }

    public void punch() {
        PunchCard card = createPunchCard();
        punchCardRepository.save(card);
        System.out.println("*** Punchcard saved: " + card);
    }
}
