/**
 * 
 */
package me.dreamand.jpa.model;

/**
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 0.1
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
