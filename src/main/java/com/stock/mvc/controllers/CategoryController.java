package com.stock.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stock.mvc.entities.Category;
import com.stock.mvc.service.ICategoryService;
@Controller
@RequestMapping(value="/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryservice;
	
	@RequestMapping(value="/")
	public String afficherCatgory(Model model) {
		List<Category> category = categoryservice.selectAll();
		model.addAttribute("categories",category);
		return "category/category";
	}
	
	@RequestMapping(value="/nouveau",method = RequestMethod.GET)
	public String ajouterCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category",category);
		return "category/ajouterCategory";
	}
	
	@RequestMapping(value="/enregistrer",method = RequestMethod.POST)
	public String enregistrer(Model model,Category category) {
		if (category != null) {
			if(category.getIdCategory() != null) {
				categoryservice.update(category);
			}
			else {
				categoryservice.save(category);
			}
		}
		return "redirect:/category/";
	}
	
	@RequestMapping(value="/modifier/{idCat}")
	public String modifier(Model model,@PathVariable("idCat") Long idCategory) {
		if(idCategory != null) {
			Category category = categoryservice.getById(idCategory);	
			if(category != null) {				
				model.addAttribute("category",category);
			}
		}
		return "/category/modifierCategory";
	}
	
	@RequestMapping(value = "/supprimer/{idCat}")
	public String supprimer(Model model, @PathVariable("idCat") Long idCategory) {
		if(idCategory != null) {
			Category category = categoryservice.getById(idCategory);
			if (category != null ) {
				categoryservice.remove(category.getIdCategory());				
			}
		}
		
		return "redirect:/category/";
	}
}
