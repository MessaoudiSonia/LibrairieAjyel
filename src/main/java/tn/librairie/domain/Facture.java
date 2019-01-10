package tn.librairie.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Facture")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
	@Id
 private String reference;
 private String date;
 private double montant;
}

