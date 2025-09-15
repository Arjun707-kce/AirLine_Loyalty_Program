public class Reward {
    private String rewardId;
    private String name;
    private int milesRequired;
    private boolean availability;

    public Reward(String rewardId, String name, int milesRequired, boolean availability) {
        this.rewardId = rewardId;
        this.name = name;
        this.milesRequired = milesRequired;
        this.availability = availability;
    }

    public String getRewardId() {
        return rewardId;
    }

    public String getName() {
        return name;
    }

    public int getMilesRequired() {
        return milesRequired;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void redeem(Member member) {
        if (member.getMilesBalance() >= milesRequired && availability) {
            member.milesBalance -= milesRequired;
            availability = false;
            System.out.println(member.getName() + " redeemed " + name + " reward.");
        } else {
            System.out.println("Cannot redeem reward: insufficient miles or unavailable.");
        }
    }
}
