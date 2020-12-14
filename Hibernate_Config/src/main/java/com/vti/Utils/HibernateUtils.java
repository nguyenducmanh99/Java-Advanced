package com.vti.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Account;
import com.vti.entity.Address;
import com.vti.entity.DetailDepartment;
import com.vti.entity.Group;
import com.vti.entity.GroupAccount;
import com.vti.entity.Position;
import com.vti.entity.Question_Level;
import com.vti.entity.Salary;

public class HibernateUtils {
	private static HibernateUtils instance;

	private Configuration configuration;
	private SessionFactory sessionFactory;


	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}


	private HibernateUtils() {
		configure();
	}

	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(Group.class);
		configuration.addAnnotatedClass(Question_Level.class);
		configuration.addAnnotatedClass(DetailDepartment.class);
		configuration.addAnnotatedClass(Address.class);
		configuration.addAnnotatedClass(Salary.class);
		configuration.addAnnotatedClass(GroupAccount.class);
		configuration.addAnnotatedClass(Position.class);
		configuration.addAnnotatedClass(Account.class);
		
		
	}


	private SessionFactory buildSessionFactory() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}


	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

	
	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}

}

