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
class Smartphone extends Phone{
     protected String ram, camera, screen, network;

    Smartphone(String name, String brand, String screen, String camera, String price, String ram, String network){
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.ram = ram;
        this.camera = camera;
        this.screen = screen;
        this.network = network;
    }

    Smartphone(){}


    public String getRam(){
        return this.ram;
    }

    public void setRam(String ram){
        this.ram = ram;
    }

    public String getCamera(){
        return this.camera;
    }

    public void setCamera(String camera){
        this.camera = camera;
    }

    public String getScreen(){
        return this.screen;
    }

    public void setScreen(String screen){
        this.screen = screen;
    }

    public String getNetwork(){
        return this.network;
    }

    public void setNetwork(String network){
        this.network = network;
    }

    @Override
    public String toString(){
        return "Name: " + name + "\nBrand: " + brand + "\nPrice: " + price + "\nRam: " + ram + "\nCamera: " + camera + "\nScreen Size" + screen + "\nNetwork Type: " + network;
    }


}
