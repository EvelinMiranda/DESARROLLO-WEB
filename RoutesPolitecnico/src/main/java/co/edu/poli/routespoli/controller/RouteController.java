package co.edu.poli.routespoli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.routespoli.model.Route;
import co.edu.poli.routespoli.repository.RouteRepository;

@RestController
@RequestMapping ("api/v1/")
public class RouteController {

	@Autowired 
	private RouteRepository routeRepository;
	
	@GetMapping("/routes")
	public List<Route> getAllRoutes () {
		return routeRepository.findAll();
	}
	
	
	@PostMapping("/route")
	public Route saveRoute (@RequestBody Route route) {
		return routeRepository.save(route);
	}
	
	@PutMapping("")
}
