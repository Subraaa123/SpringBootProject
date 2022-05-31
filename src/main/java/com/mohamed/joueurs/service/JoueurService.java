package com.mohamed.joueurs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mohamed.joueurs.entities.Equipe;
import com.mohamed.joueurs.entities.joueur;
public interface JoueurService {
joueur saveJoueur(joueur p);
joueur updateJoueur(joueur p);
void deleteJoueur(joueur p);
 void deleteJoueurById(Long id);
joueur getJoueur(Long id);
List<joueur> getAllJoueurs();
Page<joueur> getAllJoueursParPage(int page, int size);
List<joueur> findByNomJoueur(String nom);
List<joueur> findByNomJoueurContains(String nom);
List<joueur> findByNomPrix (String nom, Double prix);
List<joueur> findByEquipe (Equipe equipe);
List<joueur> findByEquipeIdEquipe(Long id);
List<joueur> findByOrderByNomJoueurAsc();
List<joueur> trierJoueursNomsPrix();
}