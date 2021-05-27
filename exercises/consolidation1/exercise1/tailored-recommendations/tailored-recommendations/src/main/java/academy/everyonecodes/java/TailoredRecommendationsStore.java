package academy.everyonecodes.java;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("tailoredrecommendations")
public class TailoredRecommendationsStore {
    private ArrayList<TailoredRecommendation> recommendations;

    public void setRecommendations(ArrayList<TailoredRecommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public List<TailoredRecommendation> getRecommendations(String userUuid) {
        return recommendations.stream()
                .filter(x -> x.getUserUuid().equals(userUuid))
                .collect(Collectors.toList());
    }

    public TailoredRecommendation postNewRecommendation(TailoredRecommendation recommendation) {
        recommendations.add(recommendation);
        return recommendation;
    }
}
