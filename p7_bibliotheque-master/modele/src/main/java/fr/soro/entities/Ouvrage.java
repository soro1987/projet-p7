package fr.soro.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "ouvrage")
public class Ouvrage implements Serializable {
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
	private String description;
	private String categorie;
	
	private  int nbreExemplaireDispo=0;
	@JsonManagedReference(value = "ouvr-ex")
	@OneToMany(mappedBy = "ouvrage", fetch = FetchType.EAGER)
	private List<Exemplaire> exemplaires;
	
	public Ouvrage() {
		super();
		// TODO Auto-generated constructor stub
		this.setNbreExemplaireDispo();
	}
	

	public Ouvrage(Long id, String titre, String auteur, Date dateParution, String description, String categorie,
			int nbreExemplaireDispo, List<Exemplaire> exemplaires) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.dateParution = dateParution;
		this.description = description;
		this.categorie = categorie;
		this.nbreExemplaireDispo = nbreExemplaireDispo;
		this.exemplaires = exemplaires;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	public int getNbreExemplaireDispo() {
		return nbreExemplaireDispo;
	}



	public void setNbreExemplaireDispo(int nbreExemplaireDispo) {
		this.nbreExemplaireDispo = nbreExemplaireDispo;
	}
	
	public void setNbreExemplaireDispo() {
		if(this.exemplaires != null) {
			for(Exemplaire expl: this.exemplaires) {
				if( expl.isDisponible()) {
					this.nbreExemplaireDispo++;
				}
			}
		}
	}




	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}



	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}




	
	
}
