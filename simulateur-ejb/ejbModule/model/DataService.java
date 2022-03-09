package model;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import model.entity.MetricItem;
import model.entity.Simulation;

@Named
@ApplicationScoped
@Transactional
public class DataService {

	@PersistenceContext
	private EntityManager em;

	public List<MetricItem> getMetrics() {
		return em.createQuery("select i from MetricItem i", MetricItem.class).getResultList();
	}
	
	public List<Simulation> getSimulations() {
		return em.createQuery("select i from Simulation i", Simulation.class).getResultList();
	}

	public void addMetric(MetricItem metric) {
		em.persist(metric);
	}
	
	public void addSimulation(Simulation simulation) {
		em.persist(simulation);
	}

}

