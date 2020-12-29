package com.vti.service;

import java.util.List;
import com.vti.entity.Listfriend;

public interface IListfriendService {

	public List<Listfriend> getAllListfriends();

	public Listfriend getListfriendByID(short id);

	public Listfriend getListfriendByName(String name);

	public void createListfriend(Listfriend listfriend);

	public void updateListfriend(Listfriend listfriend);

	public void deleteListfriend(short id);

	public boolean isListfriendExistsByID(short id);

	public boolean isListfriendExistsByName(String name);
}
