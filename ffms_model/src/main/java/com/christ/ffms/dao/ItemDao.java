package com.christ.ffms.dao;

import com.christ.ffms.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao {
    public void saveCItem(Item item);
    public void savePItem(Item item);
    public void deletePItem(Item item);
    public void deletePItems(String[] arr);
    public void deleteCItem(Item item);
    public void deleteCItems(String[] arr);
    public void updateItem(Item item);
    Item getItemByPK(int id);
    List<Item> getAllItem();
    public List<Item> getPitemById(Integer id);
    public List<Item> getPitems();
}
