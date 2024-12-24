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
public class Yoga { 
	@TableGenerator(name = "yoga", table = "ID_yoga", pkColumnName = "Yoga_KEY", valueColumnName = "yoga_VALUE", pkColumnValue = "EMPyoga_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="yoga")
	private int idYoga;
	private int duree;
	private int repetition;
	private double etatEsprit;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Sport.class)
	private Sport sport;
	
	public Yoga() {
	} 
	
	public Yoga(int duree, int repetition, double etatEsprit) {
		super();
		this.duree = duree; 
		this.repetition = repetition;
		this.etatEsprit = etatEsprit;
	}
	
	public Yoga(int duree, int repetition, double etatEsprit, Sport sport) {
		super();
		this.duree = duree; 
		this.repetition = repetition;
		this.etatEsprit = etatEsprit;
		this.sport = sport;
	}
	
	public int getidYoga() {
		return idYoga;
	}
	public void setidYoga(int idYoga) {
		this.idYoga = idYoga;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getRepetition() {
		return repetition;
	}
	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}
	public double getEtatEsprit() {
		return etatEsprit;
	}
	public void setEtatEsprit(double etatEsprit) {
		this.etatEsprit = etatEsprit;
	}
	public Sport getSport() {
		return this.sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	@Override
	public String toString() {
		return "Yoga [idYoga=" + idYoga + ", duree=" + duree
				+ ", repetition=" + repetition + ", etatEsprit=" + etatEsprit + "]";
	}
	
	
	
}
