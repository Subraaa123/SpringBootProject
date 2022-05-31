package com.mohamed.joueurs.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
public class Equipe {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idEquipe;
private String nomEquipe;
private String paysOrigineEquipe;
private String fondation;
@JsonIgnore
@OneToMany(mappedBy = "equipe")
private List<joueur> joueurs;
public Equipe() {}
public Equipe(String nomEquipe, String paysOrigineEquipe,String fondation, List<joueur> joueurs) 
{
super();
this.nomEquipe = nomEquipe;
this.paysOrigineEquipe = paysOrigineEquipe;
this.fondation=fondation;
this.joueurs = joueurs;
}
public Long getIdEquipe() {
return idEquipe;
}
public void setIdEquipe(Long idEquipe) {
this.idEquipe = idEquipe;
}
public String getNomEquipe() {
return nomEquipe;
}
public void setNomEquipe(String nomEquipe) {
this.nomEquipe = nomEquipe;
}
public String getPaysOrigineEquipe() {
return paysOrigineEquipe;
}
public void setPaysOrigineEquipe(String paysOrigineEquipe) {
this.paysOrigineEquipe = paysOrigineEquipe;
}
public String getFondation() {
return fondation;
}
public void setFondation(String fondation) {
this.fondation = fondation;
}
public List<joueur> getJoueurs() {
return joueurs;
}
public void setJoueurs(List<joueur> joueurs) {
this.joueurs = joueurs;
}
@Override
public String toString() {
	return "Equipe [idEquipe=" + idEquipe + ", nomEquipe=" + nomEquipe + ", paysOrigineEquipe=" + paysOrigineEquipe + ",Fondation=" + fondation + "]";
}
}