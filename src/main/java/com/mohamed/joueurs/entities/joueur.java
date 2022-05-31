package com.mohamed.joueurs.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class joueur {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idJoueur;

@NotNull
@Size (min = 4,max = 15)
private String nomJoueur;

public Equipe getEquipe() {
	return equipe;
}
public void setEquipe(Equipe equipe) {
	this.equipe = equipe;
}
@Min(value = 10)
@Max(value = 10000)
private Double prixJoueur;

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateCreation;

@ManyToOne
private Equipe equipe;
public joueur() {
super();
}
public joueur(String nomJoueur, Double prixJoueur, Date dateCreation) {
super();
this.nomJoueur = nomJoueur;
this.prixJoueur = prixJoueur;
this.dateCreation = dateCreation;
}
public Long getIdJoueur() {
return idJoueur;
}
public void setIdJoueur(Long idJoueur) {
this.idJoueur = idJoueur;
}
public String getNomJoueur() {
return nomJoueur;
}
public void setNomJoueur(String nomJoueur) {
this.nomJoueur = nomJoueur;
}
public Double getPrixJoueur() {
return prixJoueur;
}
public void setPrixJoueur(Double prixJoueur) {
this.prixJoueur = prixJoueur;
}
public Date getDateCreation() {
return dateCreation;
}
public void setDateCreation(Date dateCreation) {
this.dateCreation = dateCreation;
}
@Override
public String toString() {
	return "joueur [idJoueur=" + idJoueur + ", nomJoueur=" + nomJoueur + ", prixJoueur=" + prixJoueur
			+ ", dateCreation=" + dateCreation + ", equipe=" + equipe + "]";
}
}
