package fit.mit.Lab6BackEnd.Repository;

import fit.mit.Lab6BackEnd.Entities.Boots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Boots, Integer>{
}
