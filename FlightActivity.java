import java.util.Date;

public class FlightActivity {
    private String activityId;
    private String flightNo;
    private Date date;
    private int distance;
    private String fareClass;
    private int milesEarned;

    public FlightActivity(String activityId, String flightNo, Date date, int distance, String fareClass, int milesEarned) {
        this.activityId = activityId;
        this.flightNo = flightNo;
        this.date = date;
        this.distance = distance;
        this.fareClass = fareClass;
        this.milesEarned = milesEarned;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public int getDistance() {
        return distance;
    }

    public String getFareClass() {
        return fareClass;
    }

    public int getMilesEarned() {
        return milesEarned;
    }
}
