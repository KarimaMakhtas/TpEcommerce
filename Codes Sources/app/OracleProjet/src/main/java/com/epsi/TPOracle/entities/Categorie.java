package com.epsi.TPOracle.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="CATEGORIE_PRODUIT")
public class Categorie {
	
	@Id
	@SequenceGenerator(name="my_seq_categ",sequenceName="categorie_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq_categ")
	@Column(name="code_categorie")
	private int id;
	
	@Column(name="libelle_categorie",nullable=false,length=100)
	private String categorie;
	
	@OneToMany
	private List<Produit> produits=new ArrayList<>();
	
	public List<Produit> getProduit(){
		return this.produits;
	}
	
	public void setProduit(List<Produit> produits){
		this.produits=produits;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getCategorie()
	{
		return categorie;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void setCategorie(String categorie)
	{
		this.categorie=categorie;
	}

}
