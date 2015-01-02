/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hoangnv
 */
public class Item {

    private String id;
    private String description;
    private Float price;
    private List<String> urls;

    public Item(String id, String description, Float price, String... urls) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.urls = new ArrayList<>();
        this.urls.addAll(Arrays.asList(urls));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", description=" + description + ", price=" + price + ", urls=" + urls + "]";
    }
}
