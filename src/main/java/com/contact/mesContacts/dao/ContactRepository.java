package com.contact.mesContacts.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.contact.mesContacts.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	// :x est le paramètre
	//la méthode chercher est une sorte de méthode similaire à, par exemple, ContactRepository.findAll()
	//mais comme checher n'existe pas alors on vient la créer ici en spécifiant ce qu'elle fait avec rqête sql
	@Query("SELECT c FROM Contact c WHERE c.nom LIKE :x")
	public Page<Contact> chercher(@Param("x") String mc, Pageable pegeable);

}
