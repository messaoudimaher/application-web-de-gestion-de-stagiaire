package doc.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import lombok.ToString;

@Entity


@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	private boolean activated;
	private Date dateDebut;
	private String etablissement;
	private String niveau;
	private String tel;
	private String specialite;
	private String themeDeRecherche;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles=new ArrayList<Role>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getThemeDeRecherche() {
		return themeDeRecherche;
	}

	public void setThemeDeRecherche(String themeDeRecherche) {
		this.themeDeRecherche = themeDeRecherche;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public User(Long id, String email, String firstname, String lastname, String password, boolean activated, Date dateDebut, String etablissement, String niveau, String tel, String specialite, String themeDeRecherche, Collection<Role> roles) {
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.activated = activated;
		this.dateDebut = dateDebut;
		this.etablissement = etablissement;
		this.niveau = niveau;
		this.tel = tel;
		this.specialite = specialite;
		this.themeDeRecherche = themeDeRecherche;
		this.roles = roles;
	}

	public User() {
	}
}
