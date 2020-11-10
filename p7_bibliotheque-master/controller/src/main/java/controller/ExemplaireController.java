package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.soro.entities.Exemplaire;
import fr.soro.service.ExemplaireService;

@RestController
public class ExemplaireController {
	
	
	@Resource
	private ExemplaireService exemplaireService;
	
	@GetMapping(value = "/exemplaires")
	public List<Exemplaire> getAll(){
		return this.exemplaireService.getAll();
	}
	
	

}
