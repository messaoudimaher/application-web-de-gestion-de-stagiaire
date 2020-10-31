package doc.dao;

import doc.entities.Message;
import doc.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface TacheRepository extends JpaRepository<Tache, Long> {

    @Query(value = "SELECT * FROM Tache u WHERE u.email = ?1",
            nativeQuery = true)
    List<Tache> findAllByEmail(String email);
}
