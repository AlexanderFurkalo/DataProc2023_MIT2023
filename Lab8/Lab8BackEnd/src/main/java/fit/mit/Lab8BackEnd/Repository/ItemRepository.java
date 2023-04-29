package fit.mit.Lab8BackEnd.Repository;

import fit.mit.Lab8BackEnd.Entities.Boots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "boots", path = "boots")
public interface ItemRepository extends JpaRepository<Boots, Integer>{
}
