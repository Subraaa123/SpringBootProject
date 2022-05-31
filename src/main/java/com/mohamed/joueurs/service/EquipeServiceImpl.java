package com.mohamed.joueurs.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mohamed.joueurs.entities.Equipe;
import com.mohamed.joueurs.entities.joueur;
import com.mohamed.joueurs.repos.EquipeRepository;


@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    public List <Equipe> findAll() {
        return equipeRepository.findAll();
    }

	@Override
	public Equipe saveEquipe(Equipe c) {
		return equipeRepository.save(c);
	}

	@Override
	public Equipe updateEquipe(Equipe c) {
		return equipeRepository.save(c);
	}

	@Override
	public void deleteEquipe(Equipe c) {
		equipeRepository.delete(c);
	}

	@Override
	public void deleteEquipeById(Long idEquipe) {
		equipeRepository.deleteById(idEquipe);
	}

	@Override
	public Equipe getEquipe(Long idEquipe) {
		return equipeRepository.findById(idEquipe).get();
	}
	@Override
	public Page<Equipe> getAllEquipeParPage(int page, int size) {
		return equipeRepository.findAll(PageRequest.of(page, size));

	}

   
}