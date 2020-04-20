package jenny.tutorial.unitesting.unittesting.data;

import jenny.tutorial.unitesting.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
