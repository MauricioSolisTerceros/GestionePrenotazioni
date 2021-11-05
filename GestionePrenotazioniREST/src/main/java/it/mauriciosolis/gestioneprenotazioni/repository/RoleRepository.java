package it.mauriciosolis.gestioneprenotazioni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.mauriciosolis.Role;
import it.mauriciosolis.RoleType;


public interface RoleRepository extends JpaRepository<Role,Long> {
	Optional<Role> findByRoleType(RoleType roletype);

}
