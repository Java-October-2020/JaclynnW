package com.jaclynn.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.productsandcategories.models.Category;
import com.jaclynn.productsandcategories.models.Product;
import com.jaclynn.productsandcategories.repositories.CategoryRepository;
import com.jaclynn.productsandcategories.repositories.ProductRepository;

@Service
public class ProductsCategoriesServices {
	@Autowired
	private ProductRepository pRepo;
	@Autowired
	private CategoryRepository cRepo;

	
	//Get All
	public List<Product> getAllProducts(){
		return this.pRepo.findAll();
	}
	public List<Category> getAllCategories(){
		return this.cRepo.findAll();
	}

	//Get One
	public Product getOneProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public Category getOneCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	//Create
	public Product createProduct(Product newProduct) {
		return this.pRepo.save(newProduct);
	}
	public Category createCategory(Category newCategory) {
		return this.cRepo.save(newCategory);
	}

	
	public List<Category> findCategoriesNotInProduct(Product product){
		return cRepo.findByProductsNotContains(product);
		
	}
	public List<Product> findProductsNotInCategories(Category category){
		return pRepo.findByCategoriesNotContains(category);
	}
}
