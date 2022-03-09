package service;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import form.JsonUploadForm; 

@Path("/metric")
@RequestScoped
public class MetricService {
	@EJB
	private SimulatorLocal simulator;
	
	@POST
	@Consumes("multipart/form-data")
	public Response postJson(@MultipartForm JsonUploadForm form) {
		
		long timeSpent = 0;
		
		try {
			timeSpent = simulator.handleJsonFile(form.getData());
		} catch(Exception e) {
			return Response.serverError().build();
		}
		
		return Response.ok(timeSpent + " ms").build();
	}
}
