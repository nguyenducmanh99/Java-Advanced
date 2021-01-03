package com.vti.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
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

import com.vti.FilterGroup.FilterGroup;
import com.vti.dto.GroupDTO;
import com.vti.entity.Group;
import com.vti.service.IGroupService;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;
import com.vti.validation.onCreate;
import com.vti.validation.onUpdate;

@RestController
@RequestMapping(value = "api/v1/groupmanagers")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@Validated
public class GroupController {

	@Autowired
	private IGroupService service;

	@GetMapping()
	public ResponseEntity<?> getAllGroups(Paging paging, Sorting sorting, FilterGroup filter,
			@RequestParam(name = "search", required = false) String search,
			@RequestParam(defaultValue = "10")  int pageSize) {

		// get data
		List<Group> entities = service.getAllGroups(paging, sorting, filter, search);
		if(pageSize ==1) {
			throw new EntityNotFoundException("Not Found Group");
		}
		return new ResponseEntity<List<Group>>(entities, HttpStatus.OK);
	}
			
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getListfriendByID(@PathVariable(name = "id") @Min(1)short id) {
		return new ResponseEntity<Group>(service.getGroupByID(id), HttpStatus.OK);
	}

	@Validated(onCreate.class)
	@PostMapping()
	public ResponseEntity<?> createGroup(@Valid @RequestBody GroupDTO dto) {
		service.createGroup(dto.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@Validated(onUpdate.class)
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateGroup(@Valid @PathVariable(name = "id") short id, @RequestBody GroupDTO dto) {
		Group group = dto.toEntity();
		group.setId(id);
		service.updateGroup(group);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteGroup(@PathVariable(name = "id") short id) {
		service.deleteGroup(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
