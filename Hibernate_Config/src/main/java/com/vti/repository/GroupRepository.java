package com.vti.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.Utils.HibernateUtils;
import com.vti.entity.Group;

public class GroupRepository {
	private HibernateUtils hibernateUtils;

	public GroupRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Group> getAllGroups() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Group> query = session.createQuery("FROM Group");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	
}
