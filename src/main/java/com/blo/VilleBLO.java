package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	
	public ArrayList<Ville> getInfoVilles(String codePostal);
	
	public Ville findVillByCodeCommune(String codeCommune);
	
	public String postVilles(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne, String latitude, String longitude);
	
	public String updateVilles(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne, String latitude, String longitude);
	
	public String deleteVilles(String codeCommune);
	
}
