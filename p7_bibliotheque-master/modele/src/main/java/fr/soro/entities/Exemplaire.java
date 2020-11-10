package fr.soro.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "exemplaire")
@PrimaryKeyJoinColumn(name = "id")
public class Exemplaire extends Ouvrage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "bibliotheque")
	private Bibliotheque bibliotheque;
	
	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "emprunt_id")
	private Emprunt emprunt;
	public Exemplaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exemplaire(Long id, String titre, String auteur, Date dateParution, Date dateDisponible, String description,
			boolean disponible) {
		super(id, titre, auteur, dateParution, dateDisponible, description, disponible);
		// TODO Auto-generated constructor stub
	}
	/*public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}
	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}*/
	public Emprunt getEmprunt() {
		return emprunt;
	}
	public void setEmprunt(Emprunt emprunt) {
		this.emprunt = emprunt;
	}
	
	
}
