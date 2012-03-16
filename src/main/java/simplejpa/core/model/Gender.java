/**
 * 
 */
package simplejpa.core.model;

/**
 *
 */
public enum Gender {
    
    
    MALE("Male"),
    FEMALE("Female");
    
    private final String name;

    Gender(final String name) {
        this.name = name;
    }
    public String getDisplayName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }

}
