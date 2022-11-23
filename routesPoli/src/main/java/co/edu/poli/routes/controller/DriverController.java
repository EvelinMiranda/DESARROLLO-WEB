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

import co.edu.poli.routes.model.Driver;
import co.edu.poli.routes.repository.DriverRepository;


@CrossOrigin(origins = "http://localhost:55988")
@RestController
@RequestMapping ("api/v1/")

public class DriverController {
	@Autowired
	private DriverRepository driverRepository;
	
	@GetMapping("/drivers")
	public List<Driver> getAllDrivers (){
		return driverRepository.findAll();
	}
	
	@PostMapping("/drivers")
	public Driver saveDriver (@RequestBody Driver driver) {
		return driverRepository.save(driver);
	}
	
	@PutMapping("/driver/{idDriver}")
	public Driver updateDriver (@PathVariable int idDriver, @RequestBody Driver driver) {
		Driver d = driverRepository.findById(idDriver).get();
		
		d.setDateIn(driver.getDateIn());
		d.setName(driver.getName());
		
		driverRepository.save(d);
		
		return d;
		
	}
	
	@DeleteMapping("/drivers/{idDriver}")
	public Driver deleteDriver(@PathVariable int idDriver) {
		Driver d = driverRepository.findById(idDriver).get();
		driverRepository.deleteById(idDriver);
		return d;
	}
	@GetMapping("/drivers/{s}")
	public List<Driver> getFindByName(@PathVariable String s){
		return driverRepository.findByName(s);
		
	}
	

}
