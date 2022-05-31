package com.mohamed.joueurs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mohamed.joueurs.entities.Equipe;
import com.mohamed.joueurs.entities.joueur;
import com.mohamed.joueurs.repos.JoueurRepository;
@Service
public class JoueurServiceImpl implements JoueurService {
@Autowired
JoueurRepository joueurRepository;
@Override
public joueur saveJoueur(joueur p) {
	return joueurRepository.save(p);
	}
	@Override
	public joueur updateJoueur(joueur p) {
	return joueurRepository.save(p);
	}
	@Override
	public void deleteJoueur(joueur p) {
	joueurRepository.delete(p);
	}
	 @Override
	public void deleteJoueurById(Long id) {
	joueurRepository.deleteById(id);
	}
	@Override
	public joueur getJoueur(Long id) {
	return joueurRepository.findById(id).get();
	}
	@Override
	public List<joueur> getAllJoueurs() {
	return joueurRepository.findAll();
	}
	@Override
	public Page<joueur> getAllJoueursParPage(int page, int size) {
		return joueurRepository.findAll(PageRequest.of(page, size));

	}
	@Override
	public List<joueur> findByNomJoueur(String nom) {
	return joueurRepository.findByNomJoueur(nom);
	}
	@Override
	public List<joueur> findByNomJoueurContains(String nom) {
	return joueurRepository.findByNomJoueurContains(nom);
	}
	@Override
	public List<joueur> findByNomPrix(String nom, Double prix) {
		return joueurRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<joueur> findByEquipe(Equipe equipe) {
	return joueurRepository.findByEquipe(equipe);
	}
	@Override
	public List<joueur> findByEquipeIdEquipe(Long id) {
	return joueurRepository.findByEquipeIdEquipe(id);
	}
	@Override
	public List<joueur> findByOrderByNomJoueurAsc() {
	return joueurRepository.findByOrderByNomJoueurAsc();
	}
	@Override
	public List<joueur> trierJoueursNomsPrix() {
	return joueurRepository.trierJoueursNomsPrix();
	}
}