package com.christ.ffms.control;

import com.christ.ffms.entity.Item;
import com.christ.ffms.service.ItemService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.stream.IIOByteBuffer;
import java.util.Arrays;
import java.util.List;

@Data
@Controller
public class ItemController {
    @Autowired
    ItemService itemService;
    @RequestMapping("toItemList")
    public ModelAndView toHome(){
        List<Item> items=itemService.listItem();
        ModelAndView modelAndView=new ModelAndView("/item/list","items",items);
        return modelAndView;
    }
    @RequestMapping("toPItemEdit")
    public ModelAndView toPItemEdit(Integer id){
        ModelAndView modelAndView=new ModelAndView("/item/edit","item",itemService.getOneItem(id));
        return modelAndView;
    }
    @RequestMapping("toItemAdd")
    public ModelAndView toItemAdd(){
        List<Item> items=itemService.listPItem(1);
        ModelAndView modelAndView=new ModelAndView("/item/add","items",items);
        return modelAndView;
    }
    @RequestMapping("toCItemEdit")
    public ModelAndView toCItemEdit(Integer id){
        ModelAndView modelAndView=new ModelAndView("/item/cedit","item",itemService.getOneItem(id));
        return modelAndView;
    }
    @RequestMapping("listCItem")
    public ModelAndView listCItem(Integer id){
        ModelAndView modelAndView=new ModelAndView("/item/clist","items",itemService.getOneItem(id));
        return modelAndView;
    }
    @RequestMapping("editPItem")
    @ResponseBody
    public String editPItem(Item item){
        itemService.updateItem(item);
        return "toItemList";
    }
    @RequestMapping("editCItem")
    @ResponseBody
    public String editCItem(Item item){
        itemService.updateItem(item);
        return "listCItem";
    }
    @RequestMapping("toCItemDetail")
    @ResponseBody
    public ModelAndView toCItemDetail(Integer id){
        ModelAndView modelAndView=new ModelAndView("/item/detail","item",itemService.getOneItem(id));
        return modelAndView;
    }
    @RequestMapping("itemAdd")
    @ResponseBody
    public String itemAdd(Item item){
        System.out.println(item);
        itemService.saveItem(item);
        return "toItemList";
    }
    @RequestMapping("deleteItem")
    public String deleteItem(Item item){
        itemService.deleteItem(item);
        return "redirect:/toItemList";
    }
    @RequestMapping("deleteCItem")
    @ResponseBody
    public String deleteCItem(Item item){
        itemService.deleteItem(item);
        return "toItemList";
    }
    @RequestMapping("deletePItems")
    @ResponseBody
    public String deletePItems(String[] arr){
        itemService.deletePItems(arr);
        return "toItemList";
    }
    @RequestMapping("deleteCItems")
    @ResponseBody
    public String deleteCItems(String[] arr){
        itemService.deleteCItems(arr);
        return "toItemList";
    }
    @RequestMapping("pItem")
    @ResponseBody
    public List<Item> pItem(Integer id){
        return itemService.listPItem(id);
    }
}
