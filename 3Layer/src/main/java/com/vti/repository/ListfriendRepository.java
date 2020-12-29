package com.vti.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.vti.FilterListfriend.FilterListfriend;
import com.vti.entity.Listfriend;
import com.vti.utils.HibernateUtils;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

@Repository
public  class ListfriendRepository implements IListfriendRepository {

	private HibernateUtils hibernateUtils;

	public ListfriendRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Listfriend> getAllListfriends(Paging paging, Sorting sorting, FilterListfriend filter, String search) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria criteria = session.createCriteria(Listfriend.class);
			
			// search
			if(!StringUtils.isEmpty(search)) {
				Criterion seachByName = Restrictions.ilike("name", "%" + search + "%");
				criteria.add(seachByName);
			}
			
			// filter
			// min Member
			if(null != filter.getMinAge()) {
				criteria.add(Restrictions.ge("age", filter.getMinAge().shortValue()));
			}
			
			// max Member
			if(null != filter.getMaxAge()) {
				criteria.add(Restrictions.le("age", filter.getMaxAge().shortValue()));
			}

			// sorting
			criteria.addOrder(
					sorting.getSortType().equals("ASC") ? 
							Order.asc(sorting.getSortField()): 
							Order.desc(sorting.getSortField()));

			// paging
			criteria.setFirstResult((paging.getPageNumber() - 1) * paging.getPageSize());
			criteria.setMaxResults(paging.getPageSize());
			
			// return result
			return criteria.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public Listfriend getListfriendByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Listfriend listfriend = session.get(Listfriend.class, id);

			return listfriend;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Listfriend getListfriendByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Listfriend> query = session.createQuery("FROM Listfriend WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Listfriend listfriend = query.uniqueResult();

			return listfriend;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createListfriend(Listfriend listfriend) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(listfriend);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateListfriend(short id, String newname,String newaddress,String newcity,String newpincode, int newage) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Listfriend listfriend = (Listfriend) session.load(Listfriend.class, id);

			// update
			listfriend.setName(newname);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateListfriend(Listfriend listfriend) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(listfriend);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteListfriend(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Listfriend
			Listfriend listfriend = (Listfriend) session.load(Listfriend.class, id);

			// delete
			session.delete(listfriend);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public boolean isListfriendExistsByID(short id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isListfriendExistsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}



}

