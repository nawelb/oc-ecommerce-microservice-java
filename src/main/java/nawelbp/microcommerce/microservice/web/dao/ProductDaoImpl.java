//package nawelbp.microcommerce.microservice.web.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import nawelbp.microcommerce.microservice.model.Product;
//
//@Repository
//public class ProductDaoImpl implements ProductDao{
//
//	public static List<Product> products = new ArrayList<Product>();
//
//	   static {
//	       products.add(new Product(1, "Ordinateur portable", 350));
//	       products.add(new Product(2, "Aspirateur Robot", 500));
//	       products.add(new Product(3, "Table de Ping Pong", 750));
//	   }
//
//	@Override
//	public List<Product> findAll() {
//		return products;
//	}
//
//	@Override
//	public Product findById(int id) {
//		for (Product product : products){
//	           if (product.getId() == id){
//	               return product;
//	           }
//	       }
//		return null;
//	}
//
//	@Override
//	public Product saveProduct(Product product) {
//		 products.add(product);
//		return product;
//	}
//
//}
