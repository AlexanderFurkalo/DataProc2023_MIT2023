package fit.mit.Lab6BackEnd.Controller;

import fit.mit.Lab6BackEnd.Entities.Boots;
import fit.mit.Lab6BackEnd.Repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("Lab6BackEnd/api/boots")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Boots postItems(@RequestBody Boots boots){
        return itemRepository.save(boots);
    }

    @GetMapping("/get")
    public List<Boots> getItems(){
        return itemRepository.findAll();
    }

    @PutMapping ("/update/{id}")
    public Boots putItem(@PathVariable(name = "id") int id, @RequestBody Boots UpdateThisItem){
        Boots updatedItem = itemRepository.findById(id)
                .orElseThrow(()->new ResourceAccessException("There is no item with id: " + id));
        updatedItem.setName(UpdateThisItem.getName());
        updatedItem.setSize(UpdateThisItem.getSize());
        updatedItem.setPrice(UpdateThisItem.getPrice());
        updatedItem.setImage(UpdateThisItem.getImage());
        return itemRepository.save(updatedItem);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable(name = "id") int id){
        itemRepository.deleteById(id);
    }
}
