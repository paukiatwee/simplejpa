/**
 * 
 */
package me.dreamand.jpa.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 1.0.0
 */
public class Password {
    
    
    private String current;
    private String password; 
    private String verify;
    

    /**
     * @return the current password
     */
    @NotNull
    @Size.List({@Size(min = 6, message = "Password need at least 6 characters")})
    public String getCurrent() {
        return current;
    }

    /**
     * @param current set current password
     */
    public void setCurrent(String current) {
        this.current = current;
    }

    /**
     * @return new password
     */
    @NotNull
    @Size.List({@Size(min = 6, message = "Password need at least 6 characters")})
    public String getPassword() {
        return password;
    }

    /**
     * @param password new password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the verify
     */
    @NotNull
    @Size.List({@Size(min = 1, message = "Please fill in this field")})
    public String getVerify() {
        return verify;
    }

    /**
     * @param verify verify password to be set
     */
    public void setVerify(String verify) {
        this.verify = verify;
    }

    public void clear() {
        setCurrent("");
        setPassword("");
        setVerify("");
    }
    
    
    public boolean isMatch() {
        if(getPassword() != null && getVerify() != null && getPassword().equals(getVerify())) {
            return true;
        } else {
            clear();
            return false;
        }
    }
}
