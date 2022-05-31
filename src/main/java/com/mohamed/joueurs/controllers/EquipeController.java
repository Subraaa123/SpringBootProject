package com.mohamed.joueurs.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohamed.joueurs.entities.Equipe;
import com.mohamed.joueurs.service.EquipeService;
import com.mohamed.joueurs.service.JoueurService;
@Controller
public class EquipeController {
	
	@Autowired
	JoueurService joueurService;
	@Autowired
	EquipeService equipeService;
	
	
	@RequestMapping("/showCreateEquipe")
	public String showCreateEquipe(ModelMap modelMap)
	{
	modelMap.addAttribute("equipes", new Equipe());
	modelMap.addAttribute("mode", "new");
	return "formEquipe";
	}
	@RequestMapping("/saveEquipe")
	public String saveEquipe(@ModelAttribute("equipe") Equipe equipe,ModelMap modelMap) throws ParseException 
	{
	Equipe saveEquipe = equipeService.saveEquipe(equipe);
	return "redirect:/ListeEquipe";
	}

	@RequestMapping("/ListeEquipe")
	public String listeEquipe(ModelMap modelMap ,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
	{
		Page<Equipe> equipes = equipeService.getAllEquipeParPage(page, size);
		
		
		modelMap.addAttribute("equipes", equipes);
		modelMap.addAttribute("pages", new int[equipes.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeEquipe";
	}
	@RequestMapping("/modifierEquipe")
	public String editerEquipe(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Equipe c= equipeService.getEquipe(id);
	modelMap.addAttribute("equipes", c);
	modelMap.addAttribute("mode", "edit");
	return "formEquipe";
	}
	@RequestMapping("/updateEquipe")
	public String updateEquipe(@ModelAttribute("equipe") Equipe equipe,ModelMap modelMap) throws ParseException {
		equipeService.updateEquipe(equipe);
		 List<Equipe> equipes = equipeService.findAll();
		 modelMap.addAttribute("equipes", equipes);
		return "ListeEquipe";
		}
	@RequestMapping("/supprimerEquipe")
	public String supprimerEquipe(@RequestParam("id") Long id,
	 ModelMap modelMap)
	{ 
	equipeService.deleteEquipeById(id);
	List<Equipe> equipes = equipeService.findAll();
	modelMap.addAttribute("equipes", equipes);
	return "ListeEquipe";
	}
	

}
