package com.ensa.tp5.web;

import java.util.*;

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

import com.ensa.tp5.dao.repoEtudiant;
import com.ensa.tp5.entities.Etudiant;

@Controller
public class controllerEtudiant {
	@Autowired
	private repoEtudiant repEtudiant;

	@RequestMapping(value = "/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "6") int s,
			@RequestParam(name = "mc", defaultValue = "") String mc) {
		Page<Etudiant> pageEtudiants = repEtudiant.chercher("%" + mc + "%", PageRequest.of(p, s));
		model.addAttribute("listEtudiants", pageEtudiants.getContent());
//		tableau de pages
		int[] pages = new int[pageEtudiants.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("currentPage", p);
		model.addAttribute("mc", mc);

		return "affichageEtudiants-part1";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String formEtudiant(Model model) {
		model.addAttribute("etudiant", new Etudiant());

		return "form-part1";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model, @Valid Etudiant etudiant, BindingResult bindingResult, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "5") int s,
			@RequestParam(name = "mc", defaultValue = "") String mc) {
		Page<Etudiant> pageEtudiants = repEtudiant.chercher("%" + mc + "%", PageRequest.of(p, s));
		model.addAttribute("listEtudiants", pageEtudiants.getContent());
//		tableau de pages
		int[] pages = new int[pageEtudiants.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("currentPage", p);
		model.addAttribute("mc", mc);
 
		if (bindingResult.hasErrors())
			return "form-part1";
		repEtudiant.save(etudiant);
		return "ajoutEtudiantConfirmation";
	}

}
