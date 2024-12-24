package Sports;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;


@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	
	@TableGenerator(name = "empGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "EMP_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="empGen")
	
	private int IdUser;
	private String NomUser;
	private String PrenomUser;
	private String Pseudo;
	private int Age;
	private String Sexe;
	private Double Poids;
	private Double Taille;
	private String Email;
	@Column(name = "Tel", nullable = true)
	private String Tel;
	private String Mdps;
	
	
	public User(){	
	}
    

    public User( String Nom, String Prenom, String Pseudo,int Age,String Sexe,Double Poids,
    		Double Taille, String Email,String Tel,String Mdps){
    	
    	this.NomUser=Nom;
    	this.PrenomUser=Prenom;
    	this.Age= Age;
    	this.Pseudo= Pseudo;
    	this.Sexe= Sexe;
    	this.Poids= Poids;
    	this.Taille=Taille;
    	this.Email=Email;
    	this.Tel=Tel;
    	this.Mdps =Mdps;
    	
    	}
    public User(String Nom, String Prenom, String Pseudo, int Age, String Sexe,
			String Email, String Mdps) {
    	this.NomUser=Nom;
    	this.PrenomUser=Prenom;
    	this.Age= Age;
    	this.Pseudo= Pseudo;
    	this.Sexe= Sexe;
    	this.Email=Email;
    	this.Mdps =Mdps;
	}
    public User( String Nom, String Prenom, String Pseudo,int Age,String Sexe,Double Poids,
    		Double Taille, String Email,String Mdps){
    	
    	this.NomUser=Nom;
    	this.PrenomUser=Prenom;
    	this.Age= Age;
    	this.Pseudo= Pseudo;
    	this.Sexe= Sexe;
    	this.Poids= Poids;
    	this.Taille=Taille;
    	this.Email=Email;
    	this.Mdps =Mdps;
    	
    	}
    public User( String Nom, String Prenom, String Pseudo,int Age,String Sexe,Double Poids,
    		Double Taille, String Email){
    	
    	this.NomUser=Nom;
    	this.PrenomUser=Prenom;
    	this.Age= Age;
    	this.Pseudo= Pseudo;
    	this.Sexe= Sexe;
    	this.Poids= Poids;
    	this.Taille=Taille;
    	this.Email=Email;
    	}
    


	public int getIdUser() {
		return IdUser;
	}

	public void setIdUser(int idUser) {
		this.IdUser = idUser;
	}

	public String getNomUser() {
		return NomUser;
	}

	public void setNomUser(String nomUser) {
		this.NomUser = nomUser;
	}

	public String getPrenomUser() {
		return PrenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.PrenomUser = prenomUser;
	}

	public String getPseudo() {
		return Pseudo;
	}

	public void setPseudo(String pseudo) {
		this.Pseudo = pseudo;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		this.Age = age;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		this.Sexe = sexe;
	}

	public Double getPoids() {
		return Poids;
	}

	public void setPoids(Double poids) {
		this.Poids = poids;
	}

	public Double getTaille() {
		return Taille;
	}

	public void setTaille(Double taille) {
		this.Taille = taille;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		this.Tel = tel;
	}

	public String getMdps() {
		return Mdps;
	}

	public void setMdps(String mdps) {
		this.Mdps = mdps;
	}

	@Override
	public String toString() {
				return "User [IdUser=" + IdUser + ", NomUser=" + NomUser + ", PrenomUser=" + PrenomUser + ", Pseudo="
						+ Pseudo + ", Age=" + Age + ", Sexe=" + Sexe + ", Poids=" + Poids + ", Taille=" + Taille
						+ ", Email=" + Email + ", Tel=" + Tel + ", Mdps=" + Mdps + "]";
			}
	  
	
	

	public static void main(String[] args) {
		  
	  }

}
