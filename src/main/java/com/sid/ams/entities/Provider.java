package com.sid.ams.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
public class Provider implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Nom obligatoire")
	@Column(name = "name")
	private String name;
	@NotBlank(message = "Adress obligatoire")
	private String adress;
	@NotBlank(message = "Email obligatoire")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "provider")
	//@JsonIgnoreProperties("provider")
	private List<Article> articles;

	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Provider(String name, String adress, String email) {
		super();
		this.name = name;
		this.adress = adress;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonManagedReference
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Provider [name=" + name + ", adress=" + adress + ", email=" + email + "]";
	}



}
