package com.vti.repository;

import java.util.List;

import com.vti.FilterListfriend.FilterListfriend;
import com.vti.entity.Listfriend;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

public interface IListfriendRepository {

	public List<Listfriend> getAllListfriends(Paging paging, Sorting sorting, FilterListfriend filter, String search);

	public Listfriend getListfriendByID(short id);

	public Listfriend getListfriendByName(String name);

	public void createListfriend(Listfriend listfriend);

	public void updateListfriend(short id, String newname,String newaddress,String newcity,String newpincode, int newage);

	public void updateListfriend(Listfriend listfriend);

	public void deleteListfriend(short id);

	public boolean isListfriendExistsByID(short id);

	public boolean isListfriendExistsByName(String name);

}
