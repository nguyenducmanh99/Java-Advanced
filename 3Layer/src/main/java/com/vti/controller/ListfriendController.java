package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.FilterListfriend.FilterListfriend;
import com.vti.dto.ListfriendDTO;
import com.vti.entity.Listfriend;
import com.vti.service.IListfriendService;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

@RestController
@RequestMapping(value = "api/v1/listfriends")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class ListfriendController {

	@Autowired
	private IListfriendService service;

	@GetMapping()
	public ResponseEntity<?> getAllListfriends(Paging paging, Sorting sorting, FilterListfriend filter,
			@RequestParam(name = "search", required = false) String search) {

		// get data
		List<Listfriend> entities = service.getAllListfriends(paging, sorting, filter, search);

//		List<String> dtos = new ArrayList<>();
//
//		// convert entity to dto
//		for (Department entity : entities) {
//			dtos.add(entity.getName());
//		}

		return new ResponseEntity<List<Listfriend>>(entities, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getListfriendByID(@PathVariable(name = "id") short id) {
		return new ResponseEntity<Listfriend>(service.getListfriendByID(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createListfriend(@RequestBody ListfriendDTO dto) {
		service.createListfriend(dto.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateListfriend(@PathVariable(name = "id") short id, @RequestBody ListfriendDTO dto) {
		Listfriend listfriend = dto.toEntity();
		listfriend.setId(id);
		service.updateListfriend(listfriend);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteListfriend(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
