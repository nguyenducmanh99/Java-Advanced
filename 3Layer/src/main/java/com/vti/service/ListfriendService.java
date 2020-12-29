package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.FilterListfriend.FilterListfriend;
import com.vti.entity.Listfriend;
import com.vti.repository.IListfriendRepository;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

@Service
public class ListfriendService implements IListfriendService {

	@Autowired
	private IListfriendRepository repository;

	public List<Listfriend> getAllListfriends(Paging paging, Sorting sorting, FilterListfriend filter, String search) {
		return repository.getAllListfriends(paging, sorting, filter, search);
	}

	public Listfriend getListfriendByID(short id) {
		return repository.getListfriendByID(id);
	}

	public Listfriend getListfriendByName(String name) {
		return repository.getListfriendByName(name);
	}

	public void createListfriend(Listfriend listfriend) {
		repository.createListfriend(listfriend);
	}

	public void updateListfriend(short id, String newname,String newaddress,String newcity,String newpincode, int newage){
		repository.updateListfriend(id, newname, newaddress, newcity, newpincode, newage);
	}

	public void updateListfriend(Listfriend listfriend) {
		repository.updateListfriend(listfriend);
	}

	public void deleteListfriend(short id) {
		repository.deleteListfriend(id);
	}

	public boolean isListfriendtExistsByID(short id) {
		return repository.isListfriendExistsByID(id);
	}

	public boolean isListfriendsByName(String name) {
		return repository.isListfriendExistsByName(name);
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
