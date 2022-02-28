package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Une simulation
 */
@Entity
@Table(name = "simulation")
public class Simulation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Nom de la simulation
	 */
	@Column(nullable = false)
	private String name_simulation;
	
	protected Simulation() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_simulation() {
		return name_simulation;
	}

	public void setName_simulation(String name_simulation) {
		this.name_simulation = name_simulation;
	}	
}
