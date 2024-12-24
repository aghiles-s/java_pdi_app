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
public class Kayak {
	@TableGenerator(name = "EqGen2", table = "Eq_GEN2", pkColumnName = "Eq_KEY2", valueColumnName = "Eq_VALUE2", pkColumnValue = "EMPEq_ID2", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="EqGen2")
	private int IdKayak;
	private int duree;
	private double distance;
	private double vitesse;
	private double PoidBat;
	
	 
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Sport.class)
	private Sport sport;
	
	public Kayak() {
		
	} 
	public Kayak(int duree, double distance, double vitesse, double poidBat) {
		super();
		this.duree = duree;
		this.distance = distance;
		this.vitesse = vitesse;
		this.PoidBat = poidBat;
		
	}
	
	public Kayak(int duree, double distance, double vitesse,double poidBat, Sport sport) {
		super();
		this.duree = duree;
		this.distance = distance;
		this.vitesse = vitesse;
		this.PoidBat = poidBat;
		this.sport = sport;
	}
	


	public int getIdKayak() {
		return IdKayak;
	}


	public void setIdKayak(int idKayak) {
		IdKayak = idKayak;
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


	public double getPoidBat() {
		return PoidBat;
	}


	public void setPoidBat(double poidBat) {
		PoidBat = poidBat;
	}

	public Sport getSport() {
		return this.sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	@Override
	public String toString() {
		return "Kayak [IdKayak=" + IdKayak + ", duree=" + duree + ", distance=" + distance + ", vitesse=" + vitesse
				+ ", PoidBat=" + PoidBat +  "]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
