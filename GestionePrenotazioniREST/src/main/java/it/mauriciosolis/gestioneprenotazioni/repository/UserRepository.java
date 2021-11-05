package it.mauriciosolis.gestioneprenotazioni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.mauriciosolis.User;


public interface UserRepository extends JpaRepository<User,Long> {
	Optional <User> findByUsername(String username);
	
	public Page<User> findAll(Pageable pageable);

	public List<User> findByOrderByUsernameDesc();
	
	Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
	}

