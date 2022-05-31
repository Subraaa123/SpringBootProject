package com.mohamed.joueurs.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mohamed.joueurs.entities.Equipe;
import com.mohamed.joueurs.entities.joueur;
@Repository
public interface JoueurRepository extends JpaRepository<joueur, Long> {
	List<joueur> findByNomJoueur(String nom);
	 List<joueur> findByNomJoueurContains(String nom);
	 @Query("select p from joueur p where p.nomJoueur like %:nom and p.prixJoueur > :prix")
	 List<joueur> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select p from joueur p where p.equipe = ?1")
	 List<joueur> findByEquipe (Equipe equipe);
	 List<joueur> findByEquipeIdEquipe(Long id);
	 List<joueur> findByOrderByNomJoueurAsc();
	 @Query("select p from joueur p order by p.nomJoueur ASC, p.prixJoueur DESC")
	 List<joueur> trierJoueursNomsPrix();
}