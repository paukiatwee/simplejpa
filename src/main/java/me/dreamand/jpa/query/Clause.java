/**
 * 
 */
package me.dreamand.jpa.query;

/**
 * 
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 1.0.0
 */
public enum Clause {
    
    EQUAL(" = "),
    NOT_EQUAL(" != "),
    LESS(" < "),
    LESS_OR_EQUAL(" <= "),
    MORE(" > "),
    MORE_OR_EQUAL(" >= "),
    LIKE(" LIKE ");

    private final String operator;
    
    Clause(String operator) {
        this.operator = operator;
    }
    
    public String getOperator() {
        return operator;
    }
}
