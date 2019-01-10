package tn.librairie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.librairie.domain.Client;

public interface IClientRepository extends JpaRepository<Client,Integer> {

}
