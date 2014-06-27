package com.epsi.TPOracle.service;

import java.util.List;

import com.epsi.TPOracle.dao.ProduitDao;
import com.epsi.TPOracle.entities.Produit;



public class ProduitService {
	
	ProduitDao produitDao;
	
	public ProduitService(){
		produitDao=new ProduitDao();
	}
	
	
	public List<Produit> list(){
		return produitDao.list(Produit.class);
	}

}
