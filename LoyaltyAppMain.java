import java.util.Date;

public class LoyaltyAppMain {
    public static void main(String[] args) {
        LoyaltyService service = new LoyaltyService();

        // Create members
        Member m1 = new SilverMember("M001", "Alice", "alice@example.com");
        Member m2 = new GoldMember("M002", "Bob", "bob@example.com");
        Member m3 = new PlatinumMember("M003", "Charlie", "charlie@example.com");

        // Enroll members
        service.enrollMember(m1);
        service.enrollMember(m2);
        service.enrollMember(m3);

        // Add rewards
        Reward r1 = new Reward("R001", "Free Flight", 30000, true);
        Reward r2 = new Reward("R002", "Upgrade", 15000, true);
        Reward r3 = new Reward("R003", "Voucher", 10000, true);
        service.addReward(r1);
        service.addReward(r2);
        service.addReward(r3);

        // Credit miles
        service.creditMiles(m1, 12000);
        service.creditMiles(m2, 20000, "Business");
        service.creditMiles(m3, 40000, "First");

        // Add flight activities
        m1.addActivity(new FlightActivity("A001", "FL123", new Date(), 12000, "Economy", 12000));
        m2.addActivity(new FlightActivity("A002", "FL456", new Date(), 20000, "Business", 20000));
        m3.addActivity(new FlightActivity("A003", "FL789", new Date(), 40000, "First", 40000));

        // Redeem rewards
        service.redeemReward(m1, "R003"); // Alice
        service.redeemReward(m2, "R002"); // Bob
        service.redeemReward(m3, "R001"); // Charlie

        // Print statements
        service.printAllStatements();

        // Tier summary
        service.tierSummary();
    }
}
