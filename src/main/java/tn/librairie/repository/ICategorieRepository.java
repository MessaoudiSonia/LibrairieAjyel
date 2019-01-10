package tn.librairie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.librairie.domain.Categorie;


public interface ICategorieRepository extends JpaRepository<Categorie, Integer>  {


}
