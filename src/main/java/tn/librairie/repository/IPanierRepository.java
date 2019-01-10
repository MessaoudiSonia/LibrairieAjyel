package tn.librairie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.librairie.domain.Panier;

public interface IPanierRepository extends JpaRepository<Panier, String> {

}
