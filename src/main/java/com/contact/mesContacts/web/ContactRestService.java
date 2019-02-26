package com.contact.mesContacts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contact.mesContacts.dao.ContactRepository;
import com.contact.mesContacts.entities.Contact;

@RestController
public class ContactRestService {
	
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	// Methode permettant de retourner la liste des contacts
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}
	
	// Méthode permettant de retouner un contact par son id 
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
	public Contact getContact(@PathVariable("id") Long id) {
		return contactRepository.findOne(id);
	}
	
	// Méthode permettant de retouner un contact par son id 
	
	@RequestMapping(value="/chercherContacts", method=RequestMethod.GET)
	public Page<Contact> chercher(
			@RequestParam(name="mc", defaultValue="") String mc, 
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="5") int size){
		return contactRepository.chercher(mc, new PageRequest(page, size)) ;
		
	}
	
	// Méthode permettant l'ajout d'un nouveau contact
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public Contact save(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
	// Méthode permettant de supprimer un contact
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") Long id) {
		contactRepository.delete(id); 
		return true;
	}
	
	// Méthode permettant modifier contact
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.PUT)
	public Contact save(@PathVariable Long id, @RequestBody Contact contact) {
		contact.setId(id);
		return contactRepository.save(contact);
	}


}
