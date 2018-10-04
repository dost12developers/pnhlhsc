package com.dost12.phls.phlsbackend.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.ManufactureDAO;
import com.dost12.phls.phlsbackend.dto.Manufacture;

@Repository("manufactureDAO")
@Transactional
public class ManufactureDAOImpl implements ManufactureDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Manufacture> list() {
		
		String selectActiveCategory = "FROM Manufacture WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public Manufacture get(int id) {

		return sessionFactory.getCurrentSession().get(Manufacture.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(Manufacture manufacture) {

		try {
			manufacture.setCreatedOn(new Date());
			manufacture.setUpdatedOn(new Date());
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(manufacture);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * Updating a single category
	 */
	@Override
	public boolean update(Manufacture manufacture) {

		try {
			manufacture.setUpdatedOn(new Date());
			// add the category to the database table
			sessionFactory.getCurrentSession().update(manufacture);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Manufacture manufacture) {
		
		manufacture.setActive(false);
		
		try {
			manufacture.setUpdatedOn(new Date());
			// add the category to the database table
			sessionFactory.getCurrentSession().update(manufacture);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
