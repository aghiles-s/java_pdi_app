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
public class Equitation {
	@TableGenerator(name = "EqGen", table = "Eq_GEN", pkColumnName = "Eq_KEY", valueColumnName = "Eq_VALUE", pkColumnValue = "EMPEq_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="EqGen")
	private int idEq;
	private int duree;
	private double distance;
	private double vitesse;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Sport.class)
	private Sport sport;
	 
	public Equitation() {
	 
	}
	public Equitation(int duree, double distance, double vitesse) {
		super();
		this.duree = duree;
		this.distance = distance; 
		this.vitesse = vitesse;
	}
	public Equitation(int duree, double distance, double vitesse, Sport sport) {
		super();
		this.duree = duree;
		this.distance = distance;
		this.vitesse = vitesse;
		this.sport = sport;
	}
	public int getIdEq() {
		return idEq;
	}
	public void setIdEq(int idEq) {
		this.idEq = idEq;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getVitesse() {
		return vitesse;
	}
	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}
	public Sport getSport() {
		return this.sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	@Override
	public String toString() {
		return "Equitation [idEq=" + getIdEq() + ", duree=" + getDuree() + ", distance=" + getDistance() + ", vitesse=" + getVitesse()
				+ "]";
	}
	
}
