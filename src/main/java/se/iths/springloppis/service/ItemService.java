package se.iths.springloppis.service;

import org.springframework.stereotype.Service;
import se.iths.springloppis.entity.ItemEntity;
import se.iths.springloppis.repository.ItemRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemEntity createItem(ItemEntity item) {
        return itemRepository.save(item);
    }

    public Optional<ItemEntity> findItemById(Long id) {
        return Optional.ofNullable(itemRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public void deleteItem(Long id) {
        ItemEntity foundItem = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        itemRepository.deleteById(foundItem.getId());
    }

    public Iterable<ItemEntity> findAllItems() {
        return itemRepository.findAll();
    }

}
