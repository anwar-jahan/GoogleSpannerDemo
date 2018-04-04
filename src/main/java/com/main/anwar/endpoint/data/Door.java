package com.main.anwar.endpoint.data;
import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;

@Entity(name = "door")
public class Door implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final NoArgGenerator GENERATOR = Generators.randomBasedGenerator();

	@Id
	private Long door_id;

	@Transient
	@Column(nullable = true, columnDefinition = "BYTES(8)")  //BYTES(16)
	private UUID uuid;

	@Column
	private String name;

	public Door() {
	}

	public Door(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getDoor_id() {
		return door_id;
	}

	public void setDoor_id(Long door_id) {
		this.door_id = door_id;
	}

	public UUID getUuid() {

		if (uuid == null)
			uuid = GENERATOR.generate();
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@PrePersist
	public void onCreate() {
		if (uuid == null)
			uuid = GENERATOR.generate();
		if (door_id == null)
			door_id = uuid.getMostSignificantBits() ^ uuid.getLeastSignificantBits();
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;

		if (!(other instanceof Door))
			return false;

		return ((Door) other).getUuid().equals(this.getUuid());
	}

	@Override
	public int hashCode() {
		return getUuid().hashCode();
	}

	public boolean isSaved() {
		return getDoor_id() != null;
	}

	@Override
	public String toString() {
		return "Door [door_id=" + door_id + ", uuid=" + uuid + ", name=" + name + "]";
	}
	
}
