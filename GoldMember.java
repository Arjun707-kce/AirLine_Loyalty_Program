public class GoldMember extends Member {

    public GoldMember(String memberId, String name, String email) {
        super(memberId, name, email);
        this.tier = "Gold";
    }

    @Override
    public void creditMiles(int distance) {
        int bonus = distance / 5;
        milesBalance += distance + bonus;
        System.out.println(name + " credited with " + (distance + bonus) + " miles (Gold bonus).");
    }

    @Override
    public void creditMiles(int distance, String fareClass) {
        int bonus = distance / 5;
        if (fareClass.equalsIgnoreCase("Business")) {
            bonus += distance / 4;
        } else if (fareClass.equalsIgnoreCase("First")) {
            bonus += distance / 3;
        }
        milesBalance += distance + bonus;
        System.out.println(name + " credited with " + (distance + bonus) + " miles (Gold bonus with fare class).");
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
