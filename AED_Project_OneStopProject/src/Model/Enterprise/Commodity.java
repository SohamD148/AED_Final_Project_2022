/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

/**
 *
 * @author sohamdeshpande
 */
public class Commodity {
    private String com_name;
    private double com_price;

    public Commodity(String name, double price) {
        this.com_name = name;
        this.com_price = price;
    }

    public String getCom_name() {
        return this.com_name;
    }
    
    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public double getCom_price() {
        return this.com_price;
    }
    
    public void setCom_price(double com_price) {
        this.com_price = com_price;
    }
    
    @Override
    public String toString() {
        return this.com_name;
    }
}
