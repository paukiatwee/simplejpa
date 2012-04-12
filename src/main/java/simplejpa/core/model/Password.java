/**
 * 
 */
package simplejpa.core.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 0.1
 */
public class Password {
    
    
    private String previous;
    private String password; 
    private String confirm;
    

    /**
     * @return the previous
     */
    @NotNull
    @Size.List({@Size(min = 1, message = "Please fill in this field")})
    public String getPrevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(String previous) {
        this.previous = previous;
    }

    /**
     * @return the password
     */
    @NotNull
    @Size.List({@Size(min = 1, message = "Please fill in this field")})
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
     * @return the confirm
     */
    @NotNull
    @Size.List({@Size(min = 1, message = "Please fill in this field")})
    public String getConfirm() {
        return confirm;
    }

    /**
     * @param confirm the confirm to set
     */
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public void clear() {
        setPrevious("");
        setPassword("");
        setConfirm("");
    }
    
    
    public boolean isMatch() {
        if(getPassword() != null && getConfirm() != null && getPassword().equals(getConfirm())) {
            return true;
        } else {
            clear();
            return false;
        }
    }
    
    
    

}
