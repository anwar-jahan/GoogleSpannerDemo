package com.main.anwar.data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Door extends BasicEntry {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
