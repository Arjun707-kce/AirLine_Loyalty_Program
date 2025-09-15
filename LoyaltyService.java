import java.util.ArrayList;
import java.util.List;

public class LoyaltyService {
    private List<Member> members;
    private List<Reward> rewards;

    public LoyaltyService() {
        members = new ArrayList<>();
        rewards = new ArrayList<>();
    }

    public void enrollMember(Member member) {
        members.add(member);
        System.out.println("Enrolled member: " + member.getName() + " (" + member.getTier() + ")");
    }

    public void addReward(Reward reward) {
        rewards.add(reward);
        System.out.println("Added reward: " + reward.getName());
    }

    public void creditMiles(Member member, int distance) {
        member.creditMiles(distance);
        member.evaluateTier();
    }

    public void creditMiles(Member member, int distance, String fareClass) {
        member.creditMiles(distance, fareClass);
        member.evaluateTier();
    }

    public void redeemReward(Member member, String rewardId) {
        for (Reward reward : rewards) {
            if (reward.getRewardId().equals(rewardId)) {
                reward.redeem(member);
                return;
            }
        }
        System.out.println("Reward not found.");
    }

    public void printAllStatements() {
        for (Member member : members) {
            member.statement();
        }
    }

    public void tierSummary() {
        int basic = 0, silver = 0, gold = 0, platinum = 0;
        for (Member member : members) {
            switch (member.getTier()) {
                case "Basic": basic++; break;
                case "Silver": silver++; break;
                case "Gold": gold++; break;
                case "Platinum": platinum++; break;
            }
        }
        System.out.println("Tier Distribution Summary:");
        System.out.println("Basic: " + basic);
        System.out.println("Silver: " + silver);
        System.out.println("Gold: " + gold);
        System.out.println("Platinum: " + platinum);
    }
}
