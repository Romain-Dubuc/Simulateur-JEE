package service;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.entity.Simulation;

@Path("/simulation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class SimulationService {
	@EJB
	private SimulatorLocal simulator;
	
	@GET
	public List<Simulation>  getSimulation() {
		return simulator.getSimulation();
	} 
}