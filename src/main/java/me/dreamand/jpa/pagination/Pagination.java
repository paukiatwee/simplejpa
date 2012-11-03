/**
 * 
 */
package me.dreamand.jpa.pagination;

import java.util.List;

/**
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 0.1
 */
public interface Pagination<T> {
    
    /**
     * @return current page index
     */
    int getCurrentPage();
    /**
     * @return the size of the total items in the persistence storage
     */
    int getSize();
    /**
     * @return the maximum result size return from persistence storage
     */
    int getMaxResult();
    /**
     * @return the total pages formed by the total items and maximum results
     */
    int getTotalPages();
    /**
     * @return the portion of the items from persistence storage
     */
    List<T> getItems();
    /**
     * @return the list of the pages formed
     */
    List<Page> getPages();
    
    boolean isLast();
    boolean isFirst();
    int getPrevious();
    int getNext();
}
