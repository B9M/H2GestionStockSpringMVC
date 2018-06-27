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

import com.stock.mvc.entities.Client;
import com.stock.mvc.service.IClientService;
import com.stock.mvc.service.IFlickrService;

@Controller
@RequestMapping(value = "/client")
public class ClientController {
	@Autowired
	private IClientService clientService;

	@Autowired
	private IFlickrService flickerService;

	@RequestMapping(value = "/")
	public String client(Model model) {
		List<Client> clients = clientService.selectAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients", clients);
		return "client/client";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		Client client = new Client();
		// client.setNom("badr");dans lajout le champs Nom il va fixer par default Badr
		model.addAttribute("client", client);
		return "client/ajouterClient";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregistrerClient(Model model, Client client, MultipartFile file) {
		String photoUrl = null;
		if (client != null) {
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickerService.savePhoto(stream, client.getNom());
					client.setPhoto(photoUrl);
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
			if (client.getIdClient() != null) {
				clientService.update(client);
			} else {
				clientService.save(client);
			}
		}

		return "redirect:/client/";
	}

	@RequestMapping(value = "/modifier/{idCli}")
	public String modifier(Model model, @PathVariable("idCli") Long idClient) {
		if (idClient != null) {
			Client client = clientService.getById(idClient);
			if (client != null) {
				model.addAttribute("client", client);
			}
		}
		return "client/modifierClient";
	}

	@RequestMapping(value = "/supprimer/{idCli}")
	public String supprimer(Model model, @PathVariable("idCli") Long idClient) {
		if(idClient != null) {
			Client client = clientService.getById(idClient);
			if (client != null ) {
				clientService.remove(client.getIdClient());				
			}
		}
		
		return "redirect:/client/";
	}
}
