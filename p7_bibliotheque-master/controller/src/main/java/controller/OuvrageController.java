package controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.soro.entities.Ouvrage;
import fr.soro.service.OuvrageService;

@RestController
public class OuvrageController {
	
	@Resource
	private OuvrageService ouvrageService;
	
		
	
	@RequestMapping(value="/search/{motcle}", method = {RequestMethod.GET})
	public List<Ouvrage> search(@PathVariable(value = "motcle")String motcle){	
		return ouvrageService.getByTitreAuteur(motcle);
	}	
	
	
		@PostMapping(value = "/ouvrages")
		@Transactional
		public ResponseEntity<Ouvrage> createOuvrage(@RequestBody Ouvrage ouvrage)
		{
			Ouvrage ouvrageSaved = ouvrageService.save(ouvrage);		
	 		return new ResponseEntity<Ouvrage>(ouvrageSaved, HttpStatus.CREATED);
	 	}
		
		@DeleteMapping(value = "/ouvrages")
		public ResponseEntity<Void> deleteOuvrage(@RequestParam(value = "id", required = true) Long id) {
			
			ouvrageService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.GONE);
	 	}

		
		@PutMapping(value = "/ouvrages")
		public ResponseEntity<Ouvrage> updateOuvrage(@RequestBody Ouvrage ouvrage , @RequestParam(value = "id", required = true) Long id) {
			Ouvrage ouvrageFound = ouvrageService.updated(id, ouvrage);
			return new ResponseEntity<Ouvrage>(ouvrageFound, HttpStatus.OK);
		}
		

		@GetMapping(value = "/ouvrages")
		public ResponseEntity<List<Ouvrage>> getAllOuvrages() {
			List<Ouvrage> ouvrages = ouvrageService.getAll();
			ouvrages.forEach(o-> {o.setNbreExemplaireDispo();});
			return new ResponseEntity<List<Ouvrage>>(ouvrages, HttpStatus.FOUND);
		}
		
		
		@GetMapping(value = "/ouvrages-id/{id}")
		public ResponseEntity<Ouvrage> getOne(@PathVariable(value = "id") Long id) {
			Ouvrage ouvrageFound = ouvrageService.getOne(id);
			return new ResponseEntity<Ouvrage>(ouvrageFound, HttpStatus.FOUND);
		}
		
		@GetMapping(value = "/ouvrages-titre/{titre}")
		public ResponseEntity<List<Ouvrage>> getBytitre(@PathVariable(value = "titre") String titre) {
			List<Ouvrage> ouvrageFound = ouvrageService.getByTitre(titre);
			return new ResponseEntity<List<Ouvrage>>(ouvrageFound, HttpStatus.FOUND);
		}
		
		@GetMapping(value = "/ouvrages-auteur/{auteur}")
		public ResponseEntity<List<Ouvrage>> getByAuteur(@PathVariable(value = "auteur") String auteur) {
			List<Ouvrage> ouvrageFound = ouvrageService.getByAuteur(auteur);
			return new ResponseEntity<List<Ouvrage>>(ouvrageFound, HttpStatus.FOUND);
		}
		
		@GetMapping(value = "/ouvrages-cat/{categorie}")
		public ResponseEntity<List<Ouvrage>> getByCategorie(@PathVariable(value = "categorie") String categorie) {
			List<Ouvrage> ouvrageFound = ouvrageService.getByCategorie(categorie);
			return new ResponseEntity<List<Ouvrage>>(ouvrageFound, HttpStatus.FOUND);
		}
		
		@GetMapping(value = "/ouvrages/{parution}")
		public ResponseEntity<List<Ouvrage>> getByParution(@PathVariable(value = "parution") Date parution) {
			List<Ouvrage> ouvrageFound = ouvrageService.getByParution(parution);
			return new ResponseEntity<List<Ouvrage>>(ouvrageFound, HttpStatus.FOUND);
		}

}
