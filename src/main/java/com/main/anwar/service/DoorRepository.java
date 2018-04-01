package com.main.anwar.service;

import org.springframework.data.repository.CrudRepository;
import com.main.anwar.data.Door;

public interface DoorRepository extends CrudRepository<Door, Long> {
	
	public Door findByName(String name);
}
