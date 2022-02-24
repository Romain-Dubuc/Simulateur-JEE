package service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import model.DataService;

/**
 * Session Bean implementation class Simulator
 */
@Stateless
public class Simulator implements SimulatorLocal {
	@Inject
	private DataService dataService;
	
}
