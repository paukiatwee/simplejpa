/**
 * 
 */
package simplejpa.user;

import java.io.Serializable;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 *
 */
@Entity
public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4958726687931337228L;
    private Long id;
    private String username;
    private String password;
    private String email;
    
    public User() {
        
    }
    
    public User(long id) {
        this.id = id;
    }
    
    public User(String username) {
        this.username = username;
    }
    
    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the username
     */
    @Column(unique = true)
    public String getUsername() {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the email
     */
    @Column(unique = true)
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public static void main(String[] args) {
        SortedSet<Float> randoms = new TreeSet<Float>();
        Random random = new Random();
        while(randoms.size() < 5) {
            randoms.add(random.nextFloat());
        }
        for(Float r: randoms) {
            System.out.println(r);
        }
    }
    
}
