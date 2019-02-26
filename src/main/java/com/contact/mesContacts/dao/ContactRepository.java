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
	@Query("select c from Contact where c.nom like :x")
	public Page<Contact> chercher(@Param("x") String mc, Pageable pegeable);

}
