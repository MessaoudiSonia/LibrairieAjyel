package tn.librairie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.librairie.domain.Contact;

public interface IContactRepository extends JpaRepository<Contact, Integer> {

}
