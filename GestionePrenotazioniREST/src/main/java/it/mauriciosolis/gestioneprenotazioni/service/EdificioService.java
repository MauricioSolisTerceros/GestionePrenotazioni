package it.mauriciosolis.gestioneprenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.mauriciosolis.Edificio;
import it.mauriciosolis.gestioneprenotazioni.repository.EdificioRepository;

@Service
public class EdificioService {

	@Autowired
	EdificioRepository edificioRepository;
	
	public List <Edificio> findAll(){
		return edificioRepository.findAll();
	}
	
	public void saveEdificio (Edificio edificio) {
		edificioRepository.save(edificio);
	}
	
	public List <Edificio> findByIndirizzo(String indirizzo){
		return edificioRepository.findByIndirizzo(indirizzo);
	}
	
	public Page<Edificio> myFindAllEdificioPageable(Pageable pageable) {
	       return edificioRepository.findAll(pageable);
	}
	
	// Ordinamento
	   public List<Edificio> myFindAllEdifici() {
	       return edificioRepository.findByOrderByNomeAsc();
	   }
}
