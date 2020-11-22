package fr.soro.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.soro.entities.Ouvrage;
@Repository
public interface OuvrageRepository extends JpaRepository<Ouvrage, Long> {

	List<Ouvrage> findByTitreContains(String titre);
	
	List<Ouvrage> findByTitre(String titre);

	List<Ouvrage> findByAuteur(String auteur);
	
	List<Ouvrage> findByDateParution(Date parution);

	List<Ouvrage> findByCategorie(String categorie);
	
	@Query("Select o from Ouvrage o where ('%all%' = :auteur or o.auteur like :auteur ) or ('%all%' = :titre or o.titre like :titre)")
	List<Ouvrage> findByTitreAuteur(@Param("titre") String titre,@Param("auteur")String auteur );
	}
