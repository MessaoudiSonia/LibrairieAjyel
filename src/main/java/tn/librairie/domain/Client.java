package tn.librairie.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_client;
	private int cin;
	private String pseudo;
	private String mdp;
	private String prenom;
	private String nom;
	private String email;
	private int tel;
	private String adresse;
}


