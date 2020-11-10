package fr.soro.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.soro.entities.Ouvrage;
import fr.soro.repositories.OuvrageRepository;

@Service
public class OuvrageService {
	
			
		@Autowired
		private OuvrageRepository ouvrageRepository;
		
		public Ouvrage getOne(Long id) {
			return ouvrageRepository.getOne(id);
		}
		
		public List<Ouvrage> getAll(){
			return ouvrageRepository.findAll();
		}
	    
		public List<Ouvrage> getByTitre(String titre) {
			return ouvrageRepository.findByTitre(titre);
		}
		
		public List<Ouvrage> getByAuteur(String auteur) {
			return ouvrageRepository.findByAuteur(auteur);
		}
		
		public List<Ouvrage> getByCategorie(String categorie) {
			return ouvrageRepository.findByCategorie(categorie);
		}
		
		public List<Ouvrage> getByParution(Date parution) {
			return ouvrageRepository.findByDateParution(parution);
		}
		
		public Ouvrage updated(Long id ,Ouvrage ouvrage) {
			Ouvrage ouvrageUpdate = this.getOne(id);
			ouvrageUpdate.setTitre(ouvrage.getTitre());
			ouvrageUpdate.setAuteur(ouvrage.getAuteur());
			ouvrageUpdate.setDescription(ouvrage.getDescription());
			ouvrageUpdate.setDateParution(ouvrage.getDateParution());
			return ouvrageUpdate;
		}
		
		public void delete(Long id) {
	    this.ouvrageRepository.deleteById(id);
		}
		
		public Ouvrage save(Ouvrage ouvrage) {
			return this.ouvrageRepository.save(ouvrage);
		}
		

}
