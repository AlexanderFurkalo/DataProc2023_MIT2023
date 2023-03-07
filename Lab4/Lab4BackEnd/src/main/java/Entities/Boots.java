package Entities;

import java.io.Serializable;
public class Boots implements Serializable{
    private int id;
    private String name;
    private int size;
    private int price;
    private String image;

    public Boots(int id, String name, int size, int price, String image) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.image = image;
    }

    public Boots() {

    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "{\"id\":" +id+",\"name\":" +name+",\"size\":"+size+",\"price\":"+price+",\"image\":"+image+"}";
    }
}
