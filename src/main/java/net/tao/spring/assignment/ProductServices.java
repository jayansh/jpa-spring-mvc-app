package net.tao.spring.assignment;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class ProductServices {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> listAllProducts() {
		List<Product> products = new LinkedList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	public Optional<Product> getProductById(String productId) {
		return productRepository.findById(productId);
	}

	public Optional<Product> getProductByName(String productName) {
		return productRepository.findByName(productName);
	}

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public void delete(String productId) {
		productRepository.deleteById(productId);
	}

	public String updateProduct(String productId, String productName, String description) {
		Optional<Product> products = getProductById(productId);
		if (products.isPresent()) {
			Product product = products.get();
			product.setProductName(productName);
			product.setDescription(description);
			productRepository.save(product);
			return "success";
		} else {
			return "noupdate";
		}

	}
}
