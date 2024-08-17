package com.example.demo.domain;

import com.example.demo.validators.ValidDeletePart;
import com.example.demo.validators.ValidMinimumPartInventory;
import com.example.demo.validators.ValidPartInventory;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Entity
@ValidDeletePart
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@ValidPartInventory
@ValidMinimumPartInventory
@Table(name="Parts")
public abstract class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    int inv;

    @Min(value = 0, message = "Inventory minimum value cannot be less than zero.")
    int minimumInventory;
    int maximumInventory;

    @ManyToMany
    @JoinTable(name="product_part", joinColumns = @JoinColumn(name="part_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    Set<Product> products= new HashSet<>();

    public Part() {
    }

    public Part(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minimumInventory = 0;
        this.maximumInventory = 100;

    }

    public Part(long id, String name, double price, int inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minimumInventory = 0;
        this.maximumInventory = 100;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInv() {
        return inv;
    }

    // Here I decided if the inventory was outside desired range to reset to default
    public void inventoryAvailabilityCheck() {

        if (this.inv < this.minimumInventory) {

            this.inv = this.minimumInventory;
            //(value = 0, message = "INVALID! Your minimum value must be LOWER than your inventory value.");

        }
        else if (this.inv > this.maximumInventory) {

            this.inv = this.maximumInventory;
            //message = "INVALID! Your minimum value must be LOWER than your inventory value.";

        }
    }

    public void setInv(int inv) {
        this.inv = inv;
    }

    public int getMaximumInventory() {
        return this.maximumInventory;
    }

    public void setMaximumInventory(int maximumInventory) {
        this.maximumInventory = maximumInventory;
    }

    public int getMinimumInventory() {
        return this.minimumInventory;
    }

    public void setMinimumInventory(int minimumInventory) {
        this.minimumInventory = minimumInventory;
    }

    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
