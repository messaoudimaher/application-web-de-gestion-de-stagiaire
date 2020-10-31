package doc.web;

import java.sql.Date;

import doc.dao.UserRepository;
import doc.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import doc.entities.User;
import doc.service.AccountService;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


import javax.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	AccountService accountService;
	@PostMapping("/register")
	public User register(@RequestBody UserForm userForm )
	{
		
		System.err.println(userForm);
		return accountService.saveUser(
				userForm.getFirstname(),
				userForm.getLastname(),
				userForm.getEmail(),
				userForm.getPassword(),
				userForm.getRole(),
				userForm.getActive(),
				userForm.getDateDebut(),
				userForm.getEtablissement(),
				userForm.getNiveau(),
				userForm.getTel(),
				userForm.getSpecialite(),
				userForm.getThemeDeRecherche()
				);
	}






	@PutMapping("/modifier_les_details_de_stagiaire/{id}")
	public ResponseEntity<User> updateStagiaire(@PathVariable(value = "id") Long id,
											   @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("stagiaire not found for this id :: " + id));

		user.setFirstname(userDetails.getFirstname());
		user.setLastname(userDetails.getLastname());
		user.setEmail(userDetails.getEmail());
		final User updatedStagiaire = userRepository.save(user);
		return ResponseEntity.ok(updatedStagiaire);
	}

	@DeleteMapping("/delete_stagiaire/{id}")
	public Map<String, Boolean> deleteStagiaire(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


	@GetMapping("/Liste_De_Stagiares")
	public List<User> getAll()
	{
		return accountService.getAllUsers();
	}
}
@Data
class UserForm{
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String role;
	private Boolean active;
	private Date dateDebut;
	private String etablissement;
	private String niveau;
	private String tel;
	private String specialite;
	private String themeDeRecherche;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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
}
