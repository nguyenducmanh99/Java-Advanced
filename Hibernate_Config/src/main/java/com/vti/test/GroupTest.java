package com.vti.test;

import java.util.List;
import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

public class GroupTest {
	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();

		System.out.println("***********GET ALL ACCOUNTS***********");

		List<Group> groups = repository.getAllGroups();

		for (Group group : groups) {
			System.out.println(group);
		}

	

//		Account accountCreate = new Account();
//		accountCreate.setUsername("NguyenVanA");
//		accountCreate.setEmail("NguyenVanA@gmail.com");
//		accountCreate.setFirstName("A");
//		accountCreate.setLastName("Nguyen Van");
//
//		repository.createAccount(accountCreate);

	}
}
