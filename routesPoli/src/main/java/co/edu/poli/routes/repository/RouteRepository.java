package co.edu.poli.routes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.routes.model.Route;

public interface RouteRepository extends JpaRepository<Route, Integer>{

}
