/**
 * 
 */
package me.dreamand.jpa.model;

/**
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 0.1
 */
public enum Role {
    
    ROOT("Root", "ROLE_ROOT"),
    ADMIN("Admin", "ROLE_ADMIN"),
    USER("User", "ROLE_USER");
    
    
    private final String displayName;
    private final String role;
    Role (String displayName, String role) {
        this.displayName = displayName;
        this.role = role;
    }

    public String getDisplayName() {
        return displayName;
    }
    public String getRole() {
        return role;
    }
}
