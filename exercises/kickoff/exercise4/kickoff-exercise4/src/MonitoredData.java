import java.time.LocalDateTime;
import java.util.Objects;

public class MonitoredData {
    private LocalDateTime startDay;
    private LocalDateTime endDay;
    private Activity activity;

    public MonitoredData(LocalDateTime startDay, LocalDateTime endDay, Activity activity) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.activity = activity;
    }

    public LocalDateTime getStartDay() {
        return startDay;
    }

    public LocalDateTime getEndDay() {
        return endDay;
    }

    public Activity getActivity() {
        return activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonitoredData that = (MonitoredData) o;
        return Objects.equals(startDay, that.startDay) &&
                Objects.equals(endDay, that.endDay) &&
                activity == that.activity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDay, endDay, activity);
    }
}
