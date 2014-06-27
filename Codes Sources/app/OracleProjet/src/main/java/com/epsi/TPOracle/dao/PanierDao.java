package com.epsi.TPOracle.dao;

import org.springframework.stereotype.Repository;

import com.epsi.TPOracle.entities.Panier;

@Repository
public class PanierDao extends AbstractDao<Panier,Integer> {
	
	public PanierDao(){
		super();
	}
	
	public Panier find(int id){
		return this.find(Panier.class,id);
	}
	
	

}
