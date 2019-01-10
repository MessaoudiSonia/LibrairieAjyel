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
import tn.librairie.repository.ICategorieRepository;
import tn.librairie.domain.Categorie;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("categorie")
public class CategorieRestController {
	
		// Actions
		 private ICategorieRepository repository;
		 
		 public CategorieRestController(ICategorieRepository repository) {
			this.repository = repository;
		}
		 @GetMapping
			public List<Categorie> tousLesClients() {
				return repository.findAll();
			}
		 @GetMapping(path= "/{id}" )
			public  ResponseEntity<Categorie> findById(@PathVariable("id") int id) {
				Optional<Categorie> resultat =  repository.findById(id);
				if (resultat.isPresent())
					return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
				else
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}	
			
			@PostMapping
			public ResponseEntity<Categorie> create(@RequestBody Categorie c) {
				try {
					repository.save(c);
					return new ResponseEntity<Categorie>(c, HttpStatus.CREATED);
				} catch (Exception e) {
					return new ResponseEntity<Categorie>(HttpStatus.NOT_ACCEPTABLE);
				}

			}
			@PutMapping
			public  ResponseEntity<Categorie> update(@RequestBody Categorie c){	 
				 try {
						repository.save(c);
						return new ResponseEntity<Categorie>(c, HttpStatus.ACCEPTED);
					} catch (Exception e) {
						return new ResponseEntity<Categorie>(HttpStatus.NOT_ACCEPTABLE);
					}	
			}

			
			@DeleteMapping(path= "/{id}" )
			public  ResponseEntity<Categorie> deleteById(@PathVariable("id") int id) {
				Optional<Categorie> resultat =  repository.findById(id);
				if (resultat.isPresent()) {
					 repository.delete(resultat.get());
					 return new ResponseEntity<>(HttpStatus.ACCEPTED);
				}
				else
					return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}


		}

