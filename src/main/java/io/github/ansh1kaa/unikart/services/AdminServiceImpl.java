package io.github.ansh1kaa.unikart.services;

import io.github.ansh1kaa.unikart.models.Buyer;
import io.github.ansh1kaa.unikart.models.Seller;
import io.github.ansh1kaa.unikart.models.Product;
import io.github.ansh1kaa.unikart.repository.BuyerRepository;
import io.github.ansh1kaa.unikart.repository.SellerRepository;
import io.github.ansh1kaa.unikart.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation class for handling admin-related operations.
 * This class provides business logic for managing sellers, buyers, products,
 * user suspensions, deletions, and sales reporting.
 */
@Service
public class AdminServiceImpl implements AdminService {

    /**
     * Repository for managing seller entities.
     */
    @Autowired
    private SellerRepository sellerRepository;

    /**
     * Repository for managing buyer entities.
     */
    @Autowired
    private BuyerRepository buyerRepository;

    /**
     * Repository for managing product entities.
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieves all sellers in the system.
     *
     * @return list of {@link Seller}
     */
    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    /**
     * Retrieves all buyers in the system.
     *
     * @return list of {@link Buyer}
     */
    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    /**
     * Approves a seller by setting their approved status to true.
     *
     * @param sellerId the ID of the seller to approve
     */
    @Override
    public void approveSeller(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow();
        seller.setApproved(true);
        sellerRepository.save(seller);
    }

    /**
     * Blocks a seller by setting their approved status to false.
     *
     * @param sellerId the ID of the seller to block
     */
    @Override
    public void blockSeller(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow();
        seller.setApproved(false);
        sellerRepository.save(seller);
    }

    /**
     * Deletes a user (buyer or seller) based on their role.
     *
     * @param userId the ID of the user to delete
     * @param role   the role of the user ("BUYER" or "SELLER")
     */
    @Override
    public void deleteUser(Long userId, String role) {
        if (role.equalsIgnoreCase("BUYER")) {
            buyerRepository.deleteById(userId);
        } else if (role.equalsIgnoreCase("SELLER")) {
            sellerRepository.deleteById(userId);
        }
    }

    /**
     * Suspends a user (buyer or seller) by setting their suspended status to true.
     *
     * @param userId the ID of the user to suspend
     * @param role   the role of the user ("BUYER" or "SELLER")
     */
    @Override
    public void suspendUser(Long userId, String role) {
        if (role.equalsIgnoreCase("BUYER")) {
            Buyer buyer = buyerRepository.findById(userId).orElseThrow();
            buyer.setSuspended(true);
            buyerRepository.save(buyer);
        } else if (role.equalsIgnoreCase("SELLER")) {
            Seller seller = sellerRepository.findById(userId).orElseThrow();
            seller.setSuspended(true);
            sellerRepository.save(seller);
        }
    }

    /**
     * Retrieves all products in the system.
     *
     * @return list of {@link Product}
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Removes a product by its ID.
     *
     * @param productId the ID of the product to remove
     */
    @Override
    public void removeProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    /**
     * Generates a sales report by calculating the total sales amount.
     *
     * @return a formatted string containing the total sales value
     */
    @Override
    public String getSalesReport() {
        Double totalSales = productRepository.sumAllSales(); // This method must be implemented in ProductRepository
        return "Total Sales: ₹" + totalSales;
    }
}
