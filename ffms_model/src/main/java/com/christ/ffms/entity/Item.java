package com.christ.ffms.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Item {
    private int id;
    private int type;
    private String name;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    private String pName;
    public int getPId() {
        return PId;
    }

    public void setPId(int PId) {
        this.PId = PId;
    }

    private int PId;
    private Item pItem;
    private List<Item> items=new ArrayList<Item>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getpItem() {
        return pItem;
    }

    public void setpItem(Item pItem) {
        this.pItem = pItem;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public Item(){

    }

    public Item(int id, int type, String name, int PId, Item pItem, List<Item> items) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.PId = PId;
        this.pItem = pItem;
        this.items = items;
    }

    public Item(int id, int type, String name, Item pItem, List<Item> items) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.pItem = pItem;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", PId=" + PId +
                ", pItem=" + pItem +
                ", items=" + items +
                '}'+"\n";
    }
}
