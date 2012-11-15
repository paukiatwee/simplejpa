/**
 * 
 */
package me.dreamand.jpa.query;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 1.0.0
 */
public class QueryBuilderTest {
    
    @Test
    public void shouldSelectAll() {
        QueryBuilder builder = builder();
        Query q = builder.from("User").build();
        assertEquals("SELECT u FROM User u", q.getQuery());
        assertEquals("SELECT COUNT(u) FROM User u", q.getCount());
    }
    
    @Test
    public void shouldAddSingleWhereClause() {
        QueryBuilder builder = builder();
        builder
            .from("User")
            .where("friend", Clause.EQUAL);
        Query q = builder.build();
        assertEquals("SELECT u FROM User u WHERE u.friend = :friend", q.getQuery());
        assertEquals("SELECT COUNT(u) FROM User u WHERE u.friend = :friend", q.getCount());
    }
    
    
    @Test
    public void shouldAddMultipleWhereClause() {
        QueryBuilder builder = builder();
        builder
            .from("User")
            .where("friend", Clause.EQUAL)
            .where("name", Clause.EQUAL);
        Query q = builder.build();
        assertEquals("SELECT u FROM User u WHERE u.friend = :friend AND u.name = :name", q.getQuery());
        assertEquals("SELECT COUNT(u) FROM User u WHERE u.friend = :friend AND u.name = :name", q.getCount());
    }
    
    @Test
    public void shouldAddBetweenClause() {
        QueryBuilder builder = builder();
        builder
            .from("User")
            .between("friend", "min", "max");
        Query q = builder.build();
        assertEquals("SELECT u FROM User u WHERE u.friend BETWEEN :min AND :max", q.getQuery());
        assertEquals("SELECT COUNT(u) FROM User u WHERE u.friend BETWEEN :min AND :max", q.getCount());
    }
    
    @Test
    public void shouldAddWhereAndBetweenClause() {
        QueryBuilder builder = builder();
        builder
            .from("User")
            .where("name", Clause.EQUAL)
            .between("friend", "min", "max");
        Query q = builder.build();
        assertEquals("SELECT u FROM User u WHERE u.name = :name AND u.friend BETWEEN :min AND :max", q.getQuery());
        assertEquals("SELECT COUNT(u) FROM User u WHERE u.name = :name AND u.friend BETWEEN :min AND :max", q.getCount());
    }
    
    @Test
    public void shouldAddWheresAndBetweenClause() {
        QueryBuilder builder = builder();
        builder
            .from("User")
            .where("name", Clause.EQUAL)
            .where("location", Clause.EQUAL)
            .between("friend", "min", "max");
        Query q = builder.build();
        assertEquals("SELECT u FROM User u WHERE u.name = :name AND u.location = :location AND u.friend BETWEEN :min AND :max", q.getQuery());
        assertEquals("SELECT COUNT(u) FROM User u WHERE u.name = :name AND u.location = :location AND u.friend BETWEEN :min AND :max", q.getCount());
    }
    
    @Test
    public void shouldReturnCorrectOrderBy() {
        QueryBuilder builder = builder();
        builder
            .from("User")
            .order("id");
        Query q = builder.build();
        assertEquals("SELECT u FROM User u ORDER BY u.id DESC", q.getQuery());
        assertEquals("SELECT COUNT(u) FROM User u", q.getCount());
    }
    
    @Test
    public void shouldAbleAddWhereClauseAndOrderTheResult() {
        QueryBuilder builder = builder();
        builder
            .from("User")
            .where("friend", Clause.EQUAL)
            .order("id");
        Query q = builder.build();
        assertEquals("SELECT u FROM User u WHERE u.friend = :friend ORDER BY u.id DESC", q.getQuery());
        assertEquals("SELECT COUNT(u) FROM User u WHERE u.friend = :friend", q.getCount());
    }
    
    @Test
    public void shouldAbleAddWhereClauseAndBetweenClauseAndOrderTheResult() {
        QueryBuilder builder = builder();
        builder
            .from("User")
            .where("join", Clause.LESS_OR_EQUAL)
            .between("friend", "min", "max")
            .order("id");
        Query q = builder.build();
        assertEquals("SELECT u FROM User u WHERE u.join <= :join AND u.friend BETWEEN :min AND :max ORDER BY u.id DESC", q.getQuery());
        assertEquals("SELECT COUNT(u) FROM User u WHERE u.join <= :join AND u.friend BETWEEN :min AND :max", q.getCount());
    }
    
    private QueryBuilder builder() {
        return new QueryBuilder();
    }

}
