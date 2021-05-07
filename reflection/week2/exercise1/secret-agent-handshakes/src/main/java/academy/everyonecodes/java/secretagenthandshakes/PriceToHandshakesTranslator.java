package academy.everyonecodes.java.secretagenthandshakes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceToHandshakesTranslator {
    private int minPrice;
    private int maxPrice;
    private HandshakeNumberToMoveTranslator translator;

    public PriceToHandshakesTranslator(@Value("${secretagent.minPrice}") int minPrice, @Value("${secretagent.maxPrice}") int maxPrice, HandshakeNumberToMoveTranslator translator) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.translator = translator;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setTranslator(HandshakeNumberToMoveTranslator translator) {
        this.translator = translator;
    }

    public List<String> translate(int price) {
        if (price < minPrice || price > maxPrice) {
            return List.of();
        }
        List<String> digits = Arrays.asList(String.valueOf(price).split(""));
        return digits.stream()
                .map(x -> translator.translate(Integer.parseInt(x)))
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());
    }
}
