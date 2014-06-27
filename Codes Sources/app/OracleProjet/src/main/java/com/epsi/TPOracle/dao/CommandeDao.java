package com.epsi.TPOracle.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epsi.TPOracle.entities.Commande;
import com.epsi.TPOracle.entities.Panier;
import com.epsi.TPOracle.entities.Produit;

@Repository
public class CommandeDao extends AbstractDao<Commande,Integer> {
	
	public CommandeDao(){
		super();
	}
	
	public Commande find(int id){
		return this.find(Commande.class, id);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Commande> getAllCommandeByPanier(Panier panier){
		return getHibernateTemplate().find("from Commande c where c.id=?",panier.getId());
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Commande> getProduitCommandeByPanier(Panier panier,Produit produit){
		
		String str="from Commande c where c.panier=? and c.produit=? ";
		List<Integer> queryParam=new ArrayList<Integer>();
		queryParam.add(panier.getId()); 
		queryParam.add(produit.getId());
		List<Commande> list=getHibernateTemplate().find(str,queryParam.toArray());
		return list;
	}
	
	public void deleteProduitCommandeByPanier(Panier panier,Produit produit){
	    List<Commande> commandes=this.getProduitCommandeByPanier(panier,produit);
	    for(final Commande com : commandes){
	    	this.delete(com);
	    }
	}
	
	public void deleteAllCommandeByPanier(Panier panier){
	    List<Commande> commandes=this.getAllCommandeByPanier(panier);
	    for(final Commande com : commandes){
	    	this.delete(com);
	    }
	}

}
