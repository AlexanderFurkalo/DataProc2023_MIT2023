package Entities;
public class Boots {

    private String name;
    private Number size;
    private Number price;

    public Boots(String name, Number size, Number price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getSize() {
        return size;
    }

    public void setSize(Number size) {
        this.size = size;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

}
