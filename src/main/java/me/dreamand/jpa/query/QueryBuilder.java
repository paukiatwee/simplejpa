/**
 * 
 */
package me.dreamand.jpa.query;

/**
 * 
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 1.0.0
 */
public class QueryBuilder {
    
    private boolean firstClause = true;
    private StringBuilder query = new StringBuilder();
    private StringBuilder count = new StringBuilder();
    private char alias;
    private boolean firstOrder = true;
    
    public QueryBuilder from(String from) {
        this.alias = from.toLowerCase().toCharArray()[0];
        query
            .append(" FROM ")
            .append(from)
            .append(" ")
            .append(alias);
        count
            .append(" FROM ")
            .append(from)
            .append(" ")
            .append(alias);
        return this;
    }
    
    public QueryBuilder where(String property, Clause clause) {
        return where(property, clause, property);
    }
    
    public QueryBuilder where(String property, Clause clause, String parameter) {
        if(firstClause) {
            query
                .append(" WHERE ")
                .append(alias)
                .append(".")
                .append(property)
                .append(clause.getOperator())
                .append(":")
                .append(parameter);
            count
                .append(" WHERE ")
                .append(alias)
                .append(".")
                .append(property)
                .append(clause.getOperator())
                .append(":")
                .append(parameter);
            firstClause = false;
        } else {
            query
                .append(" AND ")
                .append(alias)
                .append(".")
                .append(property)
                .append(clause.getOperator())
                .append(":")
                .append(parameter);
            count
                .append(" AND ")
                .append(alias)
                .append(".")
                .append(property)
                .append(clause.getOperator())
                .append(":")
                .append(parameter);
        }
        return this;
    }
    
    public QueryBuilder between(String property, String first, String second) {
        if(firstClause) {
            query
                .append(" WHERE ")
                .append(alias)
                .append(".")
                .append(property)
                .append(" BETWEEN :")
                .append(first)
                .append(" AND :")
                .append(second);
            count
                .append(" WHERE ")
                .append(alias)
                .append(".")
                .append(property)
                .append(" BETWEEN :")
                .append(first)
                .append(" AND :")
                .append(second);
            firstClause = false;
        } else {
            query
                .append(" AND ")
                .append(alias)
                .append(".")
                .append(property)
                .append(" BETWEEN :")
                .append(first)
                .append(" AND :")
                .append(second);
            count
                .append(" AND ")
                .append(alias)
                .append(".")
                .append(property)
                .append(" BETWEEN :")
                .append(first)
                .append(" AND :")
                .append(second);
        }
        return this;
    }
    
    public QueryBuilder order(String property) {
        return order(property, Order.DESC);
    }
    
    public QueryBuilder order(String property, Order order) {

        if(firstOrder) {
            firstOrder = false;
            query
                .append(" ORDER BY ")
                .append(alias)
                .append(".")
                .append(property)
                .append(order.getOperator());
        } else {
            query
                .append(", ")
                .append(alias)
                .append(".")
                .append(property)
                .append(order.getOperator());
        }
        return this;
    }
    
    public Query build() {
        return new Query("SELECT " + alias + query.toString(), "SELECT COUNT(" + alias +")" + count.toString());
    }
}
