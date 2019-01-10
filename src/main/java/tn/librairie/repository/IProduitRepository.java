package tn.librairie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.librairie.domain.Produit;
public interface IProduitRepository  extends JpaRepository<Produit, String> {


}
