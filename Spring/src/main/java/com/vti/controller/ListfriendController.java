package com.vti.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import com.vti.dto.ListfriendDTO;
import com.vti.entity.Listfriend;
import com.vti.service.IListfriendService;
import com.vti.validation.group.onCreate;
import com.vti.validation.group.onUpdate;

@RestController
@RequestMapping(value = "api/v1/listfriends")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@Validated
public class ListfriendController {

	@Autowired
	private IListfriendService service;

	@GetMapping()
	public ResponseEntity<?> getAllListfriends(@RequestParam @Min(1) int pageSize) {
		List<Listfriend> entities = service.getAllListfriends();
		return new ResponseEntity<List<Listfriend>>(entities, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getListfriendByID(@PathVariable(name = "id") @Min(1)short id) {
		return new ResponseEntity<Listfriend>(service.getListfriendByID(id), HttpStatus.OK);
	}

	@Validated(onCreate.class)
	@PostMapping()
	public ResponseEntity<?> createListfriend(@Valid @RequestBody ListfriendDTO dto) {
		service.createListfriend(dto.toEntity());
		return new ResponseEntity<String>( "Create successfully!", HttpStatus.CREATED);
	}

	@Validated(onUpdate.class)
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateListfriend(@Valid @PathVariable(name = "id") short id, @RequestBody ListfriendDTO dto) {
		Listfriend listfriend = dto.toEntity();
		listfriend.setId(id);
		service.updateListfriend(listfriend);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteListfriend(@PathVariable(name = "id") short id) {
		service.deleteListfriend(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
