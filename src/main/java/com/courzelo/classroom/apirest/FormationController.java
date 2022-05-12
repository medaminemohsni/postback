package com.courzelo.classroom.apirest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.courzelo.classroom.entities.dtos.FormationDTO;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceFormation;




@CrossOrigin(origins ="http://localhost:4200/")
@RequestMapping(value = "/api/Formations")
@RestController

public class FormationController {
	@Autowired
	private IServiceFormation iFormation;
	
	@PostMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<FormationDTO> createFormation(@RequestBody FormationDTO formation ,@PathVariable("id") String id){
		formation=iFormation.addformation(formation, id);
		return new ResponseEntity<>(formation, HttpStatus.OK);

	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<FormationDTO> getAllFormations(){
		return iFormation.getList();
	}
	
	@GetMapping("creator/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<FormationDTO> getFormationBuCreator(@PathVariable("id") String id){
		return iFormation.getFormtionByIdCreator(id);
	}	
	
	@GetMapping("student/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<FormationDTO> getFormationsByStudent(@PathVariable(name = "id") Long id){
		return iFormation.getFormationByIdStudent(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public FormationDTO getFormationById(@PathVariable(name = "id") Long id){
		return iFormation.getFormationById(id);
	}
	
	
	
	
	@PutMapping(path = "/{idFormation}")
    public ResponseEntity<FormationDTO> updateFormation(@PathVariable(name = "idFormation") Long idFormation, @RequestBody  @Valid  FormationDTO formation) {
		
		FormationDTO formationResponse = iFormation.UpdateFormation(idFormation,formation);
		
        return new ResponseEntity<FormationDTO>(formationResponse, HttpStatus.CREATED);
    }
	
	@DeleteMapping(path = "/{idFormation}")
	public void deleteCourse(@PathVariable(name = "idFormation") Long idFormation) {
		iFormation.DeleteFormation(idFormation);
		
	}
}
