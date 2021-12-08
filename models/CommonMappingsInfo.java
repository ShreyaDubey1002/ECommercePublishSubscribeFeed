package ECommercePublishSubscribeFeed.models;

import java.util.HashMap;

public class CommonMappingsInfo {
    HashMap<Integer, Customer> customerIdToCustomerObject;
    HashMap<Integer, Seller> sellerIdToSellerObject;
    HashMap<Integer, Post> postIdToPostObject;

    public CommonMappingsInfo() {
        this.customerIdToCustomerObject = new HashMap<Integer, Customer>();
        this.sellerIdToSellerObject = new HashMap<Integer, Seller>();
        this.postIdToPostObject = new HashMap<Integer, Post>();
    }

    public HashMap<Integer, Customer> getCustomerIdToCustomerObject() {
        return customerIdToCustomerObject;
    }

    public void setCustomerIdToCustomerObject(HashMap<Integer, Customer> customerIdToCustomerObject) {
        this.customerIdToCustomerObject = customerIdToCustomerObject;
    }

    public HashMap<Integer, Seller> getSellerIdToSellerObject() {
        return sellerIdToSellerObject;
    }

    public void setSellerIdToSellerObject(HashMap<Integer, Seller> sellerIdToSellerObject) {
        this.sellerIdToSellerObject = sellerIdToSellerObject;
    }

    public HashMap<Integer, Post> getPostIdToPostObject() {
        return postIdToPostObject;
    }

    public void setPostIdToPostObject(HashMap<Integer, Post> postIdToPostObject) {
        this.postIdToPostObject = postIdToPostObject;
    }
}
