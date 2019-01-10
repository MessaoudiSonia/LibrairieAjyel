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
import tn.librairie.domain.Panier;
import tn.librairie.repository.IPanierRepository;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("panier")

public class PanierRestController {
 private IPanierRepository repository;
	 
	 public PanierRestController(IPanierRepository repository) {
		this.repository = repository;
	}
	 @GetMapping
		public List<Panier> AllPanier() {
			return repository.findAll();
		}
	 @GetMapping(path= "/{id}" )
		public  ResponseEntity<Panier> findById(@PathVariable("id") String id) {
			Optional<Panier> resultat =  repository.findById(id);
			if (resultat.isPresent())
				return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	 @PostMapping
		public ResponseEntity<Panier> create(@RequestBody Panier p) {
			try {
				repository.save(p);
				return new ResponseEntity<Panier>(p, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<Panier>(HttpStatus.NOT_ACCEPTABLE);
			}

		}
		@PutMapping
		public  ResponseEntity<Panier> update(@RequestBody Panier p){	 
			 try {
					repository.save(p);
					return new ResponseEntity<Panier>(p, HttpStatus.ACCEPTED);
				} catch (Exception e) {
					return new ResponseEntity<Panier>(HttpStatus.NOT_ACCEPTABLE);
				}	
		}
		@DeleteMapping(path= "/{id}" )
		public  ResponseEntity<Panier> deleteById(@PathVariable("id") String id) {
			Optional<Panier> resultat =  repository.findById(id);
			if (resultat.isPresent()) {
				 repository.delete(resultat.get());
				 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
}
