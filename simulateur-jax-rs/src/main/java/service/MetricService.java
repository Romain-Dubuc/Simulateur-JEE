package service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/metric")
@RequestScoped
public class MetricService {
	@EJB
	private SimulatorLocal simulator;
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response postJson(MultipartFormDataInput input) {
        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get("attachment");
		
		long timeSpent = 0;
		
		for (InputPart inputPart : inputParts) {
			try {
                InputStream inputStream = inputPart.getBody(InputStream.class, null);
				timeSpent = simulator.handleJsonFile(inputStream.readAllBytes());
			} catch(Exception e) {
				return Response.serverError().build();
			}
		}
		
		return Response.ok(timeSpent + " ms").build();
	}
}
