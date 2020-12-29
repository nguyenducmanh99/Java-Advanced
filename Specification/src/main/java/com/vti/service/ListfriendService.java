package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vti.entity.Listfriend;
import com.vti.filter.ListfriendFilter;
import com.vti.repository.IListfriendRepository;
import com.vti.specification.ListfriendSpecificationBuilder;

@Service
public class ListfriendService implements IListfriendService {

	@Autowired
	private IListfriendRepository repository;

	public List<Listfriend> getAllListfriends(ListfriendFilter filter, String search) {

		ListfriendSpecificationBuilder specification = new ListfriendSpecificationBuilder(filter, search);

		return repository.findAll(specification.build());

	}

}
