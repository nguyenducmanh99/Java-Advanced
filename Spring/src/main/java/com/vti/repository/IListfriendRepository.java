package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Listfriend;

public interface IListfriendRepository extends JpaRepository<Listfriend, Short>{
		public Listfriend findByName(String name);
		
		public boolean existsByName(String name);
}
