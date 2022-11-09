package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	
	public ArrayList<Ville> getInfoVilles(String codePostal);
	
	public ArrayList<Ville> getInfoVillesCodePostal(String codePostal);
	
}
