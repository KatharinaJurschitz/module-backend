package academy.everyonecodes.java.trickster;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Trickster {
    private final CupsClient client;
    private final Random random;

    public Trickster(CupsClient client, Random random) {
        this.client = client;
        this.random = random;
    }

    public String play() {
        for (int i = 0; i < client.numberOfCups(); i++) {
            client.removeCoin(i);
        }
        int randomCup = random.nextInt(2);
        client.addCoin(randomCup);
        return "The cups have been shuffled!";
    }

    public boolean hasCoin(int cupNumber) {
        return client.checkForCoin(cupNumber);
    }
}
