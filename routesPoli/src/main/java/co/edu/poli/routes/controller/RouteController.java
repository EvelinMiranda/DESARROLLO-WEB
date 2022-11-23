package co.edu.poli.routes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.routes.repository.RouteRepository;
import co.edu.poli.routes.model.Route;


@CrossOrigin(origins = "http://localhost:55988")
@RestController
@RequestMapping ("api/v1/")
public class RouteController {
	@Autowired 
	private RouteRepository routeRepository;
	
	@GetMapping("/routes")
	public List<Route> getAllRoutes () {
		return routeRepository.findAll();
	}
	
	
	@PostMapping("/routes")
	public Route saveRoute (@RequestBody Route route) {
		return routeRepository.save(route);
	}
	
	@PutMapping("/route/{idRoute}")
	public Route updateRoute (@PathVariable int  idRoute, @RequestBody Route ruta ) {
		Route r = routeRepository.findById(idRoute).get();
		r.setDateOut(ruta.getDateOut());
		r.setHourOut(ruta.getHourOut());
		r.setChairNumber(ruta.getChairNumber());
		
		routeRepository.save(r);
		return r;
	}
	
	@DeleteMapping("/routes/{idRoute}")
	public Route deleteRoute(@PathVariable int idRoute) {
		Route r= routeRepository.findById(idRoute).get();
		routeRepository.deleteById(idRoute);
		return r;
	}

}
