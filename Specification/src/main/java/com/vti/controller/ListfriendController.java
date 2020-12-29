package com.vti.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Listfriend;
import com.vti.filter.ListfriendFilter;
import com.vti.service.IListfriendService;

@RestController
@RequestMapping(value = "api/v1/listfriends")

public class ListfriendController {

	@Autowired
	private IListfriendService service;

	@GetMapping()
	public ResponseEntity<?> getAllListfriends(ListfriendFilter filter, @RequestParam(required = false) String search) {
		List<Listfriend> entities = service.getAllListfriends(filter, search);
		return new ResponseEntity<List<Listfriend>>(entities, HttpStatus.OK);
	}
}
