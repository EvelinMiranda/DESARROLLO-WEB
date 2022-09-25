package co.edu.poli.routespoli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.routespoli.model.Driver;
import co.edu.poli.routespoli.repository.DriverRepository;

@RestController
@RequestMapping ("api/v1/")
public class DriverController {
	
	@Autowired
	private DriverRepository driverRepository;
	
	@GetMapping("/drivers")
	public List<Driver> getAllDrivers (){
		return driverRepository.findAll();
	}
	
	@PostMapping("/driver")
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
	
	@DeleteMapping("/driver/{idDriver}")
	public Driver deleteDriver(@PathVariable int idDriver) {
		Driver d = driverRepository.findById(idDriver).get();
		driverRepository.deleteById(idDriver);
		return d;
	}

}
