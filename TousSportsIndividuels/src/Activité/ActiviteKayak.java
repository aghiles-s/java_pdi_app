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


import Sports.Kayak;
import Sports.User;

@Entity

@Table
public class ActiviteKayak {
	@TableGenerator(name = "actkay", table = "ID_actkay", pkColumnName = "actkay_KEY", valueColumnName = "actkay_VALUE", pkColumnValue = "EMPactkay_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="actkay")
	private int idActkay;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	private User user;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Kayak.class)
	private  Kayak kayak;
	
	public ActiviteKayak() {
	}
	
	public ActiviteKayak(User user, Kayak kayak) {
		this.user = user;
		this.kayak = kayak;
	}
	
	public int getId() {
		return this.idActkay;
	}
	public void setId(int id) {
		this.idActkay = id;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Kayak getKayak() {
		return this.kayak;
	}
	public void setEquitation( Kayak kayak) {
		this.kayak = kayak;
	}
}
