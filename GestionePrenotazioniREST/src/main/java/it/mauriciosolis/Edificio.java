package it.mauriciosolis;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import it.mauriciosolis.gestioneprenotazioni.security.StringAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "edificio")
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String indirizzo;
	@ManyToOne
	private Citta citta;
	@Column(name = "passwordedificio")
	@Convert(converter = StringAttributeConverter.class)
	@Size(min=2,max=8,message="password non corretta")
	private String passwordEdificio;

	public Edificio(String nome, String indirizzo, Citta citta) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

}
