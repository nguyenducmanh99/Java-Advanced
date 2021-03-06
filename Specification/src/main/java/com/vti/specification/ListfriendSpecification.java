package com.vti.specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Listfriend;
public class ListfriendSpecification implements Specification<Listfriend>{
	private static final long serialVersionUID = 1L;
	private SearchCriteria criteria;

	public ListfriendSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Listfriend> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (criteria.getOperator().equalsIgnoreCase("Like")) {
			return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
		}

		if (criteria.getOperator().equalsIgnoreCase(">")) {
			return criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
		}

		if (criteria.getOperator().equalsIgnoreCase("<")) {
			return criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
		}

		return null;
	}

}
