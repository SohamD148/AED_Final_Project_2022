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
        ShipmentCompany sc1 = network1.createDeliveryCompany("Fedex Delivery Company", "110 Allstate, Boston, MA 02125", "(617) 553-5900");
        sc1.setShipcom_description("This is delivery company ");
        sc1.setShipcom_id("Delivery");
        sc1.setPath("Images/DeliveryCompanyCut/default.png");
        Employee b1 = sc1.getEmployeeDirectory().createEmployee("Rishabh", "Singh", "773383812", "rsingh@gmail.com");
        UserAccount user4 = sc1.getUserAccountDirectory().createEmployeeAccount("risha", "12345", new BossRole(), b1);
        // BOSTON Delivery Company Organization
        SupervisorOrganization sup1 = (SupervisorOrganization) sc1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        CourierOrganization cou1 = (CourierOrganization) sc1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Courier);
        
        Employee emp2 = sup1.getEmployeeDirectory().createEmployee("Jason", "Mamoth", "5544542324", "jasonm@fedex.com");
        UserAccount user5 = sup1.getUserAccountDirectory().createEmployeeAccount("jason", "123", new SupervisorRole(), emp2);

        Employee emp3 = sup1.getEmployeeDirectory().createEmployee("Riley", "Kane", "6453323433", "riley@fedex.com");
        UserAccount user6 = sup1.getUserAccountDirectory().createEmployeeAccount("riley", "kane", new DeliveryManRole(), emp3);

        Employee emp4 = cou1.getEmployeeDirectory().createEmployee("Ricardo", "Ruth", "6543232344", "deliveryman1@demo.com");
        UserAccount user7 = cou1.getUserAccountDirectory().createEmployeeAccount("ricardo", "123", new DeliveryManRole(), emp4);

        // BOSTON Restaurant List
        Restaurant restaurant1 = network1.createRestaurant("Chick-Fil-A", "855 Boylston St, Boston, MA 02210", "(617) 553-5900");
        restaurant1.setType(Restaurant.RestaurantCategory.American);
        restaurant1.setShipcom_id("chick");
        restaurant1.setPath("Images/RestaurantCut/default.png");
        restaurant1.setOut_description("American Fast food chain known for its chicken sandwiches");
        Menu menu1 = new Menu(restaurant1, "Chicken Sandwich", 8.99);
        Menu menu2 = new Menu(restaurant1, "Peri Peri Chicken Sandwich", 10.49);
        Menu menu3 = new Menu(restaurant1, "Hot wings", 6.79);
        restaurant1.addToMenu(menu1);
        restaurant1.addToMenu(menu2);
        restaurant1.addToMenu(menu3);
        
        Employee emp5 = restaurant1.getEmployeeDirectory().createEmployee("Cory", "Mallow", "4984894389", "cory@chick.com");
        UserAccount user8 = restaurant1.getUserAccountDirectory().createEmployeeAccount("cory", "1234", new BossRole(), emp5);
        
        SupervisorOrganization sup2 = (SupervisorOrganization) restaurant1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        Employee emp6 = sup2.getEmployeeDirectory().createEmployee("Rebecca", "Smith", "8484893233", "rebecca@chick.com");
        UserAccount user9 = sup2.getUserAccountDirectory().createEmployeeAccount("rebecca", "1234", new SupervisorRole(), emp6);

        Restaurant restaurant2 = network1.createRestaurant("Chipotle", "564 Northern Ave, Boston, MA 02210", "(857) 477-2900");
        restaurant2.setType(Restaurant.RestaurantCategory.American);
        restaurant2.setShipcom_id("chipotle");
        restaurant2.setPath("Images/RestaurantCut/default.png");
        restaurant2.setOut_description("Specializing in mexican burrito bowls and tacos");
        Menu menu4 = new Menu(restaurant2, "Burrito", 8.5);
        Menu menu5 = new Menu(restaurant2, "Burrito Bowl", 14);
        Menu menu6 = new Menu(restaurant2, "Taco", 3.99);
        restaurant2.addToMenu(menu4);
        restaurant2.addToMenu(menu5);
        restaurant2.addToMenu(menu6);
        
        Employee emp7 = restaurant2.getEmployeeDirectory().createEmployee("Andres", "Ineista", "39838923873", "andres@chipotle.com");
        UserAccount user10 = restaurant2.getUserAccountDirectory().createEmployeeAccount("andres", "12345", new BossRole(), emp7);
        
        SupervisorOrganization sup3 = (SupervisorOrganization) restaurant2.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        Employee emp8 = sup3.getEmployeeDirectory().createEmployee("Ruchi", "Shah", "8387833236", "ruchi@chipotle.com");
        UserAccount user11 = sup3.getUserAccountDirectory().createEmployeeAccount("ruchi", "1234", new SupervisorRole(), emp8);

        // Boston Mart List

        Mart mart1 = network1.createMart("Trader Joe", "834 Boylston St, Boston, MA 02115", "(617) 375-1010");
        mart1.setShipcom_id("tarder");

        mart1.setPath("Images/StoreCut/default.png");
        mart1.setType(Mart.MartType.GroceryStore);
        mart1.setOut_description("Trader Joe's is an American chain of grocery stores headquartered in Monrovia, California. The chain has over 530 stores across the United States");
        Product p1 = new Product(mart1, "Milk", 3.45);
        Product p2 = new Product(mart1, "Eggs", 4.49);
        Product p3 = new Product(mart1, "Chicken", 5.87);
        Product p4 = new Product(mart1, "Bananas", 0.13);
        Product p5 = new Product(mart1, "Cabbage", 1.0);
        Product p6 = new Product(mart1, "Tomatos", 0.39);
        Product p7 = new Product(mart1, "Onions", 0.56);
        Product p8 = new Product(mart1, "Yoghurt", 4.69);
        
        mart1.addProductToList(p1);
        mart1.addProductToList(p2);
        mart1.addProductToList(p3);
        mart1.addProductToList(p4);
        mart1.addProductToList(p5);
        mart1.addProductToList(p6);
        mart1.addProductToList(p7);
        mart1.addProductToList(p8);
        
        Employee emp9 = mart1.getEmployeeDirectory().createEmployee("Hugo", "Lorris", "3889398398", "hugo@trader.com");
        UserAccount user12 = mart1.getUserAccountDirectory().createEmployeeAccount("hugo", "hugo123", new BossRole(), emp9);
        
        SupervisorOrganization sup4 = (SupervisorOrganization) mart1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        Employee emp10 = sup4.getEmployeeDirectory().createEmployee("Lacy", "Myers", "7488442332", "lacy@trader.com");
        UserAccount user13 = sup4.getUserAccountDirectory().createEmployeeAccount("lacy", "lacy123", new SupervisorRole(), emp10);
        
        
        // Worchester Restaurant List
        Restaurant restaurant3 = network2.createRestaurant("Deadhorse hill", "281 Main St, Worchester, MA 01608", "7744207107");
        restaurant3.setType(Restaurant.RestaurantCategory.American);
        restaurant3.setShipcom_id("deadhorse");
        restaurant3.setPath("Images/RestaurantCut/default.png");
        restaurant3.setOut_description("A hilltop hotel houses a rustic-chic New American dining room with daytime cafe and coffee bar.");
        Menu menu7 = new Menu(restaurant3, "Grilled Cheese", 9);
        Menu menu8 = new Menu(restaurant3, "Smoked turkey Breast", 12);
        Menu menu9 = new Menu(restaurant3, "French Dip", 14);
        restaurant3.addToMenu(menu7);
        restaurant3.addToMenu(menu8);
        restaurant3.addToMenu(menu9);
        
        
        
        Employee emp11 = restaurant3.getEmployeeDirectory().createEmployee("Sam", "Alfred", "8398983923", "sam@deadhorse.com");
        UserAccount user14 = restaurant3.getUserAccountDirectory().createEmployeeAccount("sam", "sam123", new BossRole(), emp11);
        
        SupervisorOrganization sup5 = (SupervisorOrganization) restaurant3.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        Employee emp12 = sup5.getEmployeeDirectory().createEmployee("Rachel", "Green", "8988399333", "rachel@deadhorse.com");
        UserAccount user15 = sup5.getUserAccountDirectory().createEmployeeAccount("rachel", "rachel123", new SupervisorRole(), emp12);
        
        Mart mart2 = network1.createMart("CVS Pharmasy", "8381 Main St, Worchester, MA 01608", "(617) 375-1810");
        mart1.setShipcom_id("tarder");

        mart2.setPath("Images/StoreCut/default.png");
        mart2.setType(Mart.MartType.Pharmacy);
        mart2.setOut_description("CVS Pharmascy is an American chain of pharmacy stores headquartered in Woonsocket, Rhode. ");
        Product pr1 = new Product(mart2, "Mask", 3.45);
        Product pr2 = new Product(mart2, "Bandage", 4.49);
        Product pr3 = new Product(mart2, "Cough Syrup", 13.87);
        Product pr4 = new Product(mart2, "Covid 19 Test Kits", 23.99);
        Product pr5 = new Product(mart2, "Pepcid AC", 14.70);
        Product pr6 = new Product(mart2, "Stabilizing Knee Support",23.79);
        
        mart2.addProductToList(pr1);
        mart2.addProductToList(pr2);
        mart2.addProductToList(pr3);
        mart2.addProductToList(pr4);
        mart2.addProductToList(pr5);
        mart2.addProductToList(pr6);
  
        return system;
    }

}
