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
import tn.librairie.repository.IClientRepository;
import tn.librairie.domain.Client;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("client")
public class ClientRestController {
	
	// Actions
	 private IClientRepository repository;
	 public ClientRestController(IClientRepository repository) {
		this.repository = repository;
	}
	 @GetMapping
		public List<Client> tousLesClients() {
			return repository.findAll();
		}
	 @GetMapping(path= "/{id}" )
		public  ResponseEntity<Client> findById(@PathVariable("id") int id) {
			Optional<Client> resultat =  repository.findById(id);
			if (resultat.isPresent())
				return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
		
		@PostMapping
		public ResponseEntity<Client> create(@RequestBody Client c) {
			try {
				repository.save(c);
				return new ResponseEntity<Client>(c, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<Client>(HttpStatus.NOT_ACCEPTABLE);
			}

		}
		@PutMapping
		public  ResponseEntity<Client> update(@RequestBody Client c){	 
			 try {
					repository.save(c);
					return new ResponseEntity<Client>(c, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Client>(HttpStatus.NOT_ACCEPTABLE);
				}	
		}

		
		@DeleteMapping(path= "/{id}" )
		public  ResponseEntity<Client> deleteById(@PathVariable("id") int id) {
			Optional<Client> resultat =  repository.findById(id);
			if (resultat.isPresent()) {
				 repository.delete(resultat.get());
				 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}


	}

