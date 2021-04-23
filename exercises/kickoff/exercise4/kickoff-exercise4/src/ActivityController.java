import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityController {
    private static final ActivityController activityController = new ActivityController();

    public static ActivityController getInstance() {
        return activityController;
    }

    private ActivityController() {
    }

    public long showNumberOfDaysInLog(List<MonitoredData> input) {
        return input.stream()
                .map(MonitoredData::getStartDay)
                .map(LocalDateTime::toString)
                .map(x -> x.substring(0, 10))
                .distinct()
                .count();
    }

    public long showNumberOfActivitiesTracked(List<MonitoredData> input) {
        return input.stream()
                .map(MonitoredData::getActivity)
                .distinct()
                .count();
    }

    public List<Long> showDurationOfActivitiesTracked(List<MonitoredData> input) {
        List<Long> output = new ArrayList<>();
        for (MonitoredData monitoredData : input) {
            LocalDateTime start = monitoredData.getStartDay();
            LocalDateTime end = monitoredData.getEndDay();
            Duration duration = Duration.between(start, end);
            output.add(duration.toMinutes());
        }
        return output;
    }

    public HashMap<String, Long> showNumberOfActivitiesPerDay(List<MonitoredData> input) {
        HashMap<String, Long> output = new HashMap<String, Long>();
        List<String> strings = input.stream()
                .map(MonitoredData::getStartDay)
                .map(LocalDateTime::toString)
                .map(x -> x.substring(0, 10))
                .collect(Collectors.toList());

        for (String string : strings) {
            output.put(string, input.stream().map(MonitoredData::getActivity).distinct().count());
        }

        return output;
    }
}
