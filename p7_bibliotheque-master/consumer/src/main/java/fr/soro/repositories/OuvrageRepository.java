package fr.soro.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.soro.entities.OuvrageBean;
@Repository
public interface OuvrageRepository extends JpaRepository<OuvrageBean, Long> {

	
	
	List<OuvrageBean> findByTitre(String titre);

	List<OuvrageBean> findByAuteur(String auteur);


	List<OuvrageBean> findByDateParution(Date parution);

	List<OuvrageBean> findByCategorie(String categorie);
	}
