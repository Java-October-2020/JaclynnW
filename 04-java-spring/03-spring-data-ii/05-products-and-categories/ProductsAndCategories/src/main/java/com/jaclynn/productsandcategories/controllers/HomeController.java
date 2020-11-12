package com.jaclynn.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jaclynn.productsandcategories.models.Category;
import com.jaclynn.productsandcategories.models.Product;
import com.jaclynn.productsandcategories.services.ProductsCategoriesServices;

@Controller
public class HomeController {
	@Autowired
	private ProductsCategoriesServices pcService;
	
	@GetMapping("/products/new")
	public String addProduct(@ModelAttribute("product") Product product) {
		return "addproduct.jsp";
	}
	@PostMapping("/products/new")
	public String addNewProduct(@Valid @ModelAttribute("product") Product newProduct, BindingResult result) {
		if(result.hasErrors()) {
			return "addproduct.jsp";
		}
		else {
			this.pcService.createProduct(newProduct);
			return "redirect:/products/new";
		}
	}
	@GetMapping("/categories/new")
	public String addCategory(@ModelAttribute("category") Category category) {
		return "addcategory.jsp";
	}
	@PostMapping("/categories/new")
	public String addNewCategory(@Valid @ModelAttribute("category") Category newCategory, BindingResult result) {
		if(result.hasErrors()) {
			return "addcategory.jsp";
		}
		else {
			this.pcService.createCategory(newCategory);
			return "redirect:/products/new";
		}
	}
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("categories") Category category) {
		Product currentProduct = pcService.getOneProduct(id);
		List<Category> currentCategories = pcService.getAllCategories();
		List<Category> notUsedYet = pcService.findCategoriesNotInProduct(currentProduct);
		viewModel.addAttribute("product", currentProduct );
		viewModel.addAttribute("notUsedCategories", notUsedYet);
		viewModel.addAttribute("cat", currentCategories);
		return "showproduct.jsp";
	}

	
	
}
