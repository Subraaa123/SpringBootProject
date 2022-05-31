package com.mohamed.joueurs.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomProd", types = { joueur.class })
public interface JoueurProjection {
public String getNomJoueur();
}