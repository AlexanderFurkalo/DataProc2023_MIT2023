package Lab5.sample.controller;

import Lab5.sample.Entities.Boots;
import Lab5.sample.Service.ItemServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemServices service;

    @GetMapping("/")
    public String HomePage(Model model){
        List<Boots> listItem = service.listAll();
        model.addAttribute("listItem",listItem);
        return "index";
    }
    @GetMapping("/add")
    public String AddItem(Model model){
        Boots boots = new Boots();
        model.addAttribute("boots", boots);
        return "AddNew";
    }
    @PostMapping("/add")
    public String saveItem(@ModelAttribute("boots") Boots boots) {
        service.save(boots);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public ModelAndView UpdateForm(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("UpdateOld");
        Boots boots = service.get(id);
        mav.addObject("boots", boots);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String DeleteItem(@PathVariable(name = "id") int id){
        service.delete(id);
        return "redirect:/";
    }
}


