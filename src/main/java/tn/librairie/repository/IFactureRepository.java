package tn.librairie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.librairie.domain.Facture;

public interface IFactureRepository extends JpaRepository<Facture, String> {

}
