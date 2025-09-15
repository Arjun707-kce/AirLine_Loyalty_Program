public class PlatinumMember extends Member {

    public PlatinumMember(String memberId, String name, String email) {
        super(memberId, name, email);
        this.tier = "Platinum";
    }

    @Override
    public void creditMiles(int distance) {
        int bonus = distance / 3;
        milesBalance += distance + bonus;
        System.out.println(name + " credited with " + (distance + bonus) + " miles (Platinum bonus).");
    }

    @Override
    public void creditMiles(int distance, String fareClass) {
        int bonus = distance / 3;
        if (fareClass.equalsIgnoreCase("Business")) {
            bonus += distance / 2;
        } else if (fareClass.equalsIgnoreCase("First")) {
            bonus += distance / 1;
        }
        milesBalance += distance + bonus;
        System.out.println(name + " credited with " + (distance + bonus) + " miles (Platinum bonus with fare class).");
    }

    @Override
    public void evaluateTier() {
        if (milesBalance >= 75000) {
            tier = "Platinum";
        } else if (milesBalance >= 25000) {
            tier = "Gold";
        } else if (milesBalance >= 10000) {
            tier = "Silver";
        } else {
            tier = "Basic";
        }
    }
}
