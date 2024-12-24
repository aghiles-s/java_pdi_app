package Activité;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import Sports.Equitation;
import Sports.Jogging;
import Sports.User;

@Entity

@Table
public class ActiviteJogging {
	@TableGenerator(name = "actJOG", table = "ID_actJOG", pkColumnName = "actJOG_KEY", valueColumnName = "actJOG_VALUE", pkColumnValue = "EMPactJOG_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="actJOG")
	private int idActJog;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	private User user;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Jogging.class)
	private Jogging jogging;
	
	public ActiviteJogging() {
	}
	
	public ActiviteJogging(User user, Jogging jogging) {
		this.user = user;
		this.jogging = jogging;
	}
	
	public int getId() {
		return this.idActJog;
	}
	public void setId(int id) {
		this.idActJog = id;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Jogging getJogging() {
		return this.jogging;
	}
	public void setEquitation(Jogging jogging) {
		this.jogging = jogging;
	}
}
