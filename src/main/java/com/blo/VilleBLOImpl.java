package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDAO;
	
	public ArrayList<Ville> getInfoVilles(String codePostal) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		if (codePostal == null) {
			listVille = villeDAO.findAllVilles();
		}else {
			listVille = villeDAO.findAllVillesCodePostal(codePostal);			
		}
		
		return listVille;
	}
	
	public Ville findVillByCodeCommune(String codeCommune) {
		Ville ville = villeDAO.findVillByCodeCommune(codeCommune);
		if (ville.getCodeCommune() == null) {
			return null;
		} else {
			return ville;
		}
	}
	
	public String postVilles(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement,
			String ligne, String latitude, String longitude) {
		return villeDAO.postVilles(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne, latitude, longitude);
	}
	
	public String updateVilles(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement,
			String ligne, String latitude, String longitude) {
		return villeDAO.updateVilles(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne, latitude, longitude);
	}
	
	public String deleteVilles(String codeCommune) {
		return villeDAO.deleteVilles(codeCommune);
	}
}