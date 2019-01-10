package tn.librairie.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="Produit")
@Data
@NoArgsConstructor
	public class Produit {
		@Id
	 private String Reference_Produit;
	 private String Libelle;
	 private double Prix;
	 private int Qte;
	 private int Qte_seuil;
	 private String Description;
	 private String Image;
	 private int Favorie;
	 @ManyToOne (fetch=FetchType.EAGER)
	 @JsonBackReference
	 private Categorie categorie;
	 public Produit(String reference_Produit, String libelle, double prix, int qte, int qte_seuil,String description, String image,  int favorie) {
			super();
			Reference_Produit = reference_Produit;
			Libelle = libelle;
			Prix = prix;
			Qte = qte;
			Qte_seuil = qte_seuil;
			Description = description;
			Image = image;
			Favorie = favorie;
			
		}
	}