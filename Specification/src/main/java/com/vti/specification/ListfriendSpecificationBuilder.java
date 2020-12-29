package com.vti.specification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Listfriend;
import com.vti.filter.ListfriendFilter;

	public class ListfriendSpecificationBuilder {
		private ListfriendFilter filter;
		private String search;

		public ListfriendSpecificationBuilder(ListfriendFilter filter, String search) {
			this.filter = filter;
			this.search = search;
		}

		public Specification<Listfriend> build() {

			SearchCriteria seachCriteria = new SearchCriteria("name", "Like", search);

			SearchCriteria minIDCriteria = new SearchCriteria("id", ">", filter.getMinID());

			SearchCriteria maxIDCriteria = new SearchCriteria("id", "<", filter.getMaxID());

			SearchCriteria minAgeCriteria = new SearchCriteria("age", ">", filter.getMinAge());

			Specification<Listfriend> where = null;

			if (!StringUtils.isEmpty(search)) {
				where = new ListfriendSpecification(seachCriteria);
			}

			// if there is filter by min id
			if (filter.getMinID() != 0) {
				if (where != null) {
					where = where.and(new ListfriendSpecification(minIDCriteria));
				} else {
					where = new ListfriendSpecification(minIDCriteria);
				}
			}

			// filter
			if (filter.getMaxID() != 0) {
				if (where != null) {
					where = where.and(new ListfriendSpecification(maxIDCriteria));
				} else {
					where = new ListfriendSpecification(maxIDCriteria);
				}
			}

			// filter
			if (filter.getMinAge() != 0) {
				if (where != null) {
					where = where.and(new ListfriendSpecification(minAgeCriteria));
				} else {
					where = new ListfriendSpecification(minAgeCriteria);
				}
			}

			return where;
		}


}
