package be.ehb.demoadvancedlist.model;

import java.io.Serializable;

/**
 * Created by Q on 16-2-2018.
 */

public class Fruit implements Serializable {

    private String name;
    private float price;

    public Fruit(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
