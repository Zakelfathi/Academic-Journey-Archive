package com.ensa.tp5.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensa.tp5.dao.repoInscription;
import com.ensa.tp5.entities.Etudiant;
import com.ensa.tp5.entities.Reinscription;

@Controller
public class controllerInscription {
	@Autowired
	private repoInscription repInscription;
	

	@RequestMapping(value = "/form_inscription", method = RequestMethod.GET)
	public String formInscription(Model model) {
		model.addAttribute("inscription", new Reinscription());
		   Reinscription inscription = new Reinscription();
		   inscription.setEtudiant(new Etudiant()); // create a new Etudiant object and set it in the inscription

		return "form-part2";
	}

	@RequestMapping(value = "/save_inscription", method = RequestMethod.POST)
	public String save(Model model, @Valid Reinscription inscription, BindingResult bindingResult, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "5") int s,
			@RequestParam(name = "mc", defaultValue = "") String mc) {
		Page<Reinscription> pageInscriptions = repInscription.chercher("%" + mc + "%", PageRequest.of(p, s));
		model.addAttribute("listInscriptions",pageInscriptions.getContent());
//		tableau de pages
		int[] pages = new int[pageInscriptions.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("currentPage", p);
		model.addAttribute("mc", mc);
 
		if (bindingResult.hasErrors())
			return "form-part2";
		repInscription.save(inscription);
		return "ajoutInscriptionConfirmation";
	}


}
