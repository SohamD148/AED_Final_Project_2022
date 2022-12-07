/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Business;

import Model.Consumer.Consumer;
import Model.Employee.Employee;
import Model.Enterprise.Delivery.ShipmentCompany;
import Model.Network.Network;
import Model.Organization.SupervisorOrganization;
import Model.Organization.Organization;
import Model.Enterprise.Restaurant.Menu;
import Model.Enterprise.Restaurant.Restaurant;
import Model.Enterprise.Mart.Product;
import Model.Enterprise.Mart.Mart;
import Model.Organization.CourierOrganization;
import Model.Role.BossRole;
import Model.Role.DeliveryManRole;
import Model.Role.SupervisorRole;
import Model.Role.SystemAdminRole;
import Model.UserAccount.UserAccount;

/**
 *
 * @author sohamdeshpande
 */
public class SystemConfiguration {
    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        // System manager, belongs to SYSTEM
        Employee emp1 = system.getEmployeeDirectory().createEmployee("Rishabh", "Singh", "8576938587", "rishabhsingh1894@gmail.com");
        UserAccount user1 = system.getUserAccountDirectory().createEmployeeAccount("sysadmin", "sysadmin", new SystemAdminRole(), emp1);

        // Consumer, belongs to SYSTEM
        Consumer c1 = system.getConsumer().createCustomer("Rutuja", "More", "rutu@gmail.com", "7838832333");
        UserAccount user2 = system.getUserAccountDirectory().createConsumerAccount("rutu", "12345", c1);

        Consumer c2 = system.getConsumer().createCustomer("Soham", "Deshpande", "Sohamdesh@hotmail.com", "9838332334");
        UserAccount user3 = system.getUserAccountDirectory().createConsumerAccount("soham", "12345", c2);

        // MA NETWORK 
        Network network1 = system.createNetwork("Boston");
        network1.setNetwork_id("Boston");
        Network network2 = system.createNetwork("Worchester");
        network2.setNetwork_id("Worchester");

        // BOSTON Enterprise with organiztions created
        ShipmentCompany sc1 = network1.createDeliveryCompany("Boston Delivery Company", "110 Allstate, Boston, MA 02125", "(617) 553-5900");
        sc1.setShipcom_description("This is delivery company located at Boston.");
        sc1.setShipcom_id("Delivery");
        sc1.setPath("Images/DeliveryCompanyCut/default.png");
        Employee b1 = sc1.getEmployeeDirectory().createEmployee("Rishabh", "Singh", "773383812", "rsingh@gmail.com");
        UserAccount user4 = sc1.getUserAccountDirectory().createEmployeeAccount("risha", "12345", new BossRole(), b1);
        // BOSTON Delivery Company Organization
        SupervisorOrganization sup1 = (SupervisorOrganization) sc1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        CourierOrganization cou1 = (CourierOrganization) sc1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Courier);
        Employee emp2 = sup1.getEmployeeDirectory().createEmployee("Manager", "Manager", "111", "manager@demo.com");
        UserAccount user5 = sup1.getUserAccountDirectory().createEmployeeAccount("m", "m", new SupervisorRole(), emp2);

        Employee emp3 = sup1.getEmployeeDirectory().createEmployee("Delivery", "Man", "1111", "deliveryman@demo.com");
        UserAccount user6 = sup1.getUserAccountDirectory().createEmployeeAccount("d", "d", new DeliveryManRole(), emp3);

        Employee emp4 = cou1.getEmployeeDirectory().createEmployee("Delivery", "Man", "1111", "deliveryman1@demo.com");
        UserAccount user7 = cou1.getUserAccountDirectory().createEmployeeAccount("dd", "dd", new DeliveryManRole(), emp4);

        // BOSTON Restaurant List
        Restaurant restaurant1 = network1.createRestaurant("Row 34", "383 Congress St, Boston, MA 02210", "(617) 553-5900");
        restaurant1.setType(Restaurant.RestaurantCategory.Seafood);
        restaurant1.setShipcom_id("Row");
        restaurant1.setPath("Images/RestaurantCut/default.png");
        restaurant1.setOut_description("This stylish brick-&-wood eatery serves an extensive oyster menu plus fish entrees & craft beers.");
        Menu menu1 = new Menu(restaurant1, "Dash1", 20);
        Menu menu2 = new Menu(restaurant1, "Dash2", 30);
        Menu menu3 = new Menu(restaurant1, "Dash3", 27.6);
        restaurant1.addDashToMenu(menu1);
        restaurant1.addDashToMenu(menu2);
        restaurant1.addDashToMenu(menu3);
        
        Employee emp5 = restaurant1.getEmployeeDirectory().createEmployee("Row34", "Boss", "12344", "boss@row34.com");
        UserAccount user8 = restaurant1.getUserAccountDirectory().createEmployeeAccount("row34", "row34", new BossRole(), emp5);
        
        SupervisorOrganization sup2 = (SupervisorOrganization) restaurant1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        Employee emp6 = sup2.getEmployeeDirectory().createEmployee("Manager", "Manager", "111", "manager@demo.com");
        UserAccount user9 = sup2.getUserAccountDirectory().createEmployeeAccount("rm", "rm", new SupervisorRole(), emp6);

        Restaurant restaurant2 = network1.createRestaurant("Legal Harborside", "270 Northern Ave, Boston, MA 02210", "(617) 477-2900");
        restaurant2.setType(Restaurant.RestaurantCategory.Seafood);
        restaurant2.setShipcom_id("legal");
        restaurant2.setPath("Images/RestaurantCut/default.png");
        restaurant2.setOut_description("Specializing in upmarket seafood, this contemporary chain also serves steaks & cocktails.");
        Menu menu4 = new Menu(restaurant2, "D1", 10);
        Menu menu5 = new Menu(restaurant2, "D2", 14);
        Menu menu6 = new Menu(restaurant2, "D3", 11.99);
        restaurant2.addDashToMenu(menu4);
        restaurant2.addDashToMenu(menu5);
        restaurant2.addDashToMenu(menu6);
        
        Employee emp7 = restaurant2.getEmployeeDirectory().createEmployee("Legal", "Boss", "222", "boss@demo.com");
        UserAccount user10 = restaurant2.getUserAccountDirectory().createEmployeeAccount("legal", "legal", new BossRole(), emp7);
        
        SupervisorOrganization sup3 = (SupervisorOrganization) restaurant2.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        Employee emp8 = sup3.getEmployeeDirectory().createEmployee("Manager", "Manager", "222", "manager@demo.com");
        UserAccount user11 = sup3.getUserAccountDirectory().createEmployeeAccount("lm", "lm", new SupervisorRole(), emp8);

        // Boston Mart List
        Mart mart1 = network1.createStore("Whole Foods", "15 Westland Ave, Boston, MA 02115", "(617) 375-1010");
        mart1.setShipcom_id("whole");
        mart1.setPath("Images/StoreCut/default.png");
        mart1.setType(Mart.StoreCategory.Organic);
        mart1.setOut_description("Eco-minded chain with natural & organic grocery items, housewares & other products.");
        Product p1 = new Product(mart1, "Cookie", 2);
        Product p2 = new Product(mart1, "Coke", 2.5);
        Product p3 = new Product(mart1, "Water", 1);
        Product p4 = new Product(mart1, "fork", 6);
        mart1.addProductToList(p1);
        mart1.addProductToList(p2);
        mart1.addProductToList(p3);
        mart1.addProductToList(p4);
        
        Employee emp9 = mart1.getEmployeeDirectory().createEmployee("Whole", "Foods", "222", "boss@demo.com");
        UserAccount user12 = mart1.getUserAccountDirectory().createEmployeeAccount("whole", "whole", new BossRole(), emp9);
        
        SupervisorOrganization sup4 = (SupervisorOrganization) mart1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        Employee emp10 = sup4.getEmployeeDirectory().createEmployee("Manager", "Manager", "222", "manager@demo.com");
        UserAccount user13 = sup4.getUserAccountDirectory().createEmployeeAccount("wm", "wm", new SupervisorRole(), emp10);
        
        
        // Atlanta Restaurant List
        Restaurant restaurant3 = network2.createRestaurant("Home grown GA Restaurant", "968 Memorial Dr SE, Atlanta, GA 30316", "(404) 222-0455");
        restaurant3.setType(Restaurant.RestaurantCategory.American);
        restaurant3.setShipcom_id("home");
        restaurant3.setPath("Images/RestaurantCut/default.png");
        restaurant3.setOut_description("Laid-back eatery serving locally sourced breakfast & Southern fare in a retro country-diner setting.");
        Menu menu7 = new Menu(restaurant3, "D1", 10);
        Menu menu8 = new Menu(restaurant3, "D2", 14);
        Menu menu9 = new Menu(restaurant3, "D3", 11.99);
        restaurant3.addDashToMenu(menu7);
        restaurant3.addDashToMenu(menu8);
        restaurant3.addDashToMenu(menu9);
        
        Employee emp11 = restaurant3.getEmployeeDirectory().createEmployee("Home Grown", "Boss", "222", "boss@demo.com");
        UserAccount user14 = restaurant3.getUserAccountDirectory().createEmployeeAccount("home", "home", new BossRole(), emp11);
        
        SupervisorOrganization sup5 = (SupervisorOrganization) restaurant3.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        Employee emp12 = sup5.getEmployeeDirectory().createEmployee("Manager", "Manager", "222", "manager@demo.com");
        UserAccount user15 = sup5.getUserAccountDirectory().createEmployeeAccount("hm", "hm", new SupervisorRole(), emp12);
        return system;
    }

}
