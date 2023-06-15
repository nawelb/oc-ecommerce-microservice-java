package nawelbp.microcommerce.microservice.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nawelbp.microcommerce.microservice.model.Product;
import nawelbp.microcommerce.microservice.web.dao.ProductDao;
import nawelbp.microcommerce.microservice.web.exceptions.ProduitIntrouvableException;

@Api("API pour les opérations CRUD sur les produits.")
@RestController
public class ProductController {
	
	@Autowired
    private ProductDao productDao;


    
	@GetMapping("/Produits")
	public Iterable<Product> afficherListeProduits() {
		return productDao.findAll();
	}
	
	@ApiOperation(value = "Récupère un produit grâce à son ID à condition que celui-ci soit en stock!")
	@GetMapping(value= "/Produits/{id}")
	public Product afficherProduit(@PathVariable int id) {
		Product produit = productDao.findById(id);
		if(produit==null) {
			throw new ProduitIntrouvableException("Le produit avec l'id :"+id+" est introuvable.");
		}
		return produit;
	}
	
	@PostMapping(value ="/Produits/produit")
	public Product saveProduct(@Valid @RequestBody Product product) {
		return productDao.save(product);
	}
	
	@DeleteMapping(value="Produits/{id}")
	public void supprimerProduit(@PathVariable int id) {
		productDao.deleteById(id);
	}
	
	@PutMapping(value="/Produits")
	public void updateProduit(@RequestBody Product produit) {
		productDao.save(produit);
	}
}
