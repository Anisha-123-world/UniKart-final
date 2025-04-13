package io.github.ansh1kaa.unikart.models;

import java.util.Objects;

/**
 * Represents an Admin user in the UniKart system.
 * This class contains details like ID, username, password, and role of the admin.
 */
public class Admin {

    /**
     * The unique identifier of the admin.
     */
    private Long id;

    /**
     * The username used by the admin to log in.
     */
    private String username;

    /**
     * The password associated with the admin account.
     */
    private String password;

    /**
     * The role of the user, which defaults to "ADMIN".
     */
    private String role = "ADMIN";

    /**
     * Default constructor.
     */
    public Admin() {
    }

    /**
     * Constructs an Admin with the specified details.
     *
     * @param id       the unique ID of the admin
     * @param username the username of the admin
     * @param password the password of the admin
     * @param role     the role of the admin
     */
    public Admin(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Returns the ID of the admin.
     *
     * @return the admin's ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the admin.
     *
     * @param id the new ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the username of the admin.
     *
     * @return the admin's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the admin.
     *
     * @param username the new username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the admin.
     *
     * @return the admin's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the admin.
     *
     * @param password the new password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the role of the admin.
     *
     * @return the admin's role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the admin.
     *
     * @param role the new role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Compares this admin with another object for equality.
     *
     * @param o the object to compare
     * @return true if the given object is equal to this admin
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id)
                && Objects.equals(username, admin.username)
                && Objects.equals(password, admin.password)
                && Objects.equals(role, admin.role);
    }

    /**
     * Returns the hash code for this admin.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }

    /**
     * Returns a string representation of the admin.
     *
     * @return a string describing the admin
     */
    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
