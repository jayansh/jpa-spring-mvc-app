package net.tao.spring.assignment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@Autowired
	private ProductServices productServices;

	@GetMapping("/")
	public String listProducts(Model model) {
		model.addAttribute("allProducts", productServices.listAllProducts());
		return "listproducts";
	}
	
	@GetMapping("/addProduct")
    public String productForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
	public String addProduct(@ModelAttribute Product product, Model model) {
		String result = productServices.addProduct(product);
		model.addAttribute("result", result);
		if(result.equals("success")) {
			return "redirect:/";
		} else {
			if(result.equals("duplicate")) {
				model.addAttribute("errorMessage", "Duplicate error!");
			}
			return "/addProduct";
		}
	}

	@GetMapping(value = "/updateProduct")
	public String getProduct(@RequestParam(name = "productId", required = true) String productId,Model model) {
		Optional<Product> products = productServices.getProductById(productId);
		if (products.isPresent()) {
			model.addAttribute("product",products.get());
		} /**TODO else return error*/
		return "/updateProduct";
	}

	@PostMapping(value = "/updateProduct")
	public String updateProduct(@RequestParam(name = "productId", required = true) String productId
			,@ModelAttribute Product product, Model model) {
		String result = productServices.save(product);
		model.addAttribute("result", result);
		return "redirect:/";
	}
	
	@PostMapping(value = "/deleteProduct")
	public String deleteProduct(@RequestParam(name = "productId", required = true) String productId
			,@ModelAttribute Product product, Model model) {
		productServices.delete(productId);
		return "redirect:/";
	}
}
