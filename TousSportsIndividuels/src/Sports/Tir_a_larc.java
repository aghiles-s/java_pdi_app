package Sports;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity

@Table
public class Tir_a_larc {
	@TableGenerator(name = "EqGen1", table = "Eq_GEN1", pkColumnName = "Eq_KEY1", valueColumnName = "Eq_VALUE1", pkColumnValue = "EMPEq_ID1", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="EqGen1")
	private int IdTir_a_larc ;
	private int duree;
	private int NbFleches;
	private double distance;
	private int Score;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Sport.class)
	private Sport sport;
	 
	
	public Tir_a_larc() {
	 
	}
	public Tir_a_larc(int duree, int nbFleches, double distance, int score) {
		super();
		this.duree = duree;
		this.NbFleches = nbFleches;
		this.distance = distance;
		this.Score = score;
	}
	public Tir_a_larc(int duree, int nbFleches, double distance, int score,Sport sport) {
		super();
		this.duree = duree;
		this.NbFleches = nbFleches;
		this.distance = distance;
		this.Score = score;
		this.sport = sport;
	}


	public int getIdTir_a_larc() {
		return IdTir_a_larc;
	}


	public void setIdTir_a_larc(int idTir_a_larc) {
		IdTir_a_larc = idTir_a_larc;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public int getNbFleches() {
		return NbFleches;
	}


	public void setNbFleches(int nbFleches) {
		NbFleches = nbFleches;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public int getScore() {
		return Score;
	}


	public void setScore(int score) {
		Score = score;
	}
	
	public Sport getSport() {
		return this.sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	

	@Override
	public String toString() {
		return "Tir_a_larc [IdTir_a_larc=" + IdTir_a_larc + ", duree=" + duree + ", NbFleches=" + NbFleches
				+ ", distance=" + distance + ", Score=" + Score + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
