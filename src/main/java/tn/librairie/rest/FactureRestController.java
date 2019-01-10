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
import tn.librairie.domain.Facture;
import tn.librairie.repository.IFactureRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("facture")

public class FactureRestController {
 private IFactureRepository repository;
	 
	 public FactureRestController(IFactureRepository repository) {
		this.repository = repository;
	}
	 @GetMapping
		public List<Facture> AllFacture() {
			return repository.findAll();
		}
	 @GetMapping(path= "/{id}" )
		public  ResponseEntity<Facture> findById(@PathVariable("id") String id) {
			Optional<Facture> resultat =  repository.findById(id);
			if (resultat.isPresent())
				return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	 @PostMapping
		public ResponseEntity<Facture> create(@RequestBody Facture c) {
			try {
				repository.save(c);
				return new ResponseEntity<Facture>(c, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<Facture>(HttpStatus.NOT_ACCEPTABLE);
			}

		}
		@PutMapping
		public  ResponseEntity<Facture> update(@RequestBody Facture c){	 
			 try {
					repository.save(c);
					return new ResponseEntity<Facture>(c, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Facture>(HttpStatus.NOT_ACCEPTABLE);
				}	
		}
		@DeleteMapping(path= "/{id}" )
		public  ResponseEntity<Facture> deleteById(@PathVariable("id") String id) {
			Optional<Facture> resultat =  repository.findById(id);
			if (resultat.isPresent()) {
				 repository.delete(resultat.get());
				 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
}
