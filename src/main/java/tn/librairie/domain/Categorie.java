package tn.librairie.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="Categorie")
@Data
@NoArgsConstructor
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_categorie;
	private String libelle_categorie;
	@OneToMany(cascade=CascadeType.ALL, fetch= FetchType.EAGER, mappedBy="categorie")
	private List<Produit> produit;
	
	public Categorie(String libelle_categorie) {
	super();
	this.libelle_categorie = libelle_categorie;
	
}
}
