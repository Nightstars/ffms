package com.christ.ffms.service;

import com.christ.ffms.dao.ItemDao;
import com.christ.ffms.entity.Item;
import com.christ.ffms.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class ItemService {
    @Autowired
    ItemDao itemDao;
    @Transactional(readOnly = true, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public List<Item> listItem(){
        List<Item> items=itemDao.getAllItem();
        return items;
    }
    @Transactional(readOnly = true, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public List<Item> listPItem(Integer id){
        List<Item> items=itemDao.getPitemById(id);
        return items;
    }
    @Transactional(readOnly = true, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public Item getOneItem(Integer id){
        return itemDao.getItemByPK(id);
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public void updateItem(Item item){
        itemDao.updateItem(item);
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public void saveItem(Item item){
        if(item.getPId()==0){
            itemDao.savePItem(item);
        }else {
            itemDao.saveCItem(item);
        }
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public void deleteItem(Item item){
        if(item.getPId()==0){
            itemDao.deletePItem(item);
            itemDao.deleteCItem(item);
        }else {
            itemDao.deleteCItem(item);
        }
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public void deletePItems(String[] arr){
            itemDao.deletePItems(arr);
            itemDao.deleteCItems(arr);
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public void deleteCItems(String[] arr){
        itemDao.deleteCItems(arr);
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public List<Item> getPItems(){
        return itemDao.getPitems();
    }
}
