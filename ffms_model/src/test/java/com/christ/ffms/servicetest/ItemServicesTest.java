package com.christ.ffms.servicetest;

import com.christ.ffms.entity.Item;
import com.christ.ffms.service.ItemService;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring.xml")
@Data
public class ItemServicesTest {
    @Autowired
    ItemService itemService;
    @Test
    public void getAllTest(){
        List<Item> items=itemService.listItem();
        System.out.println(items );
    }
    @Test
    public void updateItemTest(){
        Item item=new Item();
        item.setId(1);
        item.setType(2);
        item.setName("salary");
        itemService.updateItem(item);
    }
}
