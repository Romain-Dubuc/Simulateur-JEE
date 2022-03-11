package controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

import entity.SimulationEntity;

@Named
@RequestScoped
public class SimulationController {
	private String refresh_rate;
	private String speed;
	private String simulation_id;
	private Map<String, String> simulations = new LinkedHashMap<String, String>();
	private Part import_file;
	
	public void startSimulation() {
	}
	
	public void importSimulation() {
        try {
        	Client client = ClientBuilder.newClient();
            MultipartFormDataOutput mdo = new MultipartFormDataOutput();
			mdo.addFormData("attachment", import_file.getInputStream(), MediaType.APPLICATION_OCTET_STREAM_TYPE);
			GenericEntity<MultipartFormDataOutput> entity = new GenericEntity<MultipartFormDataOutput>(mdo) {};
			WebTarget target = client.target("http://localhost:8080/simulateur-jax-rs/api/metric");
			target.request().post(Entity.entity(entity, MediaType.MULTIPART_FORM_DATA_TYPE));
			refreshSimulationSelect();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void refreshSimulationSelect() {
		simulations.clear();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/simulateur-jax-rs/api/simulation");
	    List<SimulationEntity> response = target.request().get(new GenericType<List<SimulationEntity>> () {});
	    
		for (SimulationEntity a_simulation : response) {
			simulations.put(a_simulation.getId(), a_simulation.getName_simulation());
		}
	    
	    client.close();
	}
	
	public void init() {
		refreshSimulationSelect();
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
	
	public Part getImport_file() {
		return import_file;
	}

	public void setImport_file(Part import_file) {
		this.import_file = import_file;
	}
	
}
