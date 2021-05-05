package academy.everyonecodes.java.emergencynumbers;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmergencyNumberProvider {
    private final List<EmergencyNumber> emergencyNumbers;

    public EmergencyNumberProvider(List<EmergencyNumber> emergencyNumbers) {
        this.emergencyNumbers = emergencyNumbers;
    }

    public int provide(String name) {
        int output = 112;
        for (EmergencyNumber emergencyNumber: emergencyNumbers) {
            if (emergencyNumber.getName().equalsIgnoreCase(name)) {
                output = emergencyNumber.getTelephone();
            }
        }
        return output;
    }
}
