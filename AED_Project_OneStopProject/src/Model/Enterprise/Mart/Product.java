/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Enterprise.Mart;

import Model.Enterprise.Commodity;

/**
 *
 * @author sohamdeshpande
 */
public class Product extends Commodity{
    private Mart mart;

    public Product(Mart store, String name, double price) {
        super(name, price);
        this.mart = store;
    }

    public Mart getMart() {
        return this.mart;
    }
}
