package fr.soro.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.soro.entities.Exemplaire;
import fr.soro.repositories.ExemplaireRepository;

@Service
public class ExemplaireService {
	
	@Resource
	private ExemplaireRepository exemplaireRepository;
	
	public Exemplaire getOne(Long id) {
		return exemplaireRepository.getOne(id);
	}
	
	public List<Exemplaire> getAll(){
		return exemplaireRepository.findAll();
	}
    
	public List<Exemplaire> getByTitre(String titre) {
		return exemplaireRepository.findByTitre(titre);
	}
	
	public List<Exemplaire> getByAuteur(String auteur) {
		return exemplaireRepository.findByAuteur(auteur);
	}
	
	public List<Exemplaire> getByParution(Date parution) {
		return exemplaireRepository.findByDateParution(parution);
	}
	
	public Exemplaire updated(Long id ,Exemplaire exemplaire) {
		Exemplaire exemplaireUpdate = this.getOne(id);
		exemplaireUpdate.setTitre(exemplaire.getTitre());
		exemplaireUpdate.setAuteur(exemplaire.getAuteur());
		exemplaireUpdate.setDescription(exemplaire.getDescription());
		exemplaireUpdate.setDateDisponible(exemplaire.getDateDisponible());
		exemplaireUpdate.setDateParution(exemplaire.getDateParution());
		exemplaireUpdate.setDisponible(exemplaire.isDisponible());
		exemplaireUpdate.setEmprunt(exemplaire.getEmprunt());
		return exemplaireUpdate;
	}
	
	public void delete(Long id) {
    this.exemplaireRepository.deleteById(id);
	}
}
