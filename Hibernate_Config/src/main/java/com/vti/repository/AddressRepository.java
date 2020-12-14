package com.vti.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.Utils.HibernateUtils;
import com.vti.entity.Address;
import com.vti.entity.Department;
import com.vti.entity.DetailDepartment;
import com.vti.entity.Group;

public class AddressRepository {
	private HibernateUtils hibernateUtils;

	public AddressRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAllAddresss() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Address> query = session.createQuery("FROM Address");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	

	public void createDetailDepartment(DetailDepartment department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
