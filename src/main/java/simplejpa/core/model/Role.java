/**
 * 
 */
package simplejpa.core.model;

/**
 *
 */
public enum Role {
    
    ROOT("Member", "ROLE_ROOT"),
    ADMIN("Ambassador", "ROLE_ADMIN"),
    USER("Admin", "ROLE_USER");
    
    
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
