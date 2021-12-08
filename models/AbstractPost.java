package ECommercePublishSubscribeFeed.models;

public abstract class AbstractPost {
    int postId;
    static int lastPostId = 0;
    String productName;
    Double price;

    AbstractPost(String productName, Double price) {
        this.lastPostId = this.lastPostId+1;
        this.postId = this.lastPostId;
        this.productName = productName;
        this.price = price;
        System.out.println("Post id created : " +  this.postId);
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        postId = postId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
