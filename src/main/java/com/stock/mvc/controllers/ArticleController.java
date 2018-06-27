package com.stock.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.stock.mvc.entities.Article;
import com.stock.mvc.entities.Category;
import com.stock.mvc.service.IArticleService;
import com.stock.mvc.service.ICategoryService;
import com.stock.mvc.service.IFlickrService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private ICategoryService catService;

	@Autowired
	private IFlickrService flickerService;

	@RequestMapping(value = "/")
	public String article(Model model) {
		List<Article> articles = articleService.selectAll();
		if (articles == null) {
			articles = new ArrayList<Article>();
		}
		model.addAttribute("articles", articles);
		return "article/article";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		Article article = new Article();
		List<Category> categories = catService.selectAll();
		if (categories == null) {
			categories = new ArrayList<Category>();
		}
		// client.setNom("badr");dans lajout le champs Nom il va fixer par default Badr
		model.addAttribute("article", article);
		model.addAttribute("categories", categories);
		return "article/ajouterArticle";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregistrerClient(Model model, Article article, MultipartFile file) {
		String photoUrl = null;
		if (article != null) {
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickerService.savePhoto(stream, article.getCodeArticle());
					article.setPhoto(photoUrl);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
			if (article.getIdArticle() != null) {
				articleService.update(article);
			} else {
				articleService.save(article);
			}
		}

		return "redirect:/article/";
	}

	@RequestMapping(value = "/modifier/{idArticle}")
	public String modifier(Model model, @PathVariable Long idArticle) {
		if (idArticle != null) {
			Article article =articleService.getById(idArticle);
			
			List<Category> categories = catService.selectAll();
			if (categories == null) {
				categories = new ArrayList<Category>();
				
			}
			model.addAttribute("categories", categories);
			if (article != null) {
				model.addAttribute("article", article);
			
			
				//if (categories != null) {
//					categories = new ArrayList<Category>();
				//model.addAttribute("categories", categories);
				//}
				
			}
		}
		return "article/modifierArticle";
	}

	@RequestMapping(value = "/supprimer/{idArticle}")
	public String supprimer(Model model, @PathVariable Long idArticle) {
		if(idArticle != null) {
			Article article =articleService.getById(idArticle);
			if (article != null ) {
				articleService.remove(article.getIdArticle());			
			}
		}
		
		return "redirect:/article/";
	}
}
