package com.vti.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class TestHibernate {
	public static void main(String[] arg) {
		Session session = null;
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();
			
			TestingCategory category = new TestingCategory();
			category.setName("Hibernate");
			
			session.save(category);

			System.out.print("Tao thanh cong!");

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(TestingCategory.class);

		ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);

	}
}