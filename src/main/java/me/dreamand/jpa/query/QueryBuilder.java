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
    private StringBuilder builder = new StringBuilder();
    private String from;
    private char alias;
    
    public QueryBuilder from(String from) {
        this.from = from;
        this.alias = from.toLowerCase().toCharArray()[0];
        builder
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
            builder
                .append(" WHERE ")
                .append(alias)
                .append(".")
                .append(property)
                .append(clause.getOperator())
                .append(":")
                .append(parameter);
            firstClause = false;
        } else {
            builder
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
            builder
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
            builder
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
    
    public Query build() {
        return new Query("SELECT " + alias + builder.toString(), "SELECT COUNT(" + alias +")" + builder.toString());
    }
}
