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
@Table(name="Contact")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contact {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nom;
	String mail;
	int tel;
	String message;
}
