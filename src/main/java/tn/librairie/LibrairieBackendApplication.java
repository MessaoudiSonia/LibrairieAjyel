package tn.librairie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.librairie.domain.Categorie;
import tn.librairie.domain.Client;
import tn.librairie.domain.Facture;
import tn.librairie.domain.Panier;
import tn.librairie.domain.Produit;
import tn.librairie.repository.ICategorieRepository;
import tn.librairie.repository.IClientRepository;
import tn.librairie.repository.IFactureRepository;
import tn.librairie.repository.IPanierRepository;
import tn.librairie.repository.IProduitRepository;
@SpringBootApplication
public class LibrairieBackendApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}
	@Autowired
	ICategorieRepository categorie;
	
	public static void main(String[] args) {
		SpringApplication.run(LibrairieBackendApplication.class, args);	
	}
//	@Bean
//	public CommandLineRunner insertClient(IClientRepository repository)
//	{
//		return (args) -> {
//			repository.save(new Client(1,15004896,"M1","mdp","Messaoudi","Sonia","messaoudi@dede",25634189,"l'aouina"));
//			repository.save(new Client(2,15004896,"M2","mdp","Messaoudi","Sarra","sarra@dede",25634189,"soukra"));
//			repository.save(new Client(3,15004896,"M3","mdp","Messaoudi","Sihem","sihem@dede",25634189,"la marsa"));
//			repository.save(new Client(4,15004896,"M4","mdo","Messaoudi","Houssem","houssem@dede",25634189,"carthage"));
//		};
//	}
//	@Bean
//	public CommandLineRunner allClient(IClientRepository repo) {
//		return args ->  {
//			repo.findAll().forEach(System.out::println);
//		};
//	}
//	@Bean
//	public CommandLineRunner insertFacture(IFactureRepository repository)
//	{
//		return (args) -> {
//			repository.save(new Facture("1","12/12/2017",600));
//			repository.save(new Facture("2","5/08/2011",450));
//			repository.save(new Facture("3","10/09/2012",150.000));
//			repository.save(new Facture("4","18/12/2010",10.000));
//		};
//	}	
//	@Bean
//	public CommandLineRunner allFacture(IFactureRepository repo) {
//		return args ->  {
//			repo.findAll().forEach(System.out::println);
//		};
//	}
//	@Bean
//	public CommandLineRunner insertProduit(IProduitRepository repository)
//	{
//		return (args) -> {
//			repository.save(new Produit("2","Sac a dos", 50.000, 20, 2, "Sac PC", "https://previews.123rf.com/images/genika/genika1507/genika150700099/42086094-cartable-sur-fond-blanc.jpg"));	
//		};
//	}
//	@Bean
//	public CommandLineRunner insertPanier(IPanierRepository repository)
//	{
//		return (args) -> {
//			repository.save(new Panier("1","16/11/2016"));
//			repository.save(new Panier("2","16/16/2016"));
//		};
//	}
//	@Bean
//	public CommandLineRunner allPanier(IPanierRepository repo) {
//		return args ->  {
//			repo.findAll().forEach(System.out::println);
//		};
//	}
//	@Bean
//	public CommandLineRunner insertCategorie(ICategorieRepository repository)
//	{
//		return (args) -> {
//			repository.save(new Categorie("Fourniture"));
//			repository.save(new Categorie("Livre"));
//		};
//	}
	
//			@Bean
//			public CommandLineRunner insertCategorie (ICategorieRepository repository) {
//				return (args) -> {
//					Categorie categorie=new Categorie();
//					categorie.setId_categorie(22);
//					categorie.setLibelle_categorie("Roman");
//					repository.save(categorie);    
////					categorie=repository.getOne(22);
////         			System.out.println(categorie.getProduit().size());
//			};
//			}		
//		
//	@Bean
//	public CommandLineRunner allCategorie(ICategorieRepository repo) {
//		return args ->  {
//			repo.findAll().forEach(System.out::println);
//		};
//	}
//	
//	

	
//	@Bean
//	public CommandLineRunner insertProduit (IProduitRepository repository, ICategorieRepository categorieRepository) {
//	
//		return (args) -> {
//		 Categorie categorie=categorieRepository.getOne(1);
//         Produit produit=new Produit();
//         produit.setCategorie(categorie);
//         repository.save(produit);
//		};
//	}
//	@Bean
//	public CommandLineRunner allProduit(IProduitRepository repo) {
//		return args ->  {
//			repo.findAll().forEach(System.out::println);
//		};
//	}

}

