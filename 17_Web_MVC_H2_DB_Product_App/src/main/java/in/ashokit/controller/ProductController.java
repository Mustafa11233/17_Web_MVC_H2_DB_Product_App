package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.Product;
import in.ashokit.repo.ProductRepo;

@Controller
public class ProductController {
	@Autowired
	private ProductRepo repo;
	
	@GetMapping("/")
	public String loadForm(Model model) {
		
		model.addAttribute("product", new Product());
		
		return "index";
		
		
		
	}
	@PostMapping("save")
	public String save(@ModelAttribute("product") Product p,Model model) {
		
		System.out.println(p);
		Product product = repo.save(p);
		
		if(product.getPid()!=null) {
			model.addAttribute("msg","Product Saved...");
		}
		
		
		//model.addAttribute("product", new Product());
		
		
		return "index";
		
		
		
	}
	@GetMapping("/product")
	public String loadProduct(Model model) {
		
		model.addAttribute("products",repo.findAll());
		
		return "data";
	}

}
