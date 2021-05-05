package academy.everyonecodes.java.singaporereconstruction;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("singapore")
public class BuildingReconstructionCandidateAnalyser {
    private List<Building> buildings;

    public BuildingReconstructionCandidateAnalyser(List<Building> buildings) {
        this.buildings = buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Building> findCandidates() {
        return buildings.stream()
                .filter(x -> !x.isHistoric())
                .filter(x -> Period.between(x.getBuilt(), LocalDate.now()).getYears() > 20)
                .collect(Collectors.toList());
    }
}
