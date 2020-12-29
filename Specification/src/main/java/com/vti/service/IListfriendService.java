package com.vti.service;

import java.util.List;

import com.vti.entity.Listfriend;
import com.vti.filter.ListfriendFilter;

public interface IListfriendService {

	public List<Listfriend> getAllListfriends(ListfriendFilter filter, String search);
}
