package fr.soro.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.soro.entities.Bibliotheque;
import fr.soro.entities.Exemplaire;
import fr.soro.entities.OuvrageBean;
import fr.soro.repositories.BibliothequeRepository;
import fr.soro.repositories.ExemplaireRepository;
import fr.soro.repositories.OuvrageRepository;

@Service
public class ExemplaireService {
	
	@Resource
	private ExemplaireRepository exemplaireRepository;
	@Autowired
	private BibliothequeRepository bibliothequeRepository;
	@Autowired
	private OuvrageRepository ouvrageRepository;
	
	
	public List<Exemplaire> getAll(){
		return exemplaireRepository.findAll();
	}
	
	public void delete(Long id) {
		this.exemplaireRepository.deleteById(id);
	}
	
	public Exemplaire save(Long idOuvrage, Long idBiblio, Exemplaire exemplaire) {
		OuvrageBean ouvrage = this.ouvrageRepository.getOne(idOuvrage);
		Bibliotheque bibliotheque = this.bibliothequeRepository.getOne(idBiblio);
		exemplaire.setDisponible(true);
		exemplaire.setBibliotheque(bibliotheque);
		exemplaire.setOuvrage(ouvrage);
		Exemplaire exemplaireSaved = this.exemplaireRepository.save(exemplaire);
		ouvrage.getExemplaires().add(exemplaireSaved);
		bibliotheque.getExemplaires().add(exemplaireSaved);
		this.bibliothequeRepository.save(bibliotheque);
		this.ouvrageRepository.save(ouvrage);
		return exemplaireSaved;
	}

	public Exemplaire getOneById(Long id) {
		
		return this.exemplaireRepository.getOne(id);
	}

	
}
