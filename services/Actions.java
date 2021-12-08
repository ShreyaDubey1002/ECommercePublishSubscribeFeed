package ECommercePublishSubscribeFeed.services;

import ECommercePublishSubscribeFeed.models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class compareFunction implements Comparator<Post> {
    public int compare(Post p1, Post p2) {
        return p2.getPostId() - p1.getPostId();
    }
}

public class Actions {
    CommonMappingsInfo commonMappingsInfo;
    CustomerMappingsInfo customerMappingsInfo;
    SellerMappingsInfo sellerMappingsInfo;

    public Actions() {
        commonMappingsInfo = new CommonMappingsInfo();
        customerMappingsInfo = new CustomerMappingsInfo();
        sellerMappingsInfo = new SellerMappingsInfo();
    }

    public void createSeller(int rating) {
        Seller newSeller = new Seller(rating);
        commonMappingsInfo.getSellerIdToSellerObject().put(newSeller.getSellerId(), newSeller);
    }

    public void deleteSeller(int sellerId) {
        ArrayList<Integer> customerIds = sellerMappingsInfo.getSellerIdToCustomerIds().get(sellerId);
        for (Integer customerId : customerIds) {
            customerMappingsInfo.getCustomerIdToSellerIds().get(customerId).remove(sellerId);
        }
        ArrayList<Integer> postIds = sellerMappingsInfo.getSellerIdToPostIds().get(sellerId);
        for (Integer postId : postIds) {
            commonMappingsInfo.getPostIdToPostObject().remove(postId);
        }
        commonMappingsInfo.getSellerIdToSellerObject().remove(sellerId);
    }

    public void createCustomer() {
        Customer newCustomer = new Customer();
        commonMappingsInfo.getCustomerIdToCustomerObject().put(newCustomer.getCustomerId(), newCustomer);
    }

    public void subscribeToSeller(int customerId, int sellerId) {
        if (!customerMappingsInfo.getCustomerIdToSellerIds().containsKey(customerId)) {
            customerMappingsInfo.getCustomerIdToSellerIds().put(customerId, new ArrayList<>());
            System.out.println("Putting sellerID : " + sellerId + " to customerId : " + customerId);
        }

        System.out.println("Adding sellerID : " + sellerId + " to customerId : " + customerId);
        customerMappingsInfo.getCustomerIdToSellerIds().get(customerId).add(sellerId);

        if (!sellerMappingsInfo.getSellerIdToCustomerIds().containsKey(sellerId)) {
            sellerMappingsInfo.getSellerIdToCustomerIds().put(sellerId, new ArrayList<>());
        }

        sellerMappingsInfo.getSellerIdToCustomerIds().get(sellerId).add(customerId);
    }

    public void unsubscribeToSeller(int customerId, int sellerId) {
        if (!customerMappingsInfo.getCustomerIdToSellerIds().containsKey(customerId) ||
                !sellerMappingsInfo.getSellerIdToCustomerIds().containsKey(sellerId)) {
            return;
        }
        customerMappingsInfo.getCustomerIdToSellerIds().get(customerId).remove(sellerId);
        sellerMappingsInfo.getSellerIdToCustomerIds().get(sellerId).remove(customerId);
    }

    public void publishPost (int sellerId, String productName, Double price) {
        Post newPost = new Post (productName, price);
        commonMappingsInfo.getPostIdToPostObject().put(newPost.getPostId(), newPost);
        if (!sellerMappingsInfo.getSellerIdToPostIds().containsKey(sellerId)) {
            sellerMappingsInfo.getSellerIdToPostIds().put(sellerId, new ArrayList<>());
        }
        System.out.println("Adding postId " + newPost.getPostId() + " in publishPost "  + " to seller " + sellerId);
            sellerMappingsInfo.getSellerIdToPostIds().get(sellerId).add(newPost.getPostId());
    }

    public void deletePost (int sellerId, int postId) {

        commonMappingsInfo.getPostIdToPostObject().remove(postId);
        int index = sellerMappingsInfo.getSellerIdToPostIds().get(sellerId).indexOf(postId);
        sellerMappingsInfo.getSellerIdToPostIds().get(sellerId).remove(index);
    }

    public void fetchFeed(int customerId) {
        ArrayList<Post> posts = new ArrayList<Post>();
        System.out.println("customerId in fetchFeed " + customerId);
        ArrayList<Integer> sellerIds = customerMappingsInfo.getCustomerIdToSellerIds().get(customerId);
        System.out.println("Size in fetchFeed " + sellerIds.size());
        for (int sellerId : sellerIds) {
            System.out.println("Seller Id in fetchFeed : " + sellerId);
            ArrayList<Integer> postIds = sellerMappingsInfo.getSellerIdToPostIds().get(sellerId);
            if (postIds != null) {
                for (Integer postId : postIds) {
                    posts.add(commonMappingsInfo.getPostIdToPostObject().get(postId));
                }
            }
        }

        System.out.println("Size of posts in fetchFeed " + posts.size());
        Collections.sort(posts, new compareFunction());
        if (posts != null) {
            for (Post post : posts) {
                post.displayPost();
            }
        }
    }

}
