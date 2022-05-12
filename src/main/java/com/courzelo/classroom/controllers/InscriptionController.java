package com.courzelo.classroom.controllers;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.courzelo.classroom.businesses.iservices.IServiceInscription;
import com.courzelo.classroom.entities.dtos.InscriptionDTO;

@RequestMapping(value = "/api/Inscriptions")
@RestController
public class InscriptionController {
	@Autowired
	private IServiceInscription iInscription;
	@PostMapping("/{id}/Formation/{idFormation}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<InscriptionDTO> createInscription(@RequestBody InscriptionDTO inscription ,@PathVariable("id") Long id,@PathVariable("idFormation") Long idFormation){
		inscription=iInscription.addInscription(inscription, id, idFormation);
		return new ResponseEntity<>(inscription, HttpStatus.OK);

	}




}
