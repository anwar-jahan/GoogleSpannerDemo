package com.main.anwar.data;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;

@MappedSuperclass
public abstract class BasicEntry implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final NoArgGenerator GENERATOR = Generators.randomBasedGenerator();

	@Id
	private Long id;

	@Column(nullable = true, columnDefinition = "BYTES(16)")
	private UUID uuid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	protected void onCreate() {
		if (uuid == null)
			uuid = GENERATOR.generate();
		if (id == null)
			id = uuid.getMostSignificantBits() ^ uuid.getLeastSignificantBits();
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;

		if (!(other instanceof BasicEntry))
			return false;

		return ((BasicEntry) other).getUuid().equals(this.getUuid());
	}

	@Override
	public int hashCode() {
		return getUuid().hashCode();
	}

	public boolean isSaved() {
		return getId() != null;
	}

}
