 package com.website.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.entities.Product;

@Repository
public class ProductDaoImpl extends ProductDAO<Product> {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<Product> getAll() {
		Session session = this.sessionfactory.getCurrentSession();
		List<Product> products = session.createQuery("from Product").list();
		return products;
	}
	
	@Override
	 public List<Product> getAllByCategory(Long id){
		 Session session = this.sessionfactory.getCurrentSession();
		 Query query = session.createQuery("FROM Product WHERE category = :id");
		 query.setLong("id", id);		 
        List<Product> list = query.list();
        return list;
		 
	 }

	@Override
	public Product get(Long id) {
		Session session = this.sessionfactory.getCurrentSession();
		return (Product) session.get(Product.class, new Long(id));
	}

	@Override	
	public Product add(Product product) {
		Session session = this.sessionfactory.getCurrentSession();
		session.save(product);
		return product;
	}

	@Override
	public Boolean update(Product product) {
		Session session = this.sessionfactory.getCurrentSession();
		try {
			session.update(product);
			return Boolean.TRUE;
		} catch(Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean delete(Product product) {
		Session session = this.sessionfactory.getCurrentSession();
		if(null != product) {
			try {
				session.delete(product);
				return Boolean.TRUE;
			}catch(Exception e) {
				return Boolean.FALSE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean delete(Long id) {
		Session session = this.sessionfactory.getCurrentSession();
		Product product = (Product) session.load(Product.class, new Long(id));
		if (null != product) {
			try {
				session.delete(product);
				return Boolean.TRUE;
			} catch (Exception e) {
				return Boolean.FALSE;
			}
		}
		return Boolean.FALSE;
	}
	
	@Override
    public List<Product> getListNav(int start, int limit) {
		Session session = this.sessionfactory.getCurrentSession();      
		Criteria criteria = session.createCriteria(Product.class);
            criteria.setFirstResult(start);
            criteria.setMaxResults(limit);
            List<Product> list = criteria.list();            
            return list;        
        
    }
	
	@Override
	 public List<Product> getListByCategory(Long id,int start, int limit){
		 Session session = this.sessionfactory.getCurrentSession();
		 Query query = session.createQuery("FROM Product WHERE category = :id");
		 query.setLong("id", id);
		 query.setFirstResult(start);
         query.setMaxResults(limit);
         List<Product> list = query.list();
         return list;
		 
	 }
	
	@Override
    public Long totalItem() {
		Session session = this.sessionfactory.getCurrentSession();
		Query query = session.createQuery("SELECT count(*) FROM Product");
		Long i = (Long) query.uniqueResult();            
       return i;
    }
	
	@Override
	public Long totalItembyCategory(Long id) {
		Session session = this.sessionfactory.getCurrentSession();
		Query query = session.createQuery("SELECT count(*) FROM Product WHERE category = :id");
		query.setLong("id", id);
		Long i = (Long) query.uniqueResult();            
       return i;
    }

	@Override
	public void indexProduct() throws Exception {
		try {
			Session session = sessionfactory.getCurrentSession();
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			fullTextSession.createIndexer().startAndWait();
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<Product> search(String keyword) {
		Session session = sessionfactory.getCurrentSession();

		FullTextSession fullTextSession = Search.getFullTextSession(session);

		QueryBuilder qb = fullTextSession.getSearchFactory()
					.buildQueryBuilder().forEntity(Product.class).get();
		org.apache.lucene.search.Query query = qb
					.keyword().onFields("name") 
					.matching(keyword)
					.createQuery();

		org.hibernate.Query hibQuery =
					fullTextSession.createFullTextQuery(query, Product.class);

		List<Product> results = hibQuery.list();
		return results;
	}
}
