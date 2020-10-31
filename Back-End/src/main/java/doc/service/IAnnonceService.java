package doc.service;

import java.util.List;

import doc.entities.Annonce;
import doc.entities.User;

public interface IAnnonceService {

	public List<Annonce> getAllAnnonces();
	public Annonce saveAnnonce(Annonce annonce);

	public void deleteAnnance(Long id );
}
