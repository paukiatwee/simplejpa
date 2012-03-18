/**
 * 
 */
package simplejpa.core.model;

import java.io.Serializable;

/**
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 0.1
 */
public interface Model<T extends Serializable> extends Serializable {
    
    T getId();
    void setId(T id);

}
