package com.website.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entities.Category;


/**
 *
 * @author TVD
 */
@Repository
public class CategoryDao extends Dao<Category> {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<Category> getAll() {
		Session session = this.sessionfactory.getCurrentSession();
		List<Category> categories = session.createQuery("from Category").list();
		return categories;
	}

	@Override
	public Category get(Long id) {
		Session session = this.sessionfactory.getCurrentSession();
		return (Category) session.get(Category.class, new Long(id));
	}

	@Override
	public Category add(Category category) {
		Session session = this.sessionfactory.getCurrentSession();
		session.save(category);
		return category;
	}

	@Override
	public Boolean update(Category category) {
		Session session = this.sessionfactory.getCurrentSession();
		try {
			session.update(category);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean delete(Category category) {
		Session session = this.sessionfactory.getCurrentSession();
		if (null != category) {
			try {
				session.delete(category);
				return Boolean.TRUE;
			} catch (Exception e) {
				return Boolean.FALSE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean delete(Long id) {
		Session session = this.sessionfactory.getCurrentSession();
		Category category = (Category) session.load(Category.class, new Long(id));
		if (null != category) {
			try {
				session.delete(category);
				return Boolean.TRUE;
			} catch (Exception e) {
				return Boolean.FALSE;
			}
		}
		return Boolean.FALSE;
	}

	


}
