package nawelbp.microcommerce.microservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Product {
	@Id
	private int id;
	
	@Size(min=3,max=25)
	private String nom;
	
	@Min(value=1)
	private int prix;
	
	private int prixAchat;
	
	public Product() {
	}
	
	public Product(int id, String nom, int prix) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}
	
	  public int getPrixAchat() {
	      return prixAchat;
	  }

	  public void setPrixAchat(int prixAchat) {
	      this.prixAchat = prixAchat;
	  }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix= prix;
	}
	
	 @Override
	  public String toString() {
	      return "Product{" +
	              "id=" + id +
	              ", nom='" + nom + '\'' +
	              ", prix=" + prix +
	              '}';
	  }
	

}
