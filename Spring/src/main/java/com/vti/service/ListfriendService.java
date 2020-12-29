package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Listfriend;
import com.vti.repository.IListfriendRepository;

@Service
public class ListfriendService implements IListfriendService {

	@Autowired
	private IListfriendRepository repository;

	public List<Listfriend> getAllListfriends() {
		return repository.findAll();
	}

	public Listfriend getListfriendByID(short id) {
		return repository.findById(id).get();
	}

	public Listfriend getListfriendByName(String name) {
		return repository.findByName(name);
	}

	public void createListfriend(Listfriend listfriend) {
		repository.save(listfriend);
	}

	public void updateListfriend(Listfriend listfriend) {
		repository.save(listfriend);
	}

	public void deleteListfriend(short id) {
		repository.deleteById(id);
	}

	public boolean isDepartmentExistsByID(short id) {
		return repository.existsById(id);
	}

	public boolean isDepartmentExistsByName(String name) {
		return repository.existsByName(name);
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
