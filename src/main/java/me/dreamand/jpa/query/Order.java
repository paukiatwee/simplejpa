/**
 * 
 */
package me.dreamand.jpa.query;

/**
 * 
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 1.0.0
 */
public enum Order {
    ASC(" ASC"),
    DESC(" DESC");
    
    private final String operator;
    
    Order(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
