package aka.CarwashBoxServer.db.service.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T, PK extends Serializable>
{
	/** Сохранить объект newInstance в базе данных */
	public PK save(T entity);

	/**
	 * Извлечь объект, предварительно сохраненный в базе данных, используя
	 * указанный id в качестве первичного ключа
	 */
	public T findById(PK id);

	/** Сохранить изменения, сделанные в объекте. */
	public void update(T entity);

	/** Удалить объект из базы данных */
	public void delete(T entity);

	/** Получить все объекты */
	public List<T> findAll();

}
