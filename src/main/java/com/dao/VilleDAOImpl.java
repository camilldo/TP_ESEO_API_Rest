package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO{
	public ArrayList<Ville> findAllVilles(){
		System.out.println("findAllVilles");
		
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tp_maven","root","network");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from ville_france");  
			while(rs.next()) {
				Ville ville = new Ville(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				listVille.add(ville);
			}
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
		return listVille;
	}
	
	public ArrayList<Ville> findAllVillesCodePostal(String codePostal){
		System.out.println("findAllVilles");
		
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tp_maven","root","network");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from ville_france where Code_postal = " + codePostal);
			while(rs.next()) {
				Ville ville = new Ville(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				listVille.add(ville);
			}
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
		return listVille;
	}
}
