package it.mauriciosolis.gestioneprenotazioni.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.mauriciosolis.Postazione;
import it.mauriciosolis.TipoPostazione;


public interface PostazioneRepository extends JpaRepository<Postazione,Long> {
	@Query ("SELECT p FROM  Postazione p WHERE p.tipoPostazione =:tipo AND p.edificio.citta.nome =:nome")
	List<Optional<Postazione>> findByTipoPostazione2(TipoPostazione tipo, String nome);

	List<Optional<Postazione>> findByTipoPostazione(TipoPostazione tipoPostazione);

	public Page<Postazione> findAll(Pageable pageable);

	public List<Postazione> findByOrderByCodiceAsc();

}
