package com.mohamed.joueurs.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohamed.joueurs.entities.joueur;
import com.mohamed.joueurs.service.JoueurService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class JoueurRESTController {
@Autowired
JoueurService joueurService;
@RequestMapping(method = RequestMethod.GET)
public List<joueur> getAllJoueurs() {
return joueurService.getAllJoueurs();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public joueur getJoueurById(@PathVariable("id") Long id) {
return joueurService.getJoueur(id);
 }
@RequestMapping(method = RequestMethod.POST)
public joueur createJoueur(@RequestBody joueur joueur) {
return joueurService.saveJoueur(joueur);
}
@RequestMapping(method = RequestMethod.PUT)
public joueur updateJoueur(@RequestBody joueur joueur) {
return joueurService.updateJoueur(joueur);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteJoueur(@PathVariable("id") Long id)
{
joueurService.deleteJoueurById(id);
}
@RequestMapping(value="/prodscat/{idEquipe}",method = RequestMethod.GET)
public List<joueur> getJoueursByEquipeId(@PathVariable("idEquipe") Long idEquipe) {
return joueurService.findByEquipeIdEquipe(idEquipe);
}
}
