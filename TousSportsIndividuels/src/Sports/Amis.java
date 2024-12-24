package Sports;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Amis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private User utilisateur;

	@ManyToOne
	private User ami;

	private Integer idUtilisateur;

	private Integer idAmi;

	public Amis() {
	}

	public Amis(User utilisateur, User ami) {
	    this.utilisateur = utilisateur;
	    this.ami = ami;
	    this.idUtilisateur = utilisateur.getIdUser();
	    this.idAmi = ami.getIdUser();
	}

	// Getters and setters
	public User getUtilisateur() {
	    return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
	    this.utilisateur = utilisateur;
	}

	public User getAmi() {
	    return ami;
	}

	public void setAmi(User ami) {
	    this.ami = ami;
	}

	public Integer getIdUtilisateur() {
	    return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
	    this.idUtilisateur = idUtilisateur;
	}

	public Integer getIdAmi() {
	    return idAmi;
	}

	public void setIdAmi(Integer idAmi) {
	    this.idAmi = idAmi;
	}
	}