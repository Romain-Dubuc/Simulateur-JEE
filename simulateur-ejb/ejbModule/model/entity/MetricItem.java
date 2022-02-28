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
	 * Vélocité sur l'axe x de la fusée
	 */
	@Column(nullable = false)
	private Double velocity_x;
	
	/**
	 * Vélocité sur l'axe y de la fusée
	 */
	@Column(nullable = false)
	private Double velocity_y;
	
	/**
	 * L'accélération de la fusée
	 */
	@Column(nullable = false)
	private Double acceleration;
	
	/**
	 * Distance vers la cible
	 */
	@Column(nullable = false)
	private Double downrange_distance;
	
	/**
	 * Angle de la fusée
	 */
	@Column(nullable = false)
	private Double angle;
	
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
	 * Masse de la fusée
	 */
	@Column(nullable = false)
	private Double s1_mass;
	
	/**
	 * CD de la fusée
	 */
	@Column(nullable = false)
	private Double cd;
	
	/**
	 * Trainée de la fusée
	 */
	@Column(nullable = false)
	private Double drag;
	
	/**
	 * Gravité de la fusée
	 */
	@Column(nullable = false)
	private Double gravity;
	
	/**
	 * Différence entre la vélocité et la trainée de la fusée
	 */
	@Column(nullable = false)
	private Double delta_v_drag;
	
	/**
	 * Perte de gravité de la fusée
	 */
	@Column(nullable = false)
	private Double gravity_loss;

	/**
	 * Delta de la vélocité
	 */
	@Column(nullable = false)
	private Double delta_v;
	
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

	public Double getVelocity_x() {
		return velocity_x;
	}

	public void setVelocity_x(Double velocity_x) {
		this.velocity_x = velocity_x;
	}

	public Double getVelocity_y() {
		return velocity_y;
	}

	public void setVelocity_y(Double velocity_y) {
		this.velocity_y = velocity_y;
	}

	public Double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Double acceleration) {
		this.acceleration = acceleration;
	}

	public Double getDownrange_distance() {
		return downrange_distance;
	}

	public void setDownrange_distance(Double downrange_distance) {
		this.downrange_distance = downrange_distance;
	}

	public Double getAngle() {
		return angle;
	}

	public void setAngle(Double angle) {
		this.angle = angle;
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

	public Double getS1_mass() {
		return s1_mass;
	}

	public void setS1_mass(Double s1_mass) {
		this.s1_mass = s1_mass;
	}

	public Double getCd() {
		return cd;
	}

	public void setCd(Double cd) {
		this.cd = cd;
	}

	public Double getDrag() {
		return drag;
	}

	public void setDrag(Double drag) {
		this.drag = drag;
	}

	public Double getGravity() {
		return gravity;
	}

	public void setGravity(Double gravity) {
		this.gravity = gravity;
	}

	public Double getDelta_v_drag() {
		return delta_v_drag;
	}

	public void setDelta_v_drag(Double delta_v_drag) {
		this.delta_v_drag = delta_v_drag;
	}

	public Double getGravity_loss() {
		return gravity_loss;
	}

	public void setGravity_loss(Double gravity_loss) {
		this.gravity_loss = gravity_loss;
	}

	public Double getDelta_v() {
		return delta_v;
	}

	public void setDelta_v(Double delta_v) {
		this.delta_v = delta_v;
	}
}
