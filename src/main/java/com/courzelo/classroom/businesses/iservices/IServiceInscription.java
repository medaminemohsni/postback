package com.courzelo.classroom.businesses.iservices;

import com.courzelo.classroom.entities.dtos.InscriptionDTO;

public interface IServiceInscription {
	public InscriptionDTO addInscription(InscriptionDTO f,Long idEtudiant ,Long idFormation);
	

}
