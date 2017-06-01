/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knowledge_ass;

/**
 *
 * @author fatinhalim
 */
class Phone {
    protected String name, brand, price;

    Phone(){
        this.name = null;
        this.brand = null;
        this.price = null;
    }
    Phone(String name, String brand, String price){
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getPrice(){
        return this.price;
    }

    public void setPrice(String price){
        this.price = price;
    }
    
}
