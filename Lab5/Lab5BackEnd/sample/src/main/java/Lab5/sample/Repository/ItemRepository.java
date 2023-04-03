package Lab5.sample.Repository;

import Lab5.sample.Entities.Boots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Boots, Integer> {
}
