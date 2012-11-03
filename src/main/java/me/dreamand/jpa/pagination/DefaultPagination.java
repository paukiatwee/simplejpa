/**
 * 
 */
package me.dreamand.jpa.pagination;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 1.0.0
 */
public class DefaultPagination<T> implements Pagination<T>{
    private int currentPage;
    private int size;
    private int maxResult;
    private List<T> items;
    
    public DefaultPagination() {
        this.currentPage = 1;
        this.maxResult = 10;
        this.size = 0;
        this.items = new ArrayList<T>();
        if((this.currentPage - 1) * this.maxResult > size) {
            this.currentPage = 1;
        }
    }
    public DefaultPagination(int currentPage, int maxResult, int size, List<T> items) {
        this.currentPage = currentPage;
        this.maxResult = maxResult;
        this.size = size;
        this.items = items;
        if((this.currentPage - 1) * this.maxResult > size) {
            this.currentPage = 1;
        }
    }
    
    /**
     * @return the currentPage
     */
    @Override
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @return the size
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * @return the itemPerPage
     */
    @Override
    public int getMaxResult() {
        return maxResult;
    }

    /**
     * @return the totalPages
     */
    @Override
    public int getTotalPages() {
        int totalPages = (int)Math.ceil(size / (float)maxResult);
        if(totalPages == 0) {
            totalPages = 1;
        }
        return totalPages;
    }
    /**
     * @return the results
     */
    @Override
    public List<T> getItems() {
        return items;
    }
    @Override
    public List<Page> getPages() {
        List<Page> pagar = new ArrayList<Page>();
        int pages = getTotalPages();
        int divide = 5;
        if(pages > divide * 2 + 2) {
            int start = 1;
            if(getCurrentPage() - divide > 1) {
                start = getCurrentPage() - divide;
            }
            
            int end = start + divide * 2;
            if(end > getTotalPages()) {
                start -= divide;
                end = getTotalPages();
            }
            for(int count = start; count <= end; count++) {
                pagar.add(new Page(count, isFirst(), isLast(), count == getCurrentPage()));
            }
        } else {
            for(int count = 0; count < pages; count++) {
                pagar.add(new Page(count + 1, currentPage == 0, currentPage == (getTotalPages() -1), (count + 1) == currentPage));
            }
        }
        return pagar;
    }
    @Override
    public boolean isLast() {
        return getCurrentPage() == getTotalPages();
    }
    @Override
    public boolean isFirst() {
        return getCurrentPage() <= 1;
    }
    @Override
    public int getPrevious() {
        return getCurrentPage() - 1;
    }
    @Override
    public int getNext() {
        return getCurrentPage() + 1;
    }
}
