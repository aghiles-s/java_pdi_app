package Sports;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity

@Table
public class Sport {
	@TableGenerator(name = "sport", table = "ID_sport", pkColumnName = "Sport_KEY", valueColumnName = "sport_VALUE", pkColumnValue = "EMPsport_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="sport")
	private int idSport;
	private String nomSport;
	
	
	public Sport() {
		
	}
	
	public Sport(String nomSport) {
		super();
		this.nomSport = nomSport;
	}
	
	public int getIdSport() {
		return idSport;
	}

	public String getNomSport() {
		return nomSport;
	}
}
