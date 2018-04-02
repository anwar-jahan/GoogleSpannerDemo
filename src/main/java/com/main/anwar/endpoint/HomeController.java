package com.main.anwar.endpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.anwar.endpoint.data.Door;
import com.main.anwar.endpoint.service.DoorRepository;

@RestController
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DoorRepository doorRepository;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/addDoor", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String addDoor(@RequestParam("name") String name) {
		log.info("Start: add method.");
		doorRepository.save(new Door(name));
		return "save";
	}
	
	@RequestMapping(value="/getAllDoor", method=RequestMethod.GET)
	@ResponseBody
	public List<Door> getAllDoor() {
		log.info("Start: get All Door.");
		return (List<Door>)doorRepository.findAll();
	}
}
