public class SilverMember extends Member {

    public SilverMember(String memberId, String name, String email) {
        super(memberId, name, email);
        this.tier = "Silver";
    }

    @Override
    public void creditMiles(int distance) {
        int bonus = distance / 10;
        milesBalance += distance + bonus;
        System.out.println(name + " credited with " + (distance + bonus) + " miles (Silver bonus).");
    }

    @Override
    public void creditMiles(int distance, String fareClass) {
        int bonus = distance / 10;
        if (fareClass.equalsIgnoreCase("Business")) {
            bonus += distance / 5;
        } else if (fareClass.equalsIgnoreCase("First")) {
            bonus += distance / 4;
        }
        milesBalance += distance + bonus;
        System.out.println(name + " credited with " + (distance + bonus) + " miles (Silver bonus with fare class).");
    }

    @Override
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
}
