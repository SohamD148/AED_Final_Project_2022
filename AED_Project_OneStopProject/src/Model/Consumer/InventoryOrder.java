/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Consumer;

import Model.Enterprise.Commodity;
import Model.Enterprise.Outlet;
import java.math.BigDecimal;

/**
 *
 * @author risha
 */
public abstract class InventoryOrder 
{
    private Commodity commodity;
    private int itemquantity;
    private double totalPrice;
    private Outlet outlet;

    public InventoryOrder(Commodity item, int quantity, Outlet outlet) 
    {
        this.commodity = item;
        this.itemquantity = quantity;
        this.outlet = outlet;
    }

    public Commodity getCommodity() {
        return commodity;
    }
    
    public void setInvemtoryItem(Commodity commodity) {
        this.commodity = commodity;
    }
    
    public abstract Outlet getShopModel();
    
    public void setInventory(Outlet outlet) {
        this.outlet = outlet;
    }
    
    public int getItemQuantity() {
        return this.itemquantity;
    }
    
    public void setItemquantity(int q) {
        this.itemquantity = q;
        BigDecimal bd = new BigDecimal(commodity.getCom_price() * q);
        this.totalPrice = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
     public double getTotalPrice() {
        BigDecimal bd = new BigDecimal(commodity.getCom_price() * itemquantity);
        this.totalPrice = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return this.totalPrice;
    }
     
     @Override
    public String toString() {
        return this.commodity.getCom_name();
    }
}
