package com.christ.ffms.dao;

import com.christ.ffms.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao {
    /*void saveItem(Item item);
    void updateItem(Item item);
    void deleteItem(int id);
    void deleteItems(String [] ids);*/
    Item getItemByPK(int id);
    /*List<Item> getAllItem();
    List<Item> getParentItemByType(int type);
    List<Item> getChileItemByParentId(int id);*/
}
