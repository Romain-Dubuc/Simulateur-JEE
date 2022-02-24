package model;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ejb.Stateless;
import model.entity.MetricItem;

@Named
@Transactional
@Stateless
public class DataService implements DataServiceLocal {

	@PersistenceContext
	private EntityManager em;

	public List<MetricItem> getMetrics() {
		return em.createQuery("select i from MetricItem i", MetricItem.class).getResultList();
	}

	public void addMetric(MetricItem metric) {
		em.persist(metric);
	}

}


