/**
 * 
 */
package me.dreamand.jpa.repository;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;

import javax.persistence.metamodel.SingularAttribute;

import me.dreamand.jpa.pagination.Pagination;
import me.dreamand.jpa.query.Specification;


/**
 * 
 * @author Pau Kiat Wee (mailto:paukiatwee@gmail.com)
 * @since 1.0.0
 */
public interface DefaultRepository {
    /**
     * This is method is create a model
     * @param <T> the type of the model
     * @param model
     * @return model created by underlying data store
     *               with key generated if any
     */
    <T> T create(T model);
    /**
     * This is method is used to find specific model based on
     * the model's ID
     * @param <T> type of the model
     * @param model
     * @return model found by using model's ID
     * @throws NotFoundException when the model is not found
     */
    <T> T read(T model) throws NotFoundException;
    /**
     * This method is used to read multiple <code>Model</code>
     * from data store based on the model's ID
     * @param <T> type of the model
     * @param models list of the models to read from data store
     * @return models from data store or empty <code>ArrayList<T></code>
     * @throws NotFoundException when one of the model is not found
     */
    <T> List<T> read(List<T> models) throws NotFoundException;
    /**
     * This method is used to update single <code>model</code>
     * @param <T> type of the model
     * @param model need to be update
     * @return model after update
     */
    <T> T update(T model);
    /**
     * This method will delete single model from data store based
     * on the model's ID. If the model does not
     * exist in data store, the operation is silently failed.
     * @param <T> type of the model
     * @param model need to be delete from data store
     */
    <T> void delete(T model) throws NotFoundException;
    /**
     * This method will delete multiple models from data store based
     * on the models' IDs. If the models does not
     * exist in data store, the operation is silently failed.
     * @param <T> the model extended from <code>Model</code>
     * @param models need to be delete from data store
     */
    <T> void delete(List<T> models) throws NotFoundException;
    
    /**
     * Get all of the models which is type of <code>type</code>
     * @param type of the model query from data store
     * @return list of the models, null safe
     */
    <T> List<T> getAll(Class<T> type);
    /**
     * Get list of models, slice based on {@link int getItemsPerPage();} as limit
     * @param type of the model query from data store
     * @param page the index of the slice get from data store
     * @return list of the models, null safe
     */
    <T> List<T> getSlice(Class<T> type, int page);
    /**
     * Get list of models, sorted based on model's attributes.
     * @param type of the model query from data store
     * @param page the index of the slice get from data store
     * @param asc true for ascending, false for descending
     * @param attributes list of attributes that used to do sorting
     * @return list of models that sorted by <coded>attributes</code>, null safe
     */
    <E, T> List<E> getSlice(Class<E> type, int page, boolean asc, List<SingularAttribute<E, T>> attributes);

    /**
     * Get list of models with limit, sorted based on model's attributes.
     * @param type of the model query from data store
     * @param page the index of the slice get from data store
     * @param asc true for ascending, false for descending
     * @param attributes list of attributes that used to do sorting
     * @param limit of the items
     * @return list of models that sorted by <coded>attributes</code>, null safe
     */
    <E, T> List<E> getSlice(Class<E> type, int page, boolean asc, List<SingularAttribute<E, T>> attributes, int limit);
    /**
     * @param type of the model query from data store
     * @param page the index of the slice get from data store
     * @return pagination of the models
     */
    <T> Pagination<T> getPage(Class<T> type, int page);
    /**
     * @param attribute
     * @param value
     * @param page
     * @return pagination of the models
     */
    <E, T> Pagination<E> getPage(SingularAttribute<E, T> attribute, T value, int page);
    /**
     * @param type of the model query from data store
     * @param page the index of the slice get from data store
     * @param asc sorting is ascending?
     * @param attributes used to sort
     * @return pagination of the models
     */
    <E, T> Pagination<E> getPage(Class<E> type, int page, boolean asc, List<SingularAttribute<E, T>> attributes);

    /**
     * Return list of models as pagination.
     * @param type of the model query from data store
     * @param page the index of the slice get from data store
     * @param asc sorting is ascending?
     * @param attributes used to sort.
     * @param limit item per page
     * @return pagination of the models
     */
    <E, T> Pagination<E> getPage(Class<E> type, int page, boolean asc, List<SingularAttribute<E, T>> attributes, int limit);
    
    <E, T> Pagination<E> getPage(Class<E> type, int page, String query, String count, int limit, Map<String, Object> parameters);
    
    /**
     * @param type of the model query from data store
     * @param property
     * @param value
     * @return
     */
    <T> List<T> search(Class<T> type, String property, String value);
    /**
     * @param type of the model query from data store
     * @param keyword to search
     * @param page the index of the slice get from data store
     * @param attributes used to search
     * @return pagination of the models
     */
    <E> Pagination<E> search(Class<E> type, String keyword, int page, SingularAttribute<E, String>... attributes);
    /**
     * @param type of the model query from data store
     * @param keyword to search
     * @param page the index of the slice get from data store
     * @param attributes used to search
     * @return pagination of the models
     */
    <E, T> Pagination<E> search(Class<E> type, T keyword, int page, SingularAttribute<E, T>... attributes);
    /**
     * @param type of the model query from data store
     * @return count of the model type <code>type</code> in data store
     */
    <T> long getCount(Class<T> type);

    /**
     * @param attribute
     * @param value
     * @return
     */
    <E, T> long getCount(SingularAttribute<E, T> attribute, T value);
    
    long getCount(String count, Map<String, Object> parameters);
    /**
     * @param attribute used to compare with value <code>value</code>
     * @param value to be used to do comparison
     * @return List of the models where <code>attribute</code> equals <code>value</code>
     */
    <E, T> List<E> getMore(SingularAttribute<E, T> attribute,T value);
    /**
     * @param attribute used to compare with value <code>value</code>
     * @param value to be used to do comparison
     * @param limit of the size of the list to be returned
     * @return List of the models where <code>attribute</code> equals <code>value</code> and limit to <code>limit</code>
     */
    <E, T> List<E> getMore(SingularAttribute<E, T> attribute,T value, int limit);
    /**
     * @param attribute used to compare with value <code>value</code>
     * @param value to be used to do comparison
     * @param limit of the size of the list to be returned
     * @param page the index of the slice get from data store
     * @return List of the models match the criteria
     */
    <E, T> List<E> getMore(SingularAttribute<E, T> attribute,T value, int limit, int page);
    /**
     * @param attribute
     * @param limit
     * @return
     */
    <E, T> List<E> getMore(SingularAttribute<E, T> attribute, int limit);
    /**
     * @param attribute
     * @param asc
     * @return
     */
    <E, T> List<E> getOrderBy(SingularAttribute<E, T> attribute, boolean asc);
    /**
     * @param attribute
     * @param limit
     * @param asc
     * @return
     */
    <E, T> List<E> getOrderBy(SingularAttribute<E, T> attribute, int limit, boolean asc);
    /**
     * @param attribute
     * @return
     */
    <E, T> List<E> getGroupBy(SingularAttribute<E, T> attribute);
    /**
     * @param attribute
     * @param value
     * @return
     */
    <E, T> E getOne(SingularAttribute<E, T> attribute, T value) throws NotFoundException, NonUniqueResultException;

    <T> T getOne(Class<T> type, Specification<T> spec) throws NotFoundException, NonUniqueResultException;
    
    <T> List<T> getListOf(Class<T> type, String query);
    
    <T> List<T> getListOf(Class<T> type, String query, int page, Map<String, Object> parameters);
    
    <T> List<T> getListOf(Class<T> type, String query, int page, int limit, Map<String, Object> parameters);

    <T> List<T> getListOf(Class<T> type, Specification<T> spec);
    
    
    /**
     * Update model
     */
    int bulkChange(String query);
    /**
     * @param itemPerPage
     */
    void setItemsPerPage(int itemPerPage);
    /**
     * @return
     */
    int getItemsPerPage();

    EntityManager getEntityManager();
}
