package fr.soro.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.soro.entities.Emprunt;
import fr.soro.repositories.EmpruntRepository;

@Service
public class EmpruntService {
	@Resource
	private EmpruntRepository empruntRepository;
	

	public EmpruntService( EmpruntRepository empruntRepository) {
		this.empruntRepository =  empruntRepository;
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
	
	public List<Emprunt> getProlongation( boolean prolongation) {
		return this.empruntRepository.findByProlongation(prolongation);
	}
	
	public List<Emprunt> getDepassement(int depassement) {
		return this.empruntRepository.findByDepassement(depassement);
	}
	
	public void deleted(Long id) {
		this.empruntRepository.deleteById(id);
	}

}
