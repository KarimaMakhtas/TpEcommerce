package com.epsi.TPOracle.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="CLIENT")
public class User {
	
	@Id
	@SequenceGenerator(name="my_seq",sequenceName="client_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq")
	@Column(name="code_client")
	private int id;
	
	@Column(name="nom_client",nullable=false,length=200)
	private String nomUser;
	
	@Column(name="prenom_client",nullable=false,length=200)
	private String prenomUser;
	
	@Column(name="email",nullable=false,length=250)
	private String email;
	
	@Column(name="password",nullable=false,length=250)
	private String password;
	
	@OneToOne
	@JoinColumn(name="panier_fk")
	private Panier panier;
	
	public Panier getPanier(){
		return this.panier;
	}
	
	public void setPanier(Panier panier){
		this.panier=panier;
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	public String getNom()
	{
		return nomUser;
	}
	
	public String getPrenom()
	{
		return prenomUser;
	}
	
	public void setNom(String nom)
	{
		this.nomUser=nom;
	}
	
	public void setPrenom(String prenom)
	{
		this.prenomUser=prenom;
	}

}
