package com.main.anwar.endpoint.service;

import org.springframework.data.repository.CrudRepository;

import com.main.anwar.endpoint.data.Door;

public interface DoorRepository extends CrudRepository<Door, Long> {
	
	public Door findByName(String name);
}
