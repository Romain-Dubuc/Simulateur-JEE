package entity;

public class MetricEntity {
	private Integer id;
	private String simulation;
	private Double time;
	private Double velocity;
	private Double altitude;
	private Double acceleration;
	private Double thrust;
	private Double throttle;
	private Double gravity;
	
	protected MetricEntity() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSimulation() {
		return simulation;
	}

	public void setSimulation(String simulation) {
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
