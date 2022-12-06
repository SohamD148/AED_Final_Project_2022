/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author sohamdeshpande
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseDirectory;

    public EnterpriseDirectory() {
        enterpriseDirectory = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void removeEnterprise(Enterprise en) {
        Enterprise result = null;
        if (!enterpriseDirectory.isEmpty()) {
            for (Enterprise ent : enterpriseDirectory) {
                if (ent.getShipcom_id().equalsIgnoreCase(en.getShipcom_id())) {
                    result = ent;
                }
            }
            enterpriseDirectory.remove(result);
        } 
    }
}
