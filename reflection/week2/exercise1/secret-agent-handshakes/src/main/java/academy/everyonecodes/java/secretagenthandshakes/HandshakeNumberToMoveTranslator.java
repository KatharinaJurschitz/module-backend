package academy.everyonecodes.java.secretagenthandshakes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@ConfigurationProperties("secretagent")
public class HandshakeNumberToMoveTranslator {
    Set<Handshake> handshakes;

    public HandshakeNumberToMoveTranslator(Set<Handshake> handshakes) {
        this.handshakes = handshakes;
    }

    public void setHandshakes(Set<Handshake> handshakes) {
        this.handshakes = handshakes;
    }

    public String translate(int number) {
        System.out.println(handshakes);
        return handshakes.stream()
                .filter(x -> x.getNumber() == number)
                .map(Handshake::getMove)
                .findFirst()
                .orElse("");
    }
}
