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




import com.stock.mvc.entities.Utilisateur;

import com.stock.mvc.service.IFlickrService;
import com.stock.mvc.service.IUtilisateurService;

@Controller
@RequestMapping(value = "/utilisateur")
public class UtilisateurController {
	@Autowired
	private IUtilisateurService utilisateurService;

	@Autowired
	private IFlickrService flickerService;

	@RequestMapping(value = "/")
	public String client(Model model) {
		List<Utilisateur> utilisateurs = utilisateurService.selectAll();
		if (utilisateurs == null) {
			utilisateurs = new ArrayList<Utilisateur>();
		}
		model.addAttribute("utilisateurs", utilisateurs);
		return "utilisateur/utilisateur";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterUtilisateur(Model model) {
		Utilisateur utilisateur = new Utilisateur();
		// client.setNom("badr");dans lajout le champs Nom il va fixer par default Badr
		model.addAttribute("utilisateur", utilisateur);
		return "utilisateur/ajouterUtilisateur";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregistrerUtilisateur(Model model, Utilisateur utilisateur, MultipartFile file) {
		String photoUrl = null;
		if (utilisateur != null) {
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickerService.savePhoto(stream, utilisateur.getNom());
					utilisateur.setPhoto(photoUrl);
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
			if (utilisateur.getIdUtilisateur() != null) {
				utilisateurService.update(utilisateur);
			} else {
				utilisateurService.save(utilisateur);
			}
		}

		return "redirect:/utilisateur/";
	}

	@RequestMapping(value = "/modifier/{idUser}")
	public String modifier(Model model, @PathVariable("idUser") Long idUtilisateur) {
		if (idUtilisateur != null) {
			Utilisateur utilisateur = utilisateurService.getById(idUtilisateur);
			if (utilisateur != null) {
				model.addAttribute("utilisateur", utilisateur);
			}
		}
		return "utilisateur/modifierUtilisateur";
	}

	@RequestMapping(value = "/supprimer/{idUser}")
	public String supprimer(Model model, @PathVariable("idUser") Long idUtilisateur) {
		if(idUtilisateur != null) {
			Utilisateur utilisateur = utilisateurService.getById(idUtilisateur);
			if (utilisateur != null ) {
				utilisateurService.remove(utilisateur.getIdUtilisateur());				
			}
		}
		
		return "redirect:/utilisateur/";
	}
}
