package doc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import doc.dao.RoleRepository;
import doc.entities.Annonce;
import doc.entities.Message;
import doc.entities.Role;
import doc.service.AccountService;
import doc.service.AnnonceService;
import doc.service.MessageService;

@SpringBootApplication
public class GestoStagApplication implements CommandLineRunner{

	@Autowired
	AccountService accountService;
	@Autowired
	AnnonceService annonceService;
	@Autowired
	MessageService messageService;
	
	public static void main(String[] args) {
		SpringApplication.run(GestoStagApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("===============================START=======================================");
//		accountService.save(new Role(null,"ADMIN"));
//		accountService.save(new Role(null,"USER"));
//		accountService.saveUser("maher sadok","messaoudi","user@gmail.com", "1919","USER",true,new Date(),"Etablissement","2ème","56474022","Specialite","Theme de recherche");
//		accountService.saveUser("admin","admin","admin@gmail.com","12345","ADMIN",true,new Date(),"Etablissement","resp techni","75000000","Specialite","Theme de recherche");
//		accountService.addRoleToUser("admin@gmail.com","ADMIN");
//		accountService.addRoleToUser("user@gmail.com","USER");
//		for (int i = 1; i < 3; i++) {
//			accountService.saveUser("user"+i,"user"+i,"user"+i+"@gmail.com","1234","USER",true,new Date(),"Etablissement","niveau","123456789","Specialite","Theme de recherche");
//		}
//		for (int i = 1; i < 3; i++) {
//			messageService.saveMessage(new Message(null,"Nom "+i,"nom"+i+"@mail.com","Message de nom"+i));
//		}
	}

}
