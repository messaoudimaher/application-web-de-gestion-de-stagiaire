package doc.service;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import doc.entities.Message;
import doc.entities.Role;
import doc.entities.User;

public interface IAccountService {
	public User saveUser(
			String firstrname,
			String lastname,
			String email,
			String password,
			String role,
			boolean active,
			Date dateDebut,
			String etablissement,
			String niveau,
			String tel,
			String specialite,
			String themeDeRecherche);
	public Role save(Role role);
	public User loadUserByEmail(String email);
	public void addRoleToUser(String email,String rolename);

	public String delete(Long id);

	public List<User> getAllUsers();


}
