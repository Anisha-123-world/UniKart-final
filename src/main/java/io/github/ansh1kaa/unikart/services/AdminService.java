package io.github.ansh1kaa.unikart.services;

import io.github.ansh1kaa.unikart.models.Buyer;
import io.github.ansh1kaa.unikart.models.Seller;
import io.github.ansh1kaa.unikart.models.Product;

import java.util.List;

/**
 * AdminService defines the operations that can be performed by an admin user.
 * It includes functionalities to manage sellers, buyers, products, and generate sales reports.
 */
public interface AdminService {

    /**
     * Retrieves all sellers registered in the system.
     *
     * @return a list of {@link Seller} objects
     */
    List<Seller> getAllSellers();

    /**
     * Retrieves all buyers registered in the system.
     *
     * @return a list of {@link Buyer} objects
     */
    List<Buyer> getAllBuyers();

    /**
     * Approves a seller account by setting its approved status to true.
     *
     * @param sellerId the ID of the seller to be approved
     */
    void approveSeller(Long sellerId);

    /**
     * Blocks a seller account by setting its approved status to false.
     *
     * @param sellerId the ID of the seller to be blocked
     */
    void blockSeller(Long sellerId);

    /**
     * Deletes a user (buyer or seller) based on their role.
     *
     * @param userId the ID of the user to be deleted
     * @param role   the role of the user ("BUYER" or "SELLER")
     */
    void deleteUser(Long userId, String role);

    /**
     * Suspends a user (buyer or seller) by updating their suspended status.
     *
     * @param userId the ID of the user to be suspended
     * @param role   the role of the user ("BUYER" or "SELLER")
     */
    void suspendUser(Long userId, String role);

    /**
     * Retrieves all products listed in the system.
     *
     * @return a list of {@link Product} objects
     */
    List<Product> getAllProducts();

    /**
     * Removes a product from the system using its ID.
     *
     * @param productId the ID of the product to be removed
     */
    void removeProduct(Long productId);

    /**
     * Generates a basic sales report summarizing total sales.
     *
     * @return a string representing the sales report
     */
    String getSalesReport();
}
