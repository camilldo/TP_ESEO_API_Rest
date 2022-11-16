package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class villeController {
	
	@Autowired
	VilleBLO villeBLOService;
	
	@GetMapping(value = "/ville")
	@ResponseBody
	public ArrayList<Ville> get(@RequestParam(required = false, value="codePostal") String codePostal){
		System.out.println("get");
		
		return villeBLOService.getInfoVilles(codePostal);
	}
	
	@PostMapping(value = "/postVille")
	@ResponseBody
	public String post(
			@RequestParam(required = true, value="codeCommune") String codeCommune,
			@RequestParam(required = true, value="nomCommune") String nomCommune,
			@RequestParam(required = true, value="codePostal") String codePostal,
			@RequestParam(required = false, value="libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = false, value="ligne") String ligne,
			@RequestParam(required = false, value="latitude") String latitude,
			@RequestParam(required = false, value="longitude") String longitude
			){
		System.out.println("post");
		
		return villeBLOService.postVilles(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne, latitude, longitude);
	}
	
	@PutMapping(value = "/putVille")
	@ResponseBody
	public String put(
			@RequestParam(required = true, value="codeCommune") String codeCommune,
			@RequestParam(required = true, value="nomCommune") String nomCommune,
			@RequestParam(required = true, value="codePostal") String codePostal,
			@RequestParam(required = false, value="libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = false, value="ligne") String ligne,
			@RequestParam(required = false, value="latitude") String latitude,
			@RequestParam(required = false, value="longitude") String longitude
			){
		System.out.println("put");
		
		try {
			Ville ville = villeBLOService.findVillByCodeCommune(codeCommune);
			System.out.println(ville.getNomCommune());
			return villeBLOService.updateVilles(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne, latitude, longitude);
			
		}catch(Exception e){
			return villeBLOService.postVilles(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne, latitude, longitude);
		}
	}
	
	@DeleteMapping(value = "/deleteVille")
	@ResponseBody
	public String delete(@RequestParam(required = true, value = "codeCommune") String codeCommune) {
		return villeBLOService.deleteVilles(codeCommune);
	}
}
