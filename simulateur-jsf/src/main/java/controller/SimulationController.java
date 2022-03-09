package controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import entity.SimulationEntity;

@Named
@RequestScoped
public class SimulationController {
	private String refresh_rate;
	private String speed;
	private String simulation_id;
	private Map<String, String> simulations = new LinkedHashMap<String, String>();
	
	public void startSimulation() {
	}
	
	public void init() {
		Client client = ClientBuilder.newClient();
	    WebTarget target = client.target("http://localhost:8080/simulateur-jax-rs/api/simulation");
	    List<SimulationEntity> response = target.request().get(new GenericType<List<SimulationEntity>> () {});
	    simulations.put(" ", " ");
	    
		for (SimulationEntity a_simulation : response) {
			simulations.put(a_simulation.getId(), a_simulation.getName_simulation());
		}
	    
	    client.close();
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
	
	public String getSimulationId() {
		return simulation_id;
	}

	public void setSimulationId(String simulation_id) {
		this.simulation_id = simulation_id;
	}

	public Map<String, String> getSimulations() {
		return simulations;
	}

	public void setSimulations(Map<String, String> simulations) {
		this.simulations = simulations;
	}
	
}
