package com.vti.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.vti.FilterGroup.FilterGroup;
import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

@Repository
public  class GroupRepository implements IGroupRepository {

	private HibernateUtils hibernateUtils;

	public GroupRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Group> getAllGroups(Paging paging, Sorting sorting, FilterGroup filter, String search) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria criteria = session.createCriteria(Group.class);
			
			// search
			if(!StringUtils.isEmpty(search)) {
				Criterion seachByName = Restrictions.ilike("name", "%" + search + "%");
				criteria.add(seachByName);
			}
			
			// filter
			// min Member
			if(null != filter.getMinMember()) {
				criteria.add(Restrictions.ge("age", filter.getMinMember().shortValue()));
			}
			
			// max Member
			if(null != filter.getMaxMember()) {
				criteria.add(Restrictions.le("age", filter.getMaxMember().shortValue()));
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

	public Group getGroupByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Group  group  = session.get(Group .class, id);

			return group ;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Group  getGroupByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Group > query = session.createQuery("FROM groupmanager WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Group  group  = query.uniqueResult();

			return group ;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createGroup(Group  group ) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(group );

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateGroup (short id, String newgroupname,String newmember,String newcreator,Date newcreatedate) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Group  group  = (Group ) session.load(Group .class, id);

			// update
			group .setName(newgroupname);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateGroup(Group  group ) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(group );

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteGroup (short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Group
			Group  group  = (Group ) session.load(Group.class, id);

			// delete
			session.delete(group );

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public boolean isGroupExistsByID(short id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGroupExistsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}

