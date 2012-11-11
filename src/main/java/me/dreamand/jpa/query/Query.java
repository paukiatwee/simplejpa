/**
 * 
 */
package me.dreamand.jpa.query;

/**
 * 
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 1.0.0
 */
public class Query {
    
    private String query;
    private String count;
    
    public Query(String query, String count) {
        this.query = query;
        this.count = count;
    }
    
    public String getCount() {
        return count;
    }
    
    public String getQuery() {
        return query;
    }
}
