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
public class EnterpriseType {

    public static Enterprise createEnterprise(String name, String address, String phone, String description, String type) {
        if (type.equalsIgnoreCase("Restaurant")) {
            Restaurant r = new Restaurant(name, address, phone);
            r.setOut_description(description);
            r.createOrganizations();
            return r;
        }
        if (type.equalsIgnoreCase("Store")) {
            Mart s = new Mart(name, address, phone);
            s.setOut_description(description);
            s.createOrganizations();
            return s;
        }
        if (type.equalsIgnoreCase("Delivery Company")) {
            ShipmentCompany d = new ShipmentCompany(name, address, phone);
            d.setShipcom_description(description);
            d.createOrganizations();
            return d;
        }
        return null;
    }
    
}
