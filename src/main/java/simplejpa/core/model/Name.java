/**
 * 
 */
package simplejpa.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 *
 */
@Embeddable
public class Name implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3569790912704580043L;

    @Size(max = 128)
    @Column(length = 128)
    private String first;
    @Size(max = 128)
    @Column(length = 128)
    private String middle;
    @Size(max = 128)
    @Column(length = 128)
    private String last;
    /**
     * @return the first
     */
    public String getFirst() {
        return safe(first);
    }
    /**
     * @param first the first to set
     */
    public void setFirst(String first) {
        this.first = first;
    }
    
    /**
     * @return the middle
     */
    public String getMiddle() {
        return safe(middle);
    }
    /**
     * @param middle the middle to set
     */
    public void setMiddle(String middle) {
        this.middle = middle;
    }
    /**
     * @return the last
     */
    public String getLast() {
        return safe(last);
    }
    /**
     * @param last the last to set
     */
    public void setLast(String last) {
        this.last = last;
    }
    
    public String getDisplayName() {
        return getLast() + " " + getFirst();
    }
    
    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("[first: ").append(getFirst()).append(", middle: ").append(getMiddle()).append(", last: ").append(getLast()).append("]");
        
        return buffer.toString();
    }

    protected String safe(String s) {
        return s == null?
                "":
                s;
    }
}
