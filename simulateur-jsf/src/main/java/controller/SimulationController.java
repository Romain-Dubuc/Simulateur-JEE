package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.swing.Timer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

import entity.MetricEntity;
import entity.SimulationEntity;

@Named
@ApplicationScoped
public class SimulationController {
	private String refresh_rate;
	private String speed;
	private String simulation_id;
	private Map<String, String> simulations = new LinkedHashMap<String, String>();
	private Part import_file;
	private List<MetricEntity> metrics = new ArrayList<MetricEntity>();
	private Integer metrics_length;
	private MetricEntity current_metric;
	private boolean simulation_started = false;
	private String import_message = "";
	
	private MetricCalculation speed_calculation;
	private MetricCalculation altitude_calculation;
	private MetricCalculation acceleration_calculation;
	private MetricCalculation thrust_calculation;
	
	@Inject
	@Push
    private PushContext push;
	
	ActionListener simulation = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	if (metrics_length != 0) {
        		setCurrent_metric(metrics.remove(0));
        		speed_calculation.calculation(current_metric.getVelocity());
        		altitude_calculation.calculation(current_metric.getAltitude());
        		acceleration_calculation.calculation(current_metric.getAcceleration());
        		thrust_calculation.calculation(current_metric.getThrust());
    			metrics_length--;
    		} else {
    			timer.stop();
    		}             
        	push.send("updateMetric");
        }
    };
    private final Timer timer = new Timer(1000, simulation);
    
    public void startSimulation() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/simulateur-jax-rs/api/simulation/" + simulation_id);
		metrics = target.request().get(new GenericType<List<MetricEntity>> () {});
		metrics_length = metrics.size();
		client.close();
		
		if (metrics_length != 0) {
			speed_calculation = new MetricCalculation(metrics.get(0).getVelocity());
			altitude_calculation = new MetricCalculation(metrics.get(0).getAltitude());
			acceleration_calculation = new MetricCalculation(metrics.get(0).getAcceleration());
			thrust_calculation = new MetricCalculation(metrics.get(0).getThrust());
		
			timer.setRepeats(true);
			
			if (refresh_rate.isEmpty()) {
				timer.setDelay((int) (1000/Float.parseFloat(speed)));
			} else {
				timer.setDelay((int) ((Integer.parseInt(refresh_rate) * 1000)/Float.parseFloat(speed)));
			}
			
			timer.start();
			
		}
	}
    
    public void toggleSimulation() {
    	if (timer.isRunning()) {
    		timer.stop();
    	} else {
    		timer.start();
    	}
    }
	
	public void importSimulation() {
        try {
        	setImport_message("Import en cours...");
        	Client client = ClientBuilder.newClient();
            MultipartFormDataOutput mdo = new MultipartFormDataOutput();
			mdo.addFormData("attachment", import_file.getInputStream(), MediaType.APPLICATION_OCTET_STREAM_TYPE);
			GenericEntity<MultipartFormDataOutput> entity = new GenericEntity<MultipartFormDataOutput>(mdo) {};
			WebTarget target = client.target("http://localhost:8080/simulateur-jax-rs/api/metric");
			Response response = target.request().post(Entity.entity(entity, MediaType.MULTIPART_FORM_DATA_TYPE));
			refreshSimulationSelect();
			client.close();
			
			if (response.getStatus() == Response.Status.OK.getStatusCode()) {
				setImport_message("Import terminé en " + response.readEntity(String.class));
			} else {
				setImport_message("Erreur dans l'import");
			}
			
			push.send("updateImport");
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

	public List<MetricEntity> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<MetricEntity> metrics) {
		this.metrics = metrics;
	}

	public MetricEntity getCurrent_metric() {
		return current_metric;
	}

	public void setCurrent_metric(MetricEntity current_metric) {
		this.current_metric = current_metric;
	}

	public MetricCalculation getSpeed_calculation() {
		return speed_calculation;
	}

	public void setSpeed_calculation(MetricCalculation speed_calculation) {
		this.speed_calculation = speed_calculation;
	}

	public MetricCalculation getAltitude_calculation() {
		return altitude_calculation;
	}

	public void setAltitude_calculation(MetricCalculation altitude_calculation) {
		this.altitude_calculation = altitude_calculation;
	}

	public MetricCalculation getAcceleration_calculation() {
		return acceleration_calculation;
	}

	public void setAcceleration_calculation(MetricCalculation acceleration_calculation) {
		this.acceleration_calculation = acceleration_calculation;
	}

	public MetricCalculation getThrust_calculation() {
		return thrust_calculation;
	}

	public void setThrust_calculation(MetricCalculation thrust_calculation) {
		this.thrust_calculation = thrust_calculation;
	}

	public boolean isSimulation_started() {
		return simulation_started;
	}

	public void setSimulation_started(boolean simulation_started) {
		this.simulation_started = simulation_started;
	}

	public String getImport_message() {
		return import_message;
	}

	public void setImport_message(String import_message) {
		this.import_message = import_message;
	}
	
}
