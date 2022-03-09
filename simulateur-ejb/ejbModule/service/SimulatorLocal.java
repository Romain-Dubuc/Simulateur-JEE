package service;

import java.util.List;

import javax.ejb.Local;

import model.entity.MetricItem;
import model.entity.Simulation;

@Local
public interface SimulatorLocal {
	public List<MetricItem> getMetric();
	public void serializeJson(Simulation sim, String data);
	public long handleJsonFile(byte[] file);
}
