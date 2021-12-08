package ECommercePublishSubscribeFeed.models;

public class Seller {
    int sellerId;
    final int rating;
    static int lastSellerId = 0;

    public Seller(int rating) {
        this.rating = rating;
        this.lastSellerId = this.lastSellerId+1;
        this.sellerId = lastSellerId;
        System.out.println("Seller Id created : " + this.sellerId);
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getRating() {
        return rating;
    }
}
