package co.edu.poli.routes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.routes.model.Driver;



public interface DriverRepository  extends JpaRepository<Driver, Integer>{
	@Query (value="select id, date_in, name from drivers where name= ?1",nativeQuery = true)
	List<Driver> findByName (String n);
}
