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
import Sports.Tir_a_larc;
import Sports.User;

@Entity

@Table
public class ActiviteTir_a_larc {
	@TableGenerator(name = "actTir", table = "ID_actTir", pkColumnName = "actTir_KEY", valueColumnName = "actTir_VALUE", pkColumnValue = "EMPactTir_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="actTir")
	private int idActTir;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	private User user;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Tir_a_larc.class)
	private Tir_a_larc  tir_a_larc;
	
	public ActiviteTir_a_larc() {
	}
	
	public ActiviteTir_a_larc(User user, Tir_a_larc  tir_a_larc ) {
		this.user = user;
		this.tir_a_larc  = tir_a_larc ;
	}
	
	public int getId() {
		return this.idActTir;
	}
	public void setId(int id) {
		this.idActTir = id;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Tir_a_larc  getTir_a_larc () {
		return this.tir_a_larc;
	}
	public void setEquitation(Tir_a_larc  tir_a_larc ) {
		this.tir_a_larc = tir_a_larc;
	}
}

