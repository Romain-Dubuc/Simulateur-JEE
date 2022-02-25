package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import model.DataService;
import model.entity.MetricItem;

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
}
