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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PANIER")
public class Panier {
	@Id
	@SequenceGenerator(name="my_seq_pan",sequenceName="panier_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq_pan")
	@Column(name="code_panier")
	private int id;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="pk.panier",cascade=CascadeType.ALL)
	private Set<Commande> commandes=new HashSet<Commande>(0);
	
	public void setCommande(Set<Commande> commandes){
		this.commandes=commandes;
	}
	
	public Set<Commande> getCommande(){
		return this.commandes;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}


}
