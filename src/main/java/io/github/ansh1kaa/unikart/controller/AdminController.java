package io.github.ansh1kaa.unikart.controller;

import io.github.ansh1kaa.unikart.models.Buyer;
import io.github.ansh1kaa.unikart.models.Seller;
import io.github.ansh1kaa.unikart.models.Product;
import io.github.ansh1kaa.unikart.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling admin-related operations.
 * Provides endpoints to manage sellers, buyers, users, products, and sales reports.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    /**
     * The service that handles admin business logic.
     */
    @Autowired
    private AdminService adminService;

    /**
     * Retrieves a list of all registered sellers.
     *
     * @return list of {@link Seller}
     */
    @GetMapping("/sellers")
    public List<Seller> getSellers() {
        return adminService.getAllSellers();
    }

    /**
     * Retrieves a list of all registered buyers.
     *
     * @return list of {@link Buyer}
     */
    @GetMapping("/buyers")
    public List<Buyer> getBuyers() {
        return adminService.getAllBuyers();
    }

    /**
     * Approves a seller by their ID.
     *
     * @param id the ID of the seller to approve
     */
    @PutMapping("/sellers/{id}/approve")
    public void approveSeller(@PathVariable Long id) {
        adminService.approveSeller(id);
    }

    /**
     * Blocks a seller by their ID.
     *
     * @param id the ID of the seller to block
     */
    @PutMapping("/sellers/{id}/block")
    public void blockSeller(@PathVariable Long id) {
        adminService.blockSeller(id);
    }

    /**
     * Deletes a user (buyer or seller) by their ID and role.
     *
     * @param id   the ID of the user to delete
     * @param role the role of the user ("BUYER" or "SELLER")
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id, @RequestParam String role) {
        adminService.deleteUser(id, role);
    }

    /**
     * Suspends a user (buyer or seller) by their ID and role.
     *
     * @param id   the ID of the user to suspend
     * @param role the role of the user ("BUYER" or "SELLER")
     */
    @PutMapping("/users/{id}/suspend")
    public void suspendUser(@PathVariable Long id, @RequestParam String role) {
        adminService.suspendUser(id, role);
    }

    /**
     * Retrieves a list of all products in the system.
     *
     * @return list of {@link Product}
     */
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return adminService.getAllProducts();
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to remove
     */
    @DeleteMapping("/products/{id}")
    public void removeProduct(@PathVariable Long id) {
        adminService.removeProduct(id);
    }

    /**
     * Retrieves the sales report.
     *
     * @return a {@link String} containing the sales report
     */
    @GetMapping("/sales-report")
    public String getSalesReport() {
        return adminService.getSalesReport();
    }
}
