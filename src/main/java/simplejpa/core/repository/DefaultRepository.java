/**
 * 
 */
package simplejpa.core.repository;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import simplejpa.core.repository.NotFoundException;
import simplejpa.core.model.Model;
import simplejpa.core.pagination.Pagination;



/**
 *
 */
public interface DefaultRepository {
	/**
	 * This is method is create a model
	 * @param <T> the model extended from <code>Model</code>
	 * @param model
	 * @return model created by underlying data store
	 * 				 with key generated
	 */
	<T extends Model<?>> T create(T model);
	/**
	 * This is method is used to find specific model based on
	 * the <code>model.getId()</code>
	 * @param <T> the model extended from <code>Model</code>
	 * @param model
	 * @return model found by using <code>T.getId()</code>
	 */
	<T extends Model<?>> T read(T model) throws NotFoundException;
	/**
	 * This method is used to read multiple <code>Model</code>
	 * from data store based on the <code>T.getId()</code> method
	 * @param <T> the model extended from <code>Model</code>
	 * @param models from system input
	 * @return models from data store or empty <code>ArrayList<T></code>
	 */
	<T extends Model<?>> List<T> read(List<T> models);
	/**
	 * This method is used to update single <code>model</code>
	 * @param <T> the model extended from <code>Model</code>
	 * @param model need to be update
	 * @return model after update
	 */
	<T extends Model<?>> T update(T model);
	/**
	 * This method will delete single model from data store based
	 * on the <code>T.getId()</code> method. If the model does not
	 * exist in data store, the operation is silently failed.
	 * @param <T> the model extended from <code>Model</code>
	 * @param model need to be delete from data store
	 */
	<T extends Model<?>> void delete(T model) throws NotFoundException;
	/**
	 * This method will delete multiple models from data store based
	 * on the <code>T.getId()</code> method. If the models does not
	 * exist in data store, the operation is silently failed.
	 * This method is calling {@link<T extends Model<?>> void delete(T model);}
	 * in underlying operation 
	 * @param <T> the model extended from <code>Model</code>
	 * @param models need to be delete from data store
	 * @throws NotFoundException when
	 */
	<T extends Model<?>> void delete(List<T> models) throws NotFoundException;
	
	/**
	 * Get all of the models which is type of <code>type</code>
	 * @param type of the model query from data store
	 * @return list of the models, null safe
	 */
	<T extends Model<?>> List<T> getAll(Class<T> type);
	/**
	 * Get list of models, slice based on {@link int getItemsPerPage();} as limit
	 * @param type of the model query from data store
	 * @param page the index of the slice get from data store
	 * @return list of the models, null safe
	 */
	<T extends Model<?>> List<T> getSlice(Class<T> type, int page);
	/**
	 * Get list of models, sorted based on model's attributes.
	 * @param type of the model query from data store
	 * @param page the index of the slice get from data store
	 * @param asc true for ascending, false for descending
	 * @param attributes list of attributes that used to do sorting
	 * @return lsit of models that sorted by <coded>attribures</code>, null safe
	 */
	<E extends Model<?>, T> List<E> getSlice(Class<E> type, int page, boolean asc, List<SingularAttribute<E, T>> attributes);
	/**
	 * @param type
	 * @param page
	 * @return
	 */
	<T extends Model<?>> Pagination<T> getPage(Class<T> type, int page);
	/**
	 * @param attribute
	 * @param value
	 * @param page
	 * @return
	 */
	<E extends Model<?>, T> Pagination<E> getPage(SingularAttribute<E, T> attribute, T value, int page);
	/**
	 * @param type
	 * @param page
	 * @param asc
	 * @param attributes
	 * @return
	 */
	<E extends Model<?>, T> Pagination<E> getPage(Class<E> type, int page, boolean asc, List<SingularAttribute<E, T>> attributes);
	/**
	 * @param type
	 * @param property
	 * @param value
	 * @return
	 */
	<T extends Model<?>> List<T> search(Class<T> type, String property, String value);
	/**
	 * @param type
	 * @param keyword
	 * @param page
	 * @param attributes
	 * @return
	 */
	<E extends Model<?>> Pagination<E> search(Class<E> type, String keyword, int page, SingularAttribute<E, String>... attributes);
	/**
	 * @param type
	 * @param keyword
	 * @param page
	 * @param attributes
	 * @return
	 */
	<E extends Model<?>, T> Pagination<E> search(Class<E> type, T keyword, int page, SingularAttribute<E, T>... attributes);
	/**
	 * @param type
	 * @return
	 */
	<T extends Model<?>> long getCount(Class<T> type);
	/**
	 * @param attribute
	 * @param value
	 * @return
	 */
	<E extends Model<?>, T> List<E> getMore(SingularAttribute<E, T> attribute,T value);
	/**
	 * @param attribute
	 * @param value
	 * @param limit
	 * @return
	 */
	<E extends Model<?>, T> List<E> getMore(SingularAttribute<E, T> attribute,T value, int limit);
	/**
	 * @param attribute
	 * @param value
	 * @param limit
	 * @param page
	 * @return
	 */
	<E extends Model<?>, T> List<E> getMore(SingularAttribute<E, T> attribute,T value, int limit, int page);
	/**
	 * @param attribute
	 * @param limit
	 * @return
	 */
	<E extends Model<?>, T> List<E> getMore(SingularAttribute<E, T> attribute, int limit);
	/**
	 * @param attribute
	 * @param asc
	 * @return
	 */
	<E extends Model<?>, T> List<E> getOrderBy(SingularAttribute<E, T> attribute, boolean asc);
	/**
	 * @param attribute
	 * @param limit
	 * @param asc
	 * @return
	 */
	<E extends Model<?>, T> List<E> getOrderBy(SingularAttribute<E, T> attribute, int limit, boolean asc);
	/**
	 * @param attribute
	 * @return
	 */
	<E extends Model<?>, T> List<E> getGroupBy(SingularAttribute<E, T> attribute);
	/**
	 * @param attribute
	 * @param value
	 * @return
	 */
	<E extends Model<?>, T> E getOne(SingularAttribute<E, T> attribute, T value);
	/**
	 * @param attribute
	 * @param value
	 * @return
	 */
	<E extends Model<?>, T> long getCount(SingularAttribute<E, T> attribute, T value);
	/**
	 * @param itemPerPage
	 */
	void setItemsPerPage(int itemPerPage);
	/**
	 * @return
	 */
	int getItemsPerPage();
}
