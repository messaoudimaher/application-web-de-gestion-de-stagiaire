package doc.service;

import doc.dao.TacheRepository;
import doc.entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheService {

    @Autowired
    TacheRepository tacheRepository;

    public Tache saveTache(Tache tache)
    {
        return this.tacheRepository.save(tache);
    }

    public List<Tache> findAllByEmail (String email) {
        return this.tacheRepository.findAllByEmail(email);
    }
}
