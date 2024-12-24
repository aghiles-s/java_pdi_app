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
public class Musculation {
	@TableGenerator(name = "empGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "MUSC_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="empGen")
	private int idMusc;
	private int duree;
	private double poidsSouleve;
	private int repetition;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Sport.class)
	private Sport sport;
	
	
	
	public Musculation() {
		
	} 
	
	public Musculation(int duree, double poidsSouleve, int repetition) {
		super();
		this.duree = duree;
		this.poidsSouleve = poidsSouleve;
		this.repetition = repetition;
		
	}
	
	public Musculation(int duree, double poidsSouleve, int repetition,Sport sport) {
		super();
		this.duree = duree;
		this.poidsSouleve = poidsSouleve;
		this.repetition = repetition;
		this.sport = sport;
	}


	public int getIdMusc() {
		return idMusc;
	}


	public void setIdMusc(int idMusc) {
		this.idMusc = idMusc;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public double getPoidsSouleve() {
		return poidsSouleve;
	}


	public void setPoidsSouleve(double poidsSouleve) {
		this.poidsSouleve = poidsSouleve;
	}


	public int getRepetition() {
		return repetition;
	}


	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}


	public Sport getSport() {
		return this.sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}


	@Override
	public String toString() {
		return "Musculation [idMusc=" + idMusc + ", duree=" + duree + ", poidsSouleve="
				+ poidsSouleve + ", repetition=" + repetition + "]";
	}
	
	
	
}
