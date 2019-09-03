package net.tao.spring.assignment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@Autowired
	private ProductServices productServices;

	@GetMapping("/")
	public List<Product> listProducts() {
		return productServices.listAllProducts();
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public void addProduct(@RequestBody Product product) {
		productServices.addProduct(product);
	}

	@GetMapping(value = "/getProduct")
	public Optional<Product> getProduct(@RequestParam(name = "productId", required = true) String productId) {
		return productServices.getProductById(productId);
	}

	@PostMapping(value = "/updateProduct")
	public void updateProduct(@RequestParam(name = "productId", required = true) String productId,
			@RequestParam(name = "productName", required = true) String productName,
			@RequestParam(name = "description", required = true) String description, Model model) {
		String result = productServices.updateProduct(productId, productName, description);
		model.addAttribute("result", result);
	}
}
