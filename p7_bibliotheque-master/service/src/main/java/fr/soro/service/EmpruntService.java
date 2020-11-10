package fr.soro.service;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.soro.entities.Bibliotheque;
import fr.soro.entities.Emprunt;
import fr.soro.entities.Exemplaire;
import fr.soro.entities.User;
import fr.soro.repositories.EmpruntRepository;
import fr.soro.repositories.ExemplaireRepository;
import fr.soro.repositories.UserRepository;



@Service
public class EmpruntService {
	@Resource
	private EmpruntRepository empruntRepository;
	
	@Resource
	private UserRepository userRepository;
	
	@Resource
	private ExemplaireRepository exemplaireRepository;

	public EmpruntService(EmpruntRepository empruntRepository) {
		this.empruntRepository = empruntRepository;
	}

	public Emprunt get(Long id) {
		return this.empruntRepository.getOne(id);
	}

	public List<Emprunt> getDateDebut(Date datedebut) {
		return this.empruntRepository.findByDateDebut(datedebut);
	}

	public List<Emprunt> getDateEcheance(Date dateEcheance) {
		return this.empruntRepository.findByDateEcheance(dateEcheance);
	}

	public List<Emprunt> getProlongation(boolean prolongation) {
		return this.empruntRepository.findByProlongation(prolongation);
	}

	public List<Emprunt> getDepassement(int depassement) {
		return this.empruntRepository.findByDepassement(depassement);
	}

	public void deleted(Long id) {
		this.empruntRepository.deleteById(id);
	}

	public List<Emprunt> getAllEmprunt() {
		return this.empruntRepository.findAll();
	}
	
	public Emprunt save(Long idUser, Long idExmplaire, Emprunt emprunt) {
		emprunt.setDateDebut(new Date());
		
		Calendar calendrier = Calendar.getInstance();
		Date dateCourante = emprunt.getDateDebut();
		calendrier.setTime(dateCourante);
		calendrier.add(Calendar.HOUR, 24*28);
		emprunt.setDateEcheance(calendrier.getTime());
		
		User user = this.userRepository.getOne(idUser);
		emprunt.setUser(user);
		
		Exemplaire exemplaire = this.exemplaireRepository.getOne(idExmplaire);
		emprunt.getExemplaires().add(exemplaire);
		exemplaire.setDisponible(false);
		
		
		
		Emprunt empruntSaved  = this.empruntRepository.save(emprunt);
		user.getEmprunts().add(empruntSaved);
		exemplaire.setEmprunt(empruntSaved);
		
		this.userRepository.save(user);
		this.exemplaireRepository.save(exemplaire);
		return empruntSaved;
	}
	
	public Emprunt setProlongation(Long id) {
		Emprunt emprunt = this.get(id);
		if(emprunt.isProlongation() == false) {
			emprunt.setProlongation(true);
			Calendar calendrier = Calendar.getInstance();
			Date dateCourante = emprunt.getDateEcheance();
			calendrier.setTime(dateCourante);
			calendrier.add(Calendar.HOUR, 24*28);
			emprunt.setDateEcheance(calendrier.getTime());
			this.empruntRepository.save(emprunt);
		}
		return emprunt;
	}
		 
	
}
