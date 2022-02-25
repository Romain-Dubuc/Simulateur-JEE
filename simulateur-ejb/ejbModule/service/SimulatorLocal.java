package service;

import java.util.List;

import javax.ejb.Local;

import model.entity.MetricItem;

@Local
public interface SimulatorLocal {
	public List<MetricItem> getMetric();
}
