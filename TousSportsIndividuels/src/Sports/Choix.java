package Sports;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity

public class Choix {
	@TableGenerator(name = "choix", table = "ID_choix", pkColumnName = "Choix_KEY", valueColumnName = "choix_VALUE", pkColumnValue = "EMPchoix_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="choix")
	private int id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	private User user;
	private Integer IdUser;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Sport.class)
	private Sport sport;
	
	public Choix() {
	}
	
	public Choix(User user, Sport sport) {
		this.user = user;
		this.sport = sport;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getIdUser() {
		return IdUser;
	}
	public void setIdUser(Integer IdUser) {
		 this.IdUser = IdUser;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Sport getSport() {
		return this.sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
}
