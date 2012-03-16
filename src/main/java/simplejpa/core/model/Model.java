/**
 * 
 */
package simplejpa.core.model;

import java.io.Serializable;

/**
 *
 */
public interface Model<T extends Serializable> extends Serializable {
    
    T getId();
    void setId(T id);

}
