package com.contact.mesContacts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contact.mesContacts.dao.ContactRepository;
import com.contact.mesContacts.entities.Contact;

@SpringBootApplication
public class MesContactsApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(MesContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("DD/MM/YYYY");
		contactRepository.save(new Contact("assane","assane",df.parse("12/04/1989"),"ass@mail.fr", 695349,"photo.png"));
		contactRepository.save(new Contact("diallo","tairou",df.parse("02/04/1991"),"ta@mail.fr", 5435349,"ta.png"));
		contactRepository.save(new Contact("assane","assane",df.parse("02/04/1989"),"beuz@mail.fr", 65435349 ,"beuz.png"));
		contactRepository.save(new Contact("assane","assane",df.parse("22/04/1995"),"diz@mail.fr", 29789 , "diz.png"));
        
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});		
		
		
	}

}
