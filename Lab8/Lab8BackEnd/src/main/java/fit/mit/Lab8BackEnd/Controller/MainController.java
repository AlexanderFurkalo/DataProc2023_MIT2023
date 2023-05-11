package fit.mit.Lab8BackEnd.Controller;

import fit.mit.Lab8BackEnd.Entities.Boots;
import fit.mit.Lab8BackEnd.Repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import java.util.List;

@RestController
@RequestMapping("/api/boots")
@Slf4j
@CrossOrigin(origins = "*")
public class MainController {
    @Autowired
    ItemRepository itemRepository;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Boots postItems(@RequestBody Boots boots){
        log.info("[CONTROLLER] | POST initiated");
        itemRepository.save(boots);
        log.info("[CONTROLLER] After method POST, boots with name {} were added", boots.getName());
        return boots;
    }

    @GetMapping("/get")
    public List<Boots> getItems(){
        List<Boots> list;
        log.info("[CONTROLLER] | GET initiated");
        list = itemRepository.findAll();
        log.info("[CONTROLLER] After method GET, {} boots were found", list.size());
        return list;
    }

    @PutMapping ("/update/{id}")
    public Boots putItem(@PathVariable(name = "id") int id, @RequestBody Boots UpdateThisItem){
        log.info("[CONTROLLER] | PUT initiated");
        Boots updatedItem = itemRepository.findById(id)
                .orElseThrow(()->{
                    log.error("[CONTROLLER] | PUT method failed: found nothing with such id: " + id);
                    return new ResourceAccessException("There is no item with id: " + id);
                });
        updatedItem.setName(UpdateThisItem.getName());
        updatedItem.setSize(UpdateThisItem.getSize());
        updatedItem.setPrice(UpdateThisItem.getPrice());
        updatedItem.setImage(UpdateThisItem.getImage());
        itemRepository.save(updatedItem);
        log.info("[CONTROLLER] After method PUT, boots with {} id were successfully changed", id);
        return updatedItem;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable(name = "id") int id){
        log.info("[CONTROLLER] | DELETE initiated");
        Boots ItemDeletion = itemRepository.findById(id)
                .orElseThrow(()->{
                    log.error("[CONTROLLER] | DELETE method failed: found nothing with such id:" + id);
                    return new ResourceAccessException("There is no item with id: " + id);
                });
        itemRepository.deleteById(id);
        log.info("[CONTROLLER] After DELETE method, boots with {} id were successfully deleted", id);
    }
}
