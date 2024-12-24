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
public class Jogging {
	
	
		@TableGenerator(name = "jogging", table = "ID_joggin", pkColumnName = "jogging_KEY", valueColumnName = "jogging_VALUE", pkColumnValue = "jogging_ID", allocationSize = 1)
		@Id
		@GeneratedValue(strategy=GenerationType.TABLE, generator="jogging")
		private int idJog;
		private int duree;
		private double distance;
		private double vitesse;
		private int Frequence;
		 
		@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Sport.class)
		private Sport sport;
		
		public Jogging() {
			
		} 
		 
		public Jogging(int duree, double distance, double vitesse,int Frequence) {
			super();
			this.duree = duree;
			this.distance = distance;
			this.vitesse = vitesse;
			this.Frequence= Frequence;	
		}
		
		public Jogging(int duree, double distance, double vitesse,int Frequence, Sport sport) {
			super();
			this.duree = duree;
			this.distance = distance;
			this.vitesse = vitesse;
			this.Frequence= Frequence;
			this.sport = sport;
		}

	public int getIdJog() {
			return idJog;
		}
		public void setIdJog(int idJog) {
			this.idJog = idJog;
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

		public int getFrequence() {
			return Frequence;
		}
		public void setFrequence(int frequence) {
			Frequence = frequence;
		}
		
		public Sport getSport() {
			return this.sport;
		}
		public void setSport(Sport sport) {
			this.sport = sport;
		}


	@Override
		public String toString() {
			return "Jogging [idJog=" + idJog + ", duree=" + duree + ", distance=" + distance + ", vitesse=" + vitesse
					+ ", Frequence=" + Frequence + "]";
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
