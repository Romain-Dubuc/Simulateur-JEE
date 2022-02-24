package model;

import java.util.List;

import javax.ejb.Local;

import model.entity.MetricItem;

@Local
public interface DataServiceLocal {
	public List<MetricItem> getMetrics();
	public void addMetric(MetricItem metric);
}
