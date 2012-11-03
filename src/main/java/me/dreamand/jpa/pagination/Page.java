/**
 * 
 */
package me.dreamand.jpa.pagination;

/**
 * 
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 1.0.0
 */
public class Page {
    private int index;
    private boolean isFirst;
    private boolean isLast;
    private boolean active;
    
    

    public Page(int index, boolean isFirst, boolean isLast, boolean active) {
        this.index = index;
        this.isFirst = isFirst;
        this.isLast = isLast;
        this.active = active;
    }

    public int getIndex() {
        return index;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public boolean isLast() {
        return isLast;
    }

    public boolean isActive() {
        return active;
    }
    
}
