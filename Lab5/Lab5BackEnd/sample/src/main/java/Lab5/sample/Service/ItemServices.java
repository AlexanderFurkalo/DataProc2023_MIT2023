package Lab5.sample.Service;

import Lab5.sample.Entities.Boots;
import Lab5.sample.Repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServices {
    @Autowired
    private ItemRepository repo;

    public List<Boots> listAll(){
        return repo.findAll();
    }

    public void save(Boots boots){
        repo.save(boots);
    }

    public Boots get(int id){
        return repo.findById(id).get();
    }

    public void delete(int id){
        repo.deleteById(id);
    }
}
