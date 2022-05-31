package com.mohamed.joueurs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohamed.joueurs.entities.Equipe;
import com.mohamed.joueurs.entities.joueur;
import com.mohamed.joueurs.service.EquipeService;
import com.mohamed.joueurs.service.JoueurService;
@Controller
public class JoueurController {
@Autowired
JoueurService joueurService;
@Autowired
EquipeService equipeService;
@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<Equipe> equipes = equipeService.findAll();
modelMap.addAttribute("equipes", equipes);
modelMap.addAttribute("joueur", new joueur());
modelMap.addAttribute("mode", "new");
return "formJoueur";
}
@RequestMapping("/saveJoueur")
public String saveJoueur(ModelMap modelMap,@Valid joueur joueur,
BindingResult bindingResult)
{
	List<Equipe> equipes = equipeService.findAll();
	modelMap.addAttribute("equipes", equipes);
System.out.println(joueur);
if (bindingResult.hasErrors()) return "formJoueur";
joueurService.saveJoueur(joueur);
return "redirect:/ListeJoueurs";
}



@RequestMapping("/ListeJoueurs")
public String listeJoueurs(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	List<Equipe> equipes = equipeService.findAll();
	modelMap.addAttribute("equipes", equipes);
Page<joueur> prods = joueurService.getAllJoueursParPage(page, size);
modelMap.addAttribute("joueurs", prods);
 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeJoueurs";
}


@RequestMapping("/supprimerJoueur")
public String supprimerJoueur(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
joueurService.deleteJoueurById(id);
Page<joueur> prods = joueurService.getAllJoueursParPage(page, 
size);
modelMap.addAttribute("joueurs", prods);
modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeJoueurs";
}


@RequestMapping("/modifierJoueur")
public String editerJoueur(@RequestParam("id") Long id,ModelMap modelMap)
{
joueur p= joueurService.getJoueur(id);
List<Equipe> equipes = equipeService.findAll();
equipes.remove(p.getEquipe());
modelMap.addAttribute("equipes", equipes);
modelMap.addAttribute("joueur", p);
modelMap.addAttribute("mode", "edit");
return "formJoueur";
}
@RequestMapping("/updateJoueur")
public String updateJoueur(@ModelAttribute("joueur") joueur joueur,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 joueur.setDateCreation(dateCreation);
	 
	 joueurService.updateJoueur(joueur);
	 List<joueur> prods = joueurService.getAllJoueurs();
	 modelMap.addAttribute("joueurs", prods);
	return "listeJoueurs";
	}



@RequestMapping("/search")
public String recherNom(@RequestParam("nom") String nom,
ModelMap modelMap)
{
	List<Equipe> equipes = equipeService.findAll();
	modelMap.addAttribute("equipes", equipes);
List<joueur> prods = joueurService.findByNomJoueur(nom);
modelMap.addAttribute("joueurs",prods);
modelMap.addAttribute("mode", "SearchNomP");
return "listeJoueurs";
}
@RequestMapping("/searchEquipe")
public String recherEquipe(@RequestParam("equipe") Long equipe,ModelMap modelMap)
{
Equipe equipes = new Equipe();
equipes.setIdEquipe(equipe);
List<Equipe> equipes2 = equipeService.findAll();
modelMap.addAttribute("equipes", equipes2);
List<joueur> prods = joueurService.findByEquipe(equipes);
modelMap.addAttribute("joueurs",prods);
modelMap.addAttribute("mode", "Searchequipe");
return "listeJoueurs";
}
}