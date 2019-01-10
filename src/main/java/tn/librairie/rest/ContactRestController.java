package tn.librairie.rest;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.librairie.domain.Contact;
import tn.librairie.repository.IContactRepository;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("contact")

public class ContactRestController {
 private IContactRepository repository;
	 
	 public ContactRestController(IContactRepository repository) {
		this.repository = repository;
	}
	 @GetMapping
		public List<Contact> AllContact() {
			return repository.findAll();
		}
	 @GetMapping(path= "/{id}" )
		public  ResponseEntity<Contact> findById(@PathVariable("id") int id) {
			Optional<Contact> resultat =  repository.findById(id);
			if (resultat.isPresent())
				return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	 @PostMapping
		public ResponseEntity<Contact> create(@RequestBody Contact p) {
			try {
				repository.save(p);
				return new ResponseEntity<Contact>(p, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<Contact>(HttpStatus.NOT_ACCEPTABLE);
			}

		}
		@PutMapping
		public  ResponseEntity<Contact> update(@RequestBody Contact p){	 
			 try {
					repository.save(p);
					return new ResponseEntity<Contact>(p, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Contact>(HttpStatus.NOT_ACCEPTABLE);
				}	
		}
		@DeleteMapping(path= "/{id}" )
		public  ResponseEntity<Contact> deleteById(@PathVariable("id") int id) {
			Optional<Contact> resultat =  repository.findById(id);
			if (resultat.isPresent()) {
				 repository.delete(resultat.get());
				 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
}
