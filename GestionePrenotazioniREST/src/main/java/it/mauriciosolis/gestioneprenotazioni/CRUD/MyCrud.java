package it.mauriciosolis.gestioneprenotazioni.CRUD;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import it.mauriciosolis.Citta;
import it.mauriciosolis.Edificio;
import it.mauriciosolis.Postazione;
import it.mauriciosolis.Prenotazione;
import it.mauriciosolis.Role;
import it.mauriciosolis.RoleType;
import it.mauriciosolis.TipoPostazione;
import it.mauriciosolis.User;
import it.mauriciosolis.gestioneprenotazioni.repository.CittaRepository;
import it.mauriciosolis.gestioneprenotazioni.repository.EdificioRepository;
import it.mauriciosolis.gestioneprenotazioni.repository.PostazioneRepository;
import it.mauriciosolis.gestioneprenotazioni.repository.PrenotazioneRepository;
import it.mauriciosolis.gestioneprenotazioni.repository.RoleRepository;
import it.mauriciosolis.gestioneprenotazioni.repository.UserRepository;

@Component
public class MyCrud implements CommandLineRunner {
	
	@Autowired
	CittaRepository cittaRepository;
	@Autowired
	EdificioRepository edificioRepository;
	@Autowired
	PostazioneRepository postazioneRepository;
	@Autowired
	PrenotazioneRepository prenotazioneRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public void run(String... args) throws Exception {
		Citta cit= new Citta();
		cit.setNome("Ancona");
		cittaRepository.save(cit);
		
		Edificio edf= new Edificio();
		
		edf.setIndirizzo("viale corto");
		edf.setCitta(cit);
		edf.setNome("edificio2");
		edf.setPasswordEdificio("12345678");
		edificioRepository.save(edf);
		
		Postazione posta= new Postazione();
		posta.setCodice("codice3");
		posta.setDescrizione("descrizione5");
		posta.setEdificio(edf);
		posta.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
		posta.setNumeroMassimoOccupati(100);
		postazioneRepository.save(posta);
		
		User user= new User();
		user.setActive(true);
		user.setEmail("email13@gmail.com");
		user.setNome("Mauricio");
		String hashedPassword=encoder.encode("password4");
		user.setPassword(hashedPassword);
		user.setUsername("Mauri2");
		userRepository.save(user);
		
		User user1= new User();
		user1.setActive(true);
		user1.setEmail("email12@gmail.com");
		user1.setNome("nome2");
		String hashedPassword2=encoder.encode("plainPassword");
		user1.setPassword(hashedPassword2);
		user1.setUsername("username9");
		userRepository.save(user1);
		
		Prenotazione pre= new Prenotazione();
		pre.setPostazione(posta);
		pre.setDataPrenotata(LocalDate.now());
		pre.setDataPrenotazione(LocalDate.of(2021, 8, 5));
		pre.setUser(user);
		prenotazioneRepository.save(pre);
		
		Role rol= new Role();
		rol.setRoleType(RoleType.ROLE_ADMIN);
		roleRepository.save(rol);
		
		Role rol1= new Role();
		rol1.setRoleType(RoleType.ROLE_USER);
		roleRepository.save(rol1);
		
		List<Citta> cit2= (List<Citta>) cittaRepository.findAll();
		cit2.forEach(a->System.out.println("citta nel db" +a.toString()));
	
		System.out.println(cittaRepository.findById((long) 1).toString());
	}

}
