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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping ("api/v1/")
public class RouteController {

	@Autowired 
	private RouteRepository routeRepository;
	
	@GetMapping("/routes")
	@ApiOperation(value = "*** Service Method Get All Routes ***", notes = "*** Get All Routes from MySQL\\\\WebApp ***")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "*** Error Delete Routes!!! ***") })
	public List<Route> getAllRoutes () {
		return routeRepository.findAll();
	}
	
	
	@PostMapping("/route")
	@ApiOperation(value = "*** Service Method Save One Route ***", notes = "*** Save One Route from MySQL\\\\WebApp ***")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "*** Error Save Route!!! ***") })
	public Route saveRoute (@RequestBody Route route) {
		return routeRepository.save(route);
	}
	
	//@PutMapping("")
}
