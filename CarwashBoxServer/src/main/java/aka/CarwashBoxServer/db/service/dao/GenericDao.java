package aka.CarwashBoxServer.db.service.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aka.CarwashBoxServer.db.exceptions.NotUniqueException;

public class GenericDao<T, PK extends Serializable> extends HibernateDaoSupport implements IGenericDao<T, PK>
{
	private Class<T> clazz;

	public GenericDao( Class<T> clazz )
	{
		this.clazz = clazz;
	}

	public void setClazz(final Class<T> clazz)
	{
		this.clazz = clazz;
	}

	//	@Override
	//	@Transactional
	//	@SuppressWarnings("unchecked")
	//	public PK save(T entity)
	//	{
	//		try
	//		{
	//			Session session = getSessionFactory().getCurrentSession();
	//			Transaction trans = session.beginTransaction();
	//			PK id = (PK) session.save(entity);
	//			trans.commit();
	//			return id;
	//
	//		} catch (ConstraintViolationException e)
	//		{
	//			throw new NotUniqueException(e);
	//		}
	//	}

	@Override
	@SuppressWarnings("unchecked")
	public PK save(T entity)
	{
		Session session = getSessionFactory().getCurrentSession();
		try
		{
			Transaction trans = session.beginTransaction();
			PK id = (PK) session.save(entity);
			trans.commit();
			return id;

		} catch (ConstraintViolationException e)
		{
			throw new NotUniqueException(e);
		}
		finally {
			//			session.flush();
			//			session.close();
		}
	}

	@Override
	public void update(T entity)
	{

		Session session = getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.update(entity);
		trans.commit();
	}

	@Override
	public void delete(T entity)
	{
		Session session = getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.delete(entity);
		trans.commit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(PK id)
	{
		Session session = getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		T entity = (T) session.get(clazz, id);
		trans.commit();
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll()
	{
		Session session = getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		Criteria crit = session.createCriteria(clazz);
		List<T> result = crit.list();
		trans.commit();
		return result;
	}

}
