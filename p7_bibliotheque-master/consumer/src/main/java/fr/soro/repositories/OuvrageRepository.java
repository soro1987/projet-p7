package fr.soro.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.soro.entities.Ouvrage;
@Repository
public interface OuvrageRepository extends JpaRepository<Ouvrage, Long> {

	
	
	List<Ouvrage> findByTitre(String titre);

	List<Ouvrage> findByAuteur(String auteur);


	List<Ouvrage> findByDateParution(Date parution);

	List<Ouvrage> findByCategorie(String categorie);
	}
