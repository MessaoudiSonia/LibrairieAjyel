package tn.librairie.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Panier")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Panier {
	 @Id
	String id;
	String date;
}
