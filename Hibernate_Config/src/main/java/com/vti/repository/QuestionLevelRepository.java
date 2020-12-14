package com.vti.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.vti.Utils.HibernateUtils;
import com.vti.entity.Group;
import com.vti.entity.Question_Level;

public class QuestionLevelRepository {
	private HibernateUtils hibernateUtils;

	public QuestionLevelRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Question_Level> getAllQuestion_Levels() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Question_Level> query = session.createQuery("FROM Question_Level");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createQuestion_Level(Question_Level question_Level) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(question_Level);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
