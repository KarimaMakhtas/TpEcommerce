package com.epsi.TPOracle.dao;

import org.springframework.stereotype.Repository;

import com.epsi.TPOracle.entities.Categorie;

@Repository
public class CategorieDao extends AbstractDao<Categorie,Integer> {

	public CategorieDao()
	{
		super();
	}
	
	public Categorie find(int id){
		return this.find(Categorie.class, id);
	}
}
