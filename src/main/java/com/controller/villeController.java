package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> get(@RequestParam(required = false, value="codePostal") String codePostal){
		System.out.println("get");
		
		return villeBLOService.getInfoVilles(codePostal);
	}
	
	@RequestMapping(value = "/ville/{codePostal}", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> getVilleCodePostal(@PathVariable("codePostal") String codePostal){
		System.out.println("get");
		
		return villeBLOService.getInfoVillesCodePostal(codePostal);
	}
}
