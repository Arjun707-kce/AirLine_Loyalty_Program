import java.util.ArrayList;
import java.util.List;

public class Member {
    protected String memberId;
    protected String name;
    protected String email;
    protected String tier;
    protected int milesBalance;
    protected List<FlightActivity> activities;

    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.tier = "Basic";
        this.milesBalance = 0;
        this.activities = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getTier() {
        return tier;
    }

    public int getMilesBalance() {
        return milesBalance;
    }

    public void addActivity(FlightActivity activity) {
        activities.add(activity);
    }

    public void creditMiles(int distance) {
        milesBalance += distance;
        System.out.println(name + " credited with " + distance + " miles.");
    }

    public void creditMiles(int distance, String fareClass) {
        int bonus = 0;
        if (fareClass.equalsIgnoreCase("Business")) {
            bonus = distance / 2;
        } else if (fareClass.equalsIgnoreCase("First")) {
            bonus = distance;
        }
        milesBalance += distance + bonus;
        System.out.println(name + " credited with " + (distance + bonus) + " miles (" + fareClass + ").");
    }

    public void evaluateTier() {
        if (milesBalance >= 50000) {
            tier = "Platinum";
        } else if (milesBalance >= 25000) {
            tier = "Gold";
        } else if (milesBalance >= 10000) {
            tier = "Silver";
        } else {
            tier = "Basic";
        }
    }

    public boolean redeem(Reward reward) {
        if (milesBalance >= reward.getMilesRequired() && reward.isAvailable()) {
            milesBalance -= reward.getMilesRequired();
            reward.setAvailability(false);
            System.out.println(name + " redeemed " + reward.getName() + " for " + reward.getMilesRequired() + " miles.");
            return true;
        } else {
            System.out.println("Insufficient miles or reward unavailable.");
            return false;
        }
    }

    public void statement() {
        System.out.println("----- Member Statement -----");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Tier: " + tier);
        System.out.println("Miles Balance: " + milesBalance);
        System.out.println("Activities:");
        for (FlightActivity activity : activities) {
            System.out.println("  Flight " + activity.getFlightNo() + ", " + activity.getDistance() + " miles.");
        }
        System.out.println("----------------------------");
    }
}
