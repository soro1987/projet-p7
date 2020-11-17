package fr.soro.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.soro.entities.OuvrageBean;
import fr.soro.repositories.OuvrageRepository;

@Service
public class OuvrageService {
	
			
		@Autowired
		private OuvrageRepository ouvrageRepository;
		
		public OuvrageBean getOne(Long id) {
			return ouvrageRepository.getOne(id);
		}
		
		public List<OuvrageBean> getAll(){
			return ouvrageRepository.findAll();
		}
	    
		public List<OuvrageBean> getByTitre(String titre) {
			return ouvrageRepository.findByTitre(titre);
		}
		
		public List<OuvrageBean> getByAuteur(String auteur) {
			return ouvrageRepository.findByAuteur(auteur);
		}
		
		public List<OuvrageBean> getByCategorie(String categorie) {
			return ouvrageRepository.findByCategorie(categorie);
		}
		
		public List<OuvrageBean> getByParution(Date parution) {
			return ouvrageRepository.findByDateParution(parution);
		}
		
		public OuvrageBean updated(Long id ,OuvrageBean ouvrage) {
			OuvrageBean ouvrageUpdate = this.getOne(id);
			ouvrageUpdate.setTitre(ouvrage.getTitre());
			ouvrageUpdate.setAuteur(ouvrage.getAuteur());
			ouvrageUpdate.setDescription(ouvrage.getDescription());
			ouvrageUpdate.setDateParution(ouvrage.getDateParution());
			return ouvrageUpdate;
		}
		
		public void delete(Long id) {
	    this.ouvrageRepository.deleteById(id);
		}
		
		public OuvrageBean save(OuvrageBean ouvrage) {
			return this.ouvrageRepository.save(ouvrage);
		}
		

}
