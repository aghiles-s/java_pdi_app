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

import Sports.Musculation;
import Sports.User;

@Entity

@Table
public class ActiviteMusculation {
	@TableGenerator(name = "actMus", table = "ID_actMus", pkColumnName = "actMus_KEY", valueColumnName = "actMus_VALUE", pkColumnValue = "EMPactMus_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="actMus")
	private int idActmus;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	private User user;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Musculation.class)
	private Musculation musculation;
	
	public ActiviteMusculation() {
	}
	
	public ActiviteMusculation(User user, Musculation musculation) {
		this.user = user;
		this.musculation = musculation;
	}
	
	public int getId() {
		return this.idActmus;
	}
	public void setId(int id) {
		this.idActmus = id;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Musculation getMusculation() {
		return this.musculation;
	}
	public void setEquitation(Musculation musculation) {
		this.musculation = musculation;
	}
}
