package jenny.tutorial.unitesting.unittesting.business;

import jenny.tutorial.unitesting.unittesting.data.ItemRepository;
import jenny.tutorial.unitesting.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public List<Item> retrieveAllItems() {
        List<Item> items = repository.findAll();
        for (Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }

    public Item retrieveHardCodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
