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

import Sports.User;
import Sports.Yoga;

@Entity

@Table
public class ActiviteYoga {
	@TableGenerator(name = "actYoga", table = "ID_actYoga", pkColumnName = "actYoga_KEY", valueColumnName = "actYoga_VALUE", pkColumnValue = "EMPactYoga_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="actYoga")
	private int idActYoga;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	private User user;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Yoga.class)
	private Yoga yoga;
	
	public ActiviteYoga() {
	}
	
	public ActiviteYoga(User user, Yoga yoga) {
		this.user = user;
		this.yoga = yoga;
	}
	
	public int getId() {
		return this.idActYoga;
	}
	public void setId(int id) {
		this.idActYoga = id;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Yoga getYoga() {
		return this.yoga;
	}
	public void setYoga(Yoga yoga) {
		this.yoga = yoga;
	}
	
}
