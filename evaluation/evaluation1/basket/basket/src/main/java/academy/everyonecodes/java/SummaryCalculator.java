package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

@Service
public class SummaryCalculator {
    private final UsersClient client;

    public SummaryCalculator(UsersClient client) {
        this.client = client;
    }

    public Summary getSummary(ItemSelection itemSelection) {
        double deliveryCost = 0.0;
        String userMail = itemSelection.getUserEmail();
        var user = client.getUser(userMail);
        if (!user.getAccountType().equals("premium account")) {
            deliveryCost += 2.50;
        }
        double totalPrice = deliveryCost + itemSelection.getItemPrice();
        return new Summary(userMail, itemSelection.getItemName(),
                itemSelection.getItemPrice(), deliveryCost, totalPrice);
    }
}
