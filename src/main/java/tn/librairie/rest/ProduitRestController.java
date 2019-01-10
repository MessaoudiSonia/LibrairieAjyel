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

import tn.librairie.domain.Produit;
import tn.librairie.repository.IProduitRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("produit")

public class ProduitRestController {
 private IProduitRepository repository;
	 
	 public ProduitRestController(IProduitRepository repository) {
		this.repository = repository;
	}
	 @GetMapping
		public List<Produit> AllProduit() {
			return repository.findAll();
		}
	 @GetMapping(path= "/{id}" )
		public  ResponseEntity<Produit> findById(@PathVariable("id") String id) {
			Optional<Produit> resultat =  repository.findById(id);
			if (resultat.isPresent())
				return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	 @PostMapping
		public ResponseEntity<Produit> create(@RequestBody Produit p) {
			try {
				repository.save(p);
				return new ResponseEntity<Produit>(p, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<Produit>(HttpStatus.NOT_ACCEPTABLE);
			}

		}
		@PutMapping
		public  ResponseEntity<Produit> update(@RequestBody Produit p){	 
			 try {
					repository.save(p);
					return new ResponseEntity<Produit>(p, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Produit>(HttpStatus.NOT_ACCEPTABLE);
				}	
		}
		@DeleteMapping(path= "/{id}" )
		public  ResponseEntity<Produit> deleteById(@PathVariable("id") String id) {
			Optional<Produit> resultat =  repository.findById(id);
			if (resultat.isPresent()) {
				 repository.delete(resultat.get());
				 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
}
