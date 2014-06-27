package com.epsi.TPOracle.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CommandeId {
	private Panier panier;
	private Produit produit;
	
	@ManyToOne
	public Panier getPanier(){
		return this.panier;
	}
	
	public void setPanier(Panier panier){
		this.panier=panier;
	}
	
	@ManyToOne
	public Produit getProduit(){
		return this.produit;
	}
	
	public void setProduit(Produit produit){
		this.produit=produit;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        CommandeId that = (CommandeId) o;
 
        if (panier != null ? !panier.equals(that.panier) : that.panier != null) return false;
        if (produit != null ? !produit.equals(that.produit) : that.produit != null)
            return false;
 
        return true;
    }
 
    public int hashCode() {
        int result;
        result = (panier != null ? panier.hashCode() : 0);
        result = 31 * result + (produit != null ? produit.hashCode() : 0);
        return result;
    }

}
