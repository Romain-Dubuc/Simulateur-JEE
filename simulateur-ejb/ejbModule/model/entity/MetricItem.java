package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Item d'une métrique d'une simulation.
 */
@Entity
@Table(name = "metric_item")
public class MetricItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name = "simulation", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Simulation simulation;

	/**
	 * Temps récupération de la fusée
	 */
	@Column(nullable = false)
	private Double time;
	
	/**
	 * Vélocité de la fusée
	 */
	@Column(nullable = false)
	private Double velocity;
	
	/**
	 * Altitude de la fusée
	 */
	@Column(nullable = false)
	private Double altitude;
	
	/**
	 * L'accélération de la fusée
	 */
	@Column(nullable = false)
	private Double acceleration;
	
	/**
	 * Poussée de la fusée
	 */
	@Column(nullable = false)
	private Double thrust;
	
	/**
	 * Accélérateur de la fusée
	 */
	@Column(nullable = false)
	private Double throttle;
	
	/**
	 * Gravité de la fusée
	 */
	@Column(nullable = false)
	private Double gravity;
	
	protected MetricItem() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public Double getVelocity() {
		return velocity;
	}

	public void setVelocity(Double velocity) {
		this.velocity = velocity;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	public Double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Double acceleration) {
		this.acceleration = acceleration;
	}

	public Double getThrust() {
		return thrust;
	}

	public void setThrust(Double thrust) {
		this.thrust = thrust;
	}

	public Double getThrottle() {
		return throttle;
	}

	public void setThrottle(Double throttle) {
		this.throttle = throttle;
	}

	public Double getGravity() {
		return gravity;
	}

	public void setGravity(Double gravity) {
		this.gravity = gravity;
	}
}
