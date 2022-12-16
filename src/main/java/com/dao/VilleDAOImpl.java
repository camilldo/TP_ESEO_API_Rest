package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.springframework.stereotype.Repository;

import com.dto.Coordonnee;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO{
	
	private static final ResourceBundle DB_CONF = ResourceBundle.getBundle("db");
	
	public ArrayList<Ville> findAllVilles(){
		System.out.println("findAllVilles");
		
		ArrayList<Ville> listVille = new ArrayList<>();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(DB_CONF.getString("DB_URL"),DB_CONF. getString("DB_USERNAME"), DB_CONF.getString("DB_PASSWORD"));
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from ville_france");  
			while(rs.next()) {
				Ville ville = new Ville(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Coordonnee(rs.getString(6), rs.getString(7)));
				listVille.add(ville);
			}
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
		return listVille;
	}
	
	public ArrayList<Ville> findAllVillesCodePostal(String codePostal){
		System.out.println("findAllVillesByCodePostal");
		
		ArrayList<Ville> listVille = new ArrayList<>();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(DB_CONF.getString("DB_URL"),DB_CONF. getString("DB_USERNAME"), DB_CONF.getString("DB_PASSWORD"));
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from ville_france where Code_postal = " + codePostal);
			while(rs.next()) {
				Ville ville = new Ville(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Coordonnee(rs.getString(6), rs.getString(7)));
				listVille.add(ville);
			}
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
		return listVille;
	}
	
	public Ville findVillByCodeCommune(String codeCommune) {
		System.out.println(codeCommune);
		Ville ville = new Ville();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(DB_CONF.getString("DB_URL"),DB_CONF. getString("DB_USERNAME"), DB_CONF.getString("DB_PASSWORD"));
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from ville_france where Code_commune_INSEE = " + codeCommune);
			while(rs.next()) {
				ville = new Ville(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Coordonnee(rs.getString(6), rs.getString(7)));
			}
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
		return ville;
	}

	public String postVilles(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement,
			String ligne, String latitude, String longitude) {
		System.out.println("postVille");
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(DB_CONF.getString("DB_URL"),DB_CONF. getString("DB_USERNAME"), DB_CONF.getString("DB_PASSWORD"));
			Statement stmt=con.createStatement();
			
			if (libelleAcheminement == null) libelleAcheminement = nomCommune;
			if (ligne == null) ligne = "''";
			if (latitude == null) latitude = "''";
			if (longitude == null) longitude = "''";
			
			String insert = "(Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude)";
			String data = "('" + codeCommune + "', '" + nomCommune + "', '" + codePostal + "', '" + libelleAcheminement + "', '" + ligne + "', '" + latitude + "', '" + longitude + "')";
			String query = "insert into ville_france" + insert + " values " + data;
			
			stmt.execute(query);
			return "c'est bon";
			
		}catch(Exception e){ System.out.println(e);}  
		
		return "c'est pas bon";
	}
	
	public String updateVilles(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement,
			String ligne, String latitude, String longitude) {
		System.out.println("updateVille");
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(DB_CONF.getString("DB_URL"),DB_CONF. getString("DB_USERNAME"), DB_CONF.getString("DB_PASSWORD"));
			Statement stmt=con.createStatement();
			String set = "Nom_commune = '" + nomCommune + "', Code_postal = '" + codePostal + "'";
			if (libelleAcheminement != null) set += ", Libelle_acheminement = '" + libelleAcheminement + "'";
			if (ligne != null) set += ", Ligne_5 = '" + ligne + "'";
			if (latitude != null) set += ", Latitude = '" + latitude + "'";
			if (longitude != null) set += ", Longitude = '" + longitude + "'";
			System.out.println(set);
			
			String query = "update ville_france set " + set + " where Code_commune_INSEE = " + codeCommune;
			
			stmt.executeUpdate(query);
			return "Les information de la ville ont bien étées mises à jour";
			
		}catch(Exception e){ System.out.println(e);}  
		
		return "Il y a eu un problème lors de la mise à jour";
	}
	
	public String deleteVilles(String codeCommune) {
		System.out.println("deleteVille");
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(DB_CONF.getString("DB_URL"),DB_CONF. getString("DB_USERNAME"), DB_CONF.getString("DB_PASSWORD"));
			Statement stmt=con.createStatement();
			
			String query = "delete from ville_france where Code_commune_INSEE = " + codeCommune;
			
			stmt.execute(query);
			return "La ville a bien été enlevée de la base de données";
		}catch(Exception e){ System.out.println(e);}  
		
		return "Il y a eu un problème lors de la suppression de la ville";
	}
	
	
}
