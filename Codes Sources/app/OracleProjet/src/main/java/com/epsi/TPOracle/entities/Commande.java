package com.epsi.TPOracle.entities;

import java.beans.Transient;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="COMMANDE")
@AssociationOverrides({
	                   @AssociationOverride(name="pk.panier",
	                		   joinColumns=@JoinColumn(name="code_panier")),
	                   @AssociationOverride(name="pk.produit",
	                            joinColumns=@JoinColumn(name="code_produit"))})
public class Commande {
	
	private CommandeId pk=new CommandeId();
	private int quantite;
	
	@EmbeddedId
	public CommandeId getPk(){
		return this.pk;
	}
	
	public void setPk(CommandeId pk){
		this.pk=pk;
	}
	
	
	@Transient
	public Panier getPanier(){
		return getPk().getPanier();
	}
	
	public void setPanier(Panier panier){
	    getPk().setPanier(panier);
	}
	
	@Transient
	public Produit getProduit(){
		return getPk().getProduit();
	}
	
	public void setProduit(Produit produit){
		getPk().setProduit(produit);
	}
	
	@Column(name="quantite")
	public int getQuantite(){
		return this.quantite;
	}
	
	public void setQuantite(int quantite){
		this.quantite=quantite;
	}
	
	
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
 
		Commande that = (Commande) o;
 
		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;
 
		return true;
	}
 
	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
	

}
