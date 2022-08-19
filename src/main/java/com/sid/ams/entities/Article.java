package com.sid.ams.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
public class Article implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "label")
	@NotBlank(message = "Label is mandatory")
	private String label;
	private float price;
	@Column(name = "picture")
	private String picture;
	@Column(name = "photoFace")
	private String photoFace;
	

	@Column(name = "photoProfil")
	private String photoProfil;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "provider_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties("articles")
	private Provider provider;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(@NotBlank(message = "Label est mandatory") String label, float price, String picture,String photoFace, String photoProfil) {
		super();
		this.label = label;
		this.price = price;
		this.picture = picture;
		this.photoFace = photoFace;
		this.photoProfil = photoProfil;
		
	}
	
	public String getPhotoFace() {
		return photoFace;
	}

	public void setPhotoFace(String photoFace) {
		this.photoFace = photoFace;
	}

	public String getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(String photoProfil) {
		this.photoProfil = photoProfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	@JsonBackReference
	public Provider getProvider() {
		return provider;
	}

	//@JsonSetter
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


}
