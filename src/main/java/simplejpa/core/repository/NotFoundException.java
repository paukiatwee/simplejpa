/**
 * 
 */
package simplejpa.core.repository;

/**
 *
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
     * @param message
     * @param cause
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public NotFoundException(Throwable cause) {
        super(cause);
    }
    
    

}
