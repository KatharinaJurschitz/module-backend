package academy.everyonecodes.java;

import java.util.Objects;

public class Summary {
    private String userEmail;
    private String itemName;
    private double itemPrice;
    private double deliveryCost;
    private double totalPrice;

    public Summary(String userEmail, String itemName, double itemPrice, double deliveryCost, double totalPrice) {
        this.userEmail = userEmail;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.deliveryCost = deliveryCost;
        this.totalPrice = totalPrice;
    }

    public Summary() {}

    public String getUserEmail() {
        return userEmail;
    }

    void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getItemName() {
        return itemName;
    }

    void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Double.compare(summary.itemPrice, itemPrice) == 0 && Double.compare(summary.deliveryCost, deliveryCost) == 0 && Double.compare(summary.totalPrice, totalPrice) == 0 && Objects.equals(userEmail, summary.userEmail) && Objects.equals(itemName, summary.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, itemName, itemPrice, deliveryCost, totalPrice);
    }

    @Override
    public String toString() {
        return "Summary{" +
                "userEmail='" + userEmail + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", deliveryCost=" + deliveryCost +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
