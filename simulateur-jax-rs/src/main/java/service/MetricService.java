package service;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.entity.MetricItem;

@Path("/metric")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class MetricService {
	@EJB
	private SimulatorLocal simulator;
	
	@GET
	public List<MetricItem>  getMetric() {
		return simulator.getMetric();
	} 
}
