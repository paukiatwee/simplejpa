/**
 * 
 */
package me.dreamand.jpa.repository;


/**
 * 
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 1.0.0
 */
public class NotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -5524998194428543220L;

    /**
     * 
     */
    public NotFoundException() {
        super();
    }

    /**
     * @param message the message
     * @param cause the cause
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message the messaage
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * @param cause the cause
     */
    public NotFoundException(Throwable cause) {
        super(cause);
    }
    
    

}
