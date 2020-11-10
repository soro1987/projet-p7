package fr.soro.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "ouvrage")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Ouvrage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String auteur;
	private Date dateParution;
	private Date dateDisponible;
	private String description;
	private boolean disponible;
	
	public Ouvrage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ouvrage(Long id, String titre, String auteur, Date dateParution, Date dateDisponible, String description,
			boolean disponible) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.dateParution = dateParution;
		this.dateDisponible = dateDisponible;
		this.description = description;
		this.disponible = disponible;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public Date getDateParution() {
		return dateParution;
	}
	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}
	public Date getDateDisponible() {
		return dateDisponible;
	}
	public void setDateDisponible(Date dateDisponible) {
		this.dateDisponible = dateDisponible;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}
