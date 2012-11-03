package me.dreamand.jpa.model;

/**
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 0.1
 */
public enum Status {
    
    NEW("New"),
    REJECTED("Rejected"),
    APPROVED("Approved"),
    IN_PROGRESS("In Progress"),
    PENDING("Pending"),
    CANCEL("Cancel"),
    CLOSE("Close");
    
    private final String name;

    Status(final String name) {
        this.name = name;
    }
    public String getDisplayName() {
        return name;
    }

}
