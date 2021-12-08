package ECommercePublishSubscribeFeed.models;

public class Post extends AbstractPost{
    public Post(String productName, Double price) {
       super(productName, price);
    }

    public void displayPost() {
        System.out.print("postId : " + postId + ", " +
                        "productName : " + productName + ", " +
                        "price : " + price);
        System.out.println();
    }
}
