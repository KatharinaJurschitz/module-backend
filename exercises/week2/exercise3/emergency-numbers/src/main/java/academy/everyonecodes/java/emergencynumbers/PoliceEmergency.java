package academy.everyonecodes.java.emergencynumbers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PoliceEmergency implements EmergencyNumber {
    private final String name;
    private final int telephone;

    public PoliceEmergency(@Value("${emergency.police.name}") String name, @Value("${emergency.police.number}") int telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTelephone() {
        return telephone;
    }
}
