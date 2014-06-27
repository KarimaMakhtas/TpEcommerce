package com.epsi.TPOracle.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUIT")
public class Produit {
	
	@Id
	@SequenceGenerator(name="my_seq_prod",sequenceName="produit_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq_prod")
	@Column(name="code_produit")
    private int id;
	
	@Column(name="libelle_produit",nullable=false,length=100)
	private String produit;
	
	@Column (name="stock_produit")
	private int stock;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categorie_fk")
	private Categorie categorie;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="pk.produit",cascade=CascadeType.ALL)
	private Set<Commande> commandes=new HashSet<Commande>(0);
	
	public Set<Commande> getCommande(){
		return this.commandes;
	}
	
	public void setCommande(Set<Commande> commandes){
		this.commandes=commandes;
	}
	
	public Categorie getCategorie()
	{
		return categorie;
	}
	
	public void setCategorie(Categorie categ)
	{
		this.categorie=categ;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public String getProduit()
	{
		return this.produit;
	}
	
	public void setProduit(String produit)
	{
		this.produit=produit;
	}
	
	public void setStock(int stock){
		this.stock=stock;
	}
	
	public int getStock(){
		return this.stock;
	}
	
	
}
