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
		//ArrayList<Ville> listVille2 = new ArrayList<Ville>();
		
		listVille = villeDAO.findAllVilles();
		
//		for (int i = 0; i < listVille.size(); i++) {
//			if (listVille.get(i).getCodePostal().equals(codePostal)) {
//				System.out.println("ok code postal");
//				listVille2.add(listVille.get(i));
//			}
//		}
		
		return listVille;
	}
	
	public ArrayList<Ville> getInfoVillesCodePostal(String codePostal){
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		listVille = villeDAO.findAllVillesCodePostal(codePostal);
		
		return listVille;
	}
}