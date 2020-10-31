package doc.web;

import doc.entities.Message;
import doc.entities.Tache;
import doc.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class TacheController {

    @Autowired
    TacheService tacheService;


    @GetMapping("/taches/{email}")
    public List<Tache> getAll(@PathVariable(value = "email") String email)
    {
        return tacheService.findAllByEmail(email);
    }
    @PostMapping("/tache")
    public Tache saveTache(@RequestBody Tache tacheForm)
    {


        return tacheService.saveTache(new Tache(null,tacheForm.getEmail(),tacheForm.getDate(),tacheForm.getDescription(),tacheForm.getTitle()));
    }
}
