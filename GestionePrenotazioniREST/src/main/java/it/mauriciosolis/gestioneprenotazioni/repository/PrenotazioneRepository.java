package it.mauriciosolis.gestioneprenotazioni.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.mauriciosolis.Postazione;
import it.mauriciosolis.Prenotazione;
import it.mauriciosolis.User;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {
	@Query("SELECT c.postazione FROM Prenotazione c WHERE c.postazione =:postazione" )
	List<Optional<Postazione>> findByPostazione(Postazione postazione);

	@Query("SELECT c.postazione FROM Prenotazione c WHERE c.user =:user AND c.dataPrenotata =:data" )
	List<Optional<Postazione>> findByPostazioneUser(User user, LocalDate data);

	public Page<Prenotazione> findAll(Pageable pageable);

	public List<Prenotazione> findByOrderByDataPrenotataDesc();
	
}
