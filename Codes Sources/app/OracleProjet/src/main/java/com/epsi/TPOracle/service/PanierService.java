package com.epsi.TPOracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epsi.TPOracle.dao.CommandeDao;
import com.epsi.TPOracle.dao.PanierDao;
import com.epsi.TPOracle.entities.Commande;
import com.epsi.TPOracle.entities.Panier;
import com.epsi.TPOracle.entities.Produit;

@Service
public class PanierService {
	
	@Autowired
	PanierDao panierDao;
	
	@Autowired
	CommandeDao commandeDao;
	
	public PanierService(){
		panierDao= new PanierDao();
		commandeDao=new CommandeDao();
	}
	
	public void vider(Panier panier){
	 commandeDao.deleteAllCommandeByPanier(panier);
	}
	
	public void supprimerProduit(Panier panier,Produit produit){
		commandeDao.deleteProduitCommandeByPanier(panier,produit);
		
	}
	
	public void ajouterProduit(Panier panier,Produit produit,int quantite){
		Commande commande=new Commande();
		commande.setPanier(panier);
		commande.setProduit(produit);
		commande.setQuantite(quantite);
		commandeDao.save(commande);
	}
	
	

}
