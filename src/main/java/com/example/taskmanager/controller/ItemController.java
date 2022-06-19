package com.example.taskmanager.controller;

import com.example.taskmanager.model.Item;
import com.example.taskmanager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
// показать список задач
    @RequestMapping("/items")
    public String findAll(Model model, @Param("keyword") Boolean keyword)
    {
        List<Item> items = itemService.listAll(keyword);
        model.addAttribute("items", items);
        model.addAttribute("keyword", keyword);
        return "ItemsList";
    }
    //создание новой задачи
    @GetMapping("/CreateItem")
    public String createItemsForm(Item item) {
        return "CreateItem";
    }

    @PostMapping("/CreateItem")
    public String createItems(Item item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

    //редактирование
    @GetMapping("/UpdateItem/{id}")
    public String updateItemForm(@PathVariable("id") int id, Model model){
        Item item = itemService.findById(id);
        model.addAttribute("item", item);
        return "UpdateItem";
    }

    @PostMapping("/UpdateItem")
    public String updateItem(Item item){
        itemService.saveItem(item);
        return "redirect:/items";
    }
    //удаление
    @GetMapping("ItemDelete/{id}")
    public String deleteItems(@PathVariable("id") int id){
        itemService.deleteItem(id);
        return  "redirect:/items";
    }

   /* //checked
    @GetMapping("/create")
    public String createExample(Model model) {
        List<Item> items = itemService.li();
        model.addAttribute("items", items);
        return "create";
    }

    @PostMapping("/insert")
    public String insertExample(Model model, Item item) {
        model.addAttribute("item", item);
        return "redirect:/items";
    }*/

    /*//search
    @RequestMapping("/")
    public String add(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "ItemsList";
    }
    @PostMapping("/search")
    public String doSearchItems(Item item) {
        itemService.findAll().get(item);
        return "redirect:/items";
    }
*/
}
