import java.util.List;

public class App {
    public static void main(String[] args) {
        ActivityController controller = ActivityController.getInstance();
        ActivityReader reader = new ActivityReader();

        List<MonitoredData> list = reader.read();

        System.out.println("number of days in log: ");
        System.out.println(controller.showNumberOfDaysInLog(list));

        System.out.println("number of activities in log: ");
        System.out.println(controller.showNumberOfActivitiesTracked(list));

        System.out.println("duration of activities tracked: ");
        System.out.println(controller.showDurationOfActivitiesTracked(list));

        System.out.println("number of activities per day:");
        System.out.println(controller.showNumberOfActivitiesPerDay(list));

        System.out.println("shortest activity in 90% of activities:");
        System.out.println(controller.showShortestActivityInNinetyPercent(list));
    }
}
