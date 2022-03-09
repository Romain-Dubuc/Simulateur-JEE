package service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.json.bind.*;
import javax.ejb.Stateless;
import javax.inject.Inject;

import model.DataService;
import model.entity.MetricItem;
import model.entity.Simulation;

/**
 * Session Bean implementation class Simulator
 */
@Stateless
public class Simulator implements SimulatorLocal {
	@Inject
	private DataService dataService;
	
	public List<MetricItem> getMetric() {
		return dataService.getMetrics();
	}
	
	public long handleJsonFile(byte[] file) {
		long start = System.currentTimeMillis();
		
		String json = new String(file, StandardCharsets.UTF_8);
		String[] tab = json.split("\\r?\\n");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		Simulation sim = new Simulation(dtf.format(LocalDateTime.now()));
		dataService.addSimulation(sim);
		
		for(String line : tab) {
			this.serializeJson(sim, line);
		}
		
		return System.currentTimeMillis() - start;
	}
	
	public void serializeJson(Simulation sim, String data) {
		List<MetricItem> metrics;
		Jsonb jsonb = JsonbBuilder.create();
		metrics = jsonb.fromJson("[" + data + "]", new ArrayList<MetricItem>() {}.getClass().getGenericSuperclass());
		metrics.get(0).setSimulation(sim);
		dataService.addMetric(metrics.get(0));
	}
}
