package co.edu.poli.routes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.routes.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
