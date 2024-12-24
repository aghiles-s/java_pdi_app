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
import Sports.User;

@Entity

@Table
public class ActiviteEquitation {
	@TableGenerator(name = "actEq", table = "ID_actEq", pkColumnName = "actEq_KEY", valueColumnName = "actEq_VALUE", pkColumnValue = "EMPactEq_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="actEq")
	private int idActEq;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	private User user;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Equitation.class)
	private Equitation equitation;
	
	public ActiviteEquitation() {
	}
	
	public ActiviteEquitation(User user, Equitation equitation) {
		this.user = user;
		this.equitation = equitation;
	}
	
	public int getId() {
		return this.idActEq;
	}
	public void setId(int id) {
		this.idActEq = id;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Equitation getEquitation() {
		return this.equitation;
	}
	public void setEquitation(Equitation equitation) {
		this.equitation = equitation;
	}
}
