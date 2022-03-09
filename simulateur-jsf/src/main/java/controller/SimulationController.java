package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SimulationController {
	private String refresh_rate;
	private String speed;
	
	public void startSimulation() {
	}
	
	public String getRefreshRate() {
		return refresh_rate;
	}

	public void setRefreshRate(String refresh_rate) {
		this.refresh_rate = refresh_rate;
	}
	
	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}
}
