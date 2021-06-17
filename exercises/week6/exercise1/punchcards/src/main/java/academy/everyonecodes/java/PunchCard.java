package academy.everyonecodes.java;

public class PunchCard {
    private String id;
    private String dayOfTheWeek;
    private String timeOfDay;

    public PunchCard(String dayOfTheWeek, String timeOfDay) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.timeOfDay = timeOfDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    @Override
    public String toString() {
        return "PunchCard{" +
                "id='" + id + '\'' +
                ", dayOfTheWeek='" + dayOfTheWeek + '\'' +
                ", timeOfDay='" + timeOfDay + '\'' +
                '}';
    }
}
