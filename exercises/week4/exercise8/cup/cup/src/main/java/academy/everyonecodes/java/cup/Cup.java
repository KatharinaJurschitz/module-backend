package academy.everyonecodes.java.cup;

import org.springframework.stereotype.Service;

@Service
public class Cup {
    private boolean hasCoin;

    public boolean checkForCoin() {
        return hasCoin;
    }

    public void addCoin() {
        hasCoin = true;
    }

    public void removeCoin() {
        hasCoin = false;
    }
}
