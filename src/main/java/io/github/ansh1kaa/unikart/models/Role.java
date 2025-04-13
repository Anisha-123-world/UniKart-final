package io.github.ansh1kaa.unikart.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Role {
    @Id
    private String role;
    private String roledescription;
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getDescription() {
        return roledescription;
    }
    public void setDescription(String description) {
        this.roledescription = description;
    }


}
