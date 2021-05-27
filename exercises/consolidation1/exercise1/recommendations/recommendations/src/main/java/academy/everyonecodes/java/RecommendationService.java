package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RecommendationService {
    private final TailoredRecommendationsClient tailoredClient;
    private final HotRightNowClient hotClient;

    public RecommendationService(TailoredRecommendationsClient tailoredClient, HotRightNowClient hotClient) {
        this.tailoredClient = tailoredClient;
        this.hotClient = hotClient;
    }

    public Movie[] get(String userUuid) {
        Movie[] output = tailoredClient.getRecomms(userUuid);
        if (output == null || output.length == 0) {
            return hotClient.getHots();
        }
        return output;
    }
}
