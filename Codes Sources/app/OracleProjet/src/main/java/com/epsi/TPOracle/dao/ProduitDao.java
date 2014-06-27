package com.epsi.TPOracle.dao;

import org.springframework.stereotype.Repository;

import com.epsi.TPOracle.entities.Produit;

@Repository
public class ProduitDao extends AbstractDao<Produit,Integer> {
	
	public ProduitDao()
	{
		super();
	}
	
	public Produit find(int id){
		return this.find(Produit.class, id);
	}
	
	

}
