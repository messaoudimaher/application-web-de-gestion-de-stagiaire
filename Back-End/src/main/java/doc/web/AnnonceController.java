package doc.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import doc.entities.Annonce;
import doc.entities.User;
import doc.service.AnnonceService;
import doc.service.IAnnonceService;
import lombok.Data;

@RestController
public class AnnonceController {
	@Autowired
	AnnonceService annonceService;
	
	@GetMapping("/annonces")
	public List<Annonce> getAll()
	{
		return annonceService.getAllAnnonces();
	}
	@PostMapping("/annonces")
	public Annonce register(@RequestBody Annonce annonceForm)
	{
		
		//System.err.println(userForm);
		return annonceService.saveAnnonce(new Annonce(null,
				annonceForm.getTitle(),
				annonceForm.getContenu(),
				annonceForm.getDate(),
				annonceForm.getUrgence()));
	}

	@DeleteMapping("/Delete_annance/{id}")
	public void deleteAnnance(@PathVariable long id) {
		 annonceService.deleteAnnance(id);

	}

}



