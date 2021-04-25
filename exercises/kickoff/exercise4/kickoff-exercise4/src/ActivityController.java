import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
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

    public HashMap<String, String> showNumberOfActivitiesPerDay(List<MonitoredData> input) {
        HashMap<String, Long> helper = new HashMap<>();
        HashMap<String, String> output = new HashMap<>();
        List<String> days = input.stream()
                .map(MonitoredData::getStartDay)
                .map(LocalDateTime::toString)
                .map(x -> x.substring(0, 10))
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<String> activities = input.stream()
                .map(MonitoredData::getActivity)
                .map(Activity::toString)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        for (String activity : activities) {
            for (String day : days) {
                helper.put(activity, input.stream()
                        .filter(d -> d.getStartDay().toString().substring(0, 10).equals(day))
                        .filter(a -> a.getActivity().toString().equals(activity))
                        .count());
                output.put(day + ": " + activity, " " + helper.get(activity));
            }
        }
        return output;
    }

    public List<Activity> showShortestActivityInNinetyPercent(List<MonitoredData> input) {
        return input.stream()
                .map(MonitoredData::getActivity)
                .filter(f -> input.stream()
                        .filter(s -> (s.getActivity() == f) && (s.getDurationInMinutes() < 5))
                        .count() * 100 / input.stream()
                        .filter(s -> s.getActivity() == f)
                        .count() > 90)
                .distinct()
                .collect(Collectors.toList());
    }
}
