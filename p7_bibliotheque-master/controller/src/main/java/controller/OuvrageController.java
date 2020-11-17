package controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import fr.soro.entities.OuvrageBean;
import fr.soro.service.OuvrageService;

@RestController
public class OuvrageController {
	
	@Resource
	private OuvrageService ouvrageService;
	
		
		@PostMapping(value = "/ouvrages")
		@Transactional
		public ResponseEntity<OuvrageBean> createOuvrage(@RequestBody OuvrageBean ouvrage)
		{
			OuvrageBean ouvrageSaved = ouvrageService.save(ouvrage);		
	 		return new ResponseEntity<OuvrageBean>(ouvrageSaved, HttpStatus.CREATED);
	 	}
		
		@DeleteMapping(value = "/ouvrages")
		public ResponseEntity<Void> deleteOuvrage(@RequestParam(value = "id", required = true) Long id) {
			
			ouvrageService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.GONE);
	 	}

		
		@PutMapping(value = "/ouvrages")
		public ResponseEntity<OuvrageBean> updateOuvrage(@RequestBody OuvrageBean ouvrage , @RequestParam(value = "id", required = true) Long id) {
			OuvrageBean ouvrageFound = ouvrageService.updated(id, ouvrage);
			return new ResponseEntity<OuvrageBean>(ouvrageFound, HttpStatus.OK);
		}
		

		@GetMapping(value = "/ouvrages")
		public ResponseEntity<List<OuvrageBean>> getAllOuvrages() {
			List<OuvrageBean> ouvrages = ouvrageService.getAll();
			ouvrages.forEach(o-> {o.setNbreExemplaireDispo();});
			return new ResponseEntity<List<OuvrageBean>>(ouvrages, HttpStatus.FOUND);
		}
		
		
		@GetMapping(value = "/ouvrages/{id}")
		public ResponseEntity<OuvrageBean> getOne(@PathVariable(value = "id") Long id) {
			OuvrageBean ouvrageFound = ouvrageService.getOne(id);
			return new ResponseEntity<OuvrageBean>(ouvrageFound, HttpStatus.FOUND);
		}
		
		@GetMapping(value = "/ouvrages-titre/{titre}")
		public ResponseEntity<List<OuvrageBean>> getBytitre(@PathVariable(value = "titre") String titre) {
			List<OuvrageBean> ouvrageFound = ouvrageService.getByTitre(titre);
			return new ResponseEntity<List<OuvrageBean>>(ouvrageFound, HttpStatus.FOUND);
		}
		
		@GetMapping(value = "/ouvrages-auteur/{auteur}")
		public ResponseEntity<List<OuvrageBean>> getByAuteur(@PathVariable(value = "auteur") String auteur) {
			List<OuvrageBean> ouvrageFound = ouvrageService.getByAuteur(auteur);
			return new ResponseEntity<List<OuvrageBean>>(ouvrageFound, HttpStatus.FOUND);
		}
		
		@GetMapping(value = "/ouvrages-cat/{categorie}")
		public ResponseEntity<List<OuvrageBean>> getByCategorie(@PathVariable(value = "categorie") String categorie) {
			List<OuvrageBean> ouvrageFound = ouvrageService.getByCategorie(categorie);
			return new ResponseEntity<List<OuvrageBean>>(ouvrageFound, HttpStatus.FOUND);
		}
		
		@GetMapping(value = "/ouvrages/{parution}")
		public ResponseEntity<List<OuvrageBean>> getByParution(@PathVariable(value = "parution") Date parution) {
			List<OuvrageBean> ouvrageFound = ouvrageService.getByParution(parution);
			return new ResponseEntity<List<OuvrageBean>>(ouvrageFound, HttpStatus.FOUND);
		}

}
