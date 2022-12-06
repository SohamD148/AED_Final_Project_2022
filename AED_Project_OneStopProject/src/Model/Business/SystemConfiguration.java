/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Business;

/**
 *
 * @author risha
 */
public class SystemConfiguration 
{
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
        ShipmentCompany sc1 = network1.createDeliveryCompany("Fedex Delivery Company", "110 Allstate, Boston, MA 02125", "8838381221");
        sc1.setShipcom_description("This is delivery company located at Boston.");
        sc1.setShipcom_id("Delivery");
        sc1.setPath("Images/DeliveryCompanyCut/default.png");
        Employee b1 = sc1.getEmployeeDirectory().createEmployee("Rishabh", "Singh", "8483332321", "rsingh@gmail.com");
        UserAccount user4 = sc1.getUserAccountDirectory().createEmployeeAccount("risha", "12345", new BossRole(), b1);
        // BOSTON Delivery Company Organization
        SupervisorOrganization sup1 = (SupervisorOrganization) sc1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        CourierOrganization cou1 = (CourierOrganization) sc1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Courier);
        Employee emp2 = sup1.getEmployeeDirectory().createEmployee("Brandon", "Smith", "8787893932", "brandonsm@fedex.com");
        UserAccount user5 = sup1.getUserAccountDirectory().createEmployeeAccount("brandsm", "sup123", new SupervisorRole(), emp2);

        Employee emp3 = sup1.getEmployeeDirectory().createEmployee("Jacob", "Riley", "3993902993", "jacey@fedex.com");
        UserAccount user6 = sup1.getUserAccountDirectory().createEmployeeAccount("jacey", "jac123", new DeliveryManRole(), emp3);

        Employee emp4 = cou1.getEmployeeDirectory().createEmployee("Willson", "dunk", "3899992312", "willdunk@fedex.com");
        UserAccount user7 = cou1.getUserAccountDirectory().createEmployeeAccount("will", "will456", new DeliveryManRole(), emp4);

        // BOSTON Restaurant List
        Restaurant restaurant1 = network1.createRestaurant("Chipotle", "855 Boylston St, Boston, MA 02210", "3873883323");
        restaurant1.setType(Restaurant.RestaurantCategory.Seafood);
        restaurant1.setShipcom_id("Chip");
        restaurant1.setPath("Images/RestaurantCut/default.png");
        restaurant1.setOut_description("Chipotle Mexican Grill, Inc., often known simply as Chipotle, is an American chain of fast casual restaurants specializing in bowls, tacos and Mission burritos made to order in front of the customer. Chipotle operates restaurants in the United States");
        Menu menu1 = new Menu(restaurant1, "Burrito", 8.39);
        Menu menu2 = new Menu(restaurant1, "Tacos", 4.59);
        Menu menu3 = new Menu(restaurant1, "Burrito Bowl", 9.99);
        restaurant1.addDashToMenu(menu1);
        restaurant1.addDashToMenu(menu2);
        restaurant1.addDashToMenu(menu3);
        
        Employee emp5 = restaurant1.getEmployeeDirectory().createEmployee("Chase", "Cory", "3893899933", "chase@chipotle.com");
        UserAccount user8 = restaurant1.getUserAccountDirectory().createEmployeeAccount("chase", "chase123", new BossRole(), emp5);
        
        SupervisorOrganization sup2 = (SupervisorOrganization) restaurant1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        Employee emp6 = sup2.getEmployeeDirectory().createEmployee("Ryan", "Reynolds", "8738787383", "ryan@chipotle.com");
        UserAccount user9 = sup2.getUserAccountDirectory().createEmployeeAccount("ryan", "ryan123", new SupervisorRole(), emp6);

        Restaurant restaurant2 = network1.createRestaurant("Chick-Fil-A", "674 Northern Ave, Boston, MA 02210", "6728323233");
        restaurant2.setType(Restaurant.RestaurantCategory.Seafood);
        restaurant2.setShipcom_id("chick");
        restaurant2.setPath("Images/RestaurantCut/default.png");
        restaurant2.setOut_description("Chick-fil-A is one of the largest American fast food restaurant chains and the largest specializing in chicken sandwiches. The company is headquartered in College Park, Georgia. Chick-fil-A operates 2,873 restaurants, primarily in the United States");
        Menu menu4 = new Menu(restaurant2, "Chicken Sandwich", 8.95);
        Menu menu5 = new Menu(restaurant2, "Grilled Chicken Sandwich", 10);
        Menu menu6 = new Menu(restaurant2, "Hot wings", 5.99);
        restaurant2.addDashToMenu(menu4);
        restaurant2.addDashToMenu(menu5);
        restaurant2.addDashToMenu(menu6);
        
        Employee emp7 = restaurant2.getEmployeeDirectory().createEmployee("Blake", "Henderson", "3899838933", "blake@chick.com");
        UserAccount user10 = restaurant2.getUserAccountDirectory().createEmployeeAccount("blake", "blake123", new BossRole(), emp7);
        
        SupervisorOrganization sup3 = (SupervisorOrganization) restaurant2.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        Employee emp8 = sup3.getEmployeeDirectory().createEmployee("Sejal", "Sharma", "8388388383", "sejal@chick.com");
        UserAccount user11 = sup3.getUserAccountDirectory().createEmployeeAccount("sejal", "seja123", new SupervisorRole(), emp8);

        // Boston Mart List
        Mart mart1 = network1.createMart("Trader Joe", "834 Boylston St, Boston, MA 02115", "(617) 375-1010");
        mart1.setShipcom_id("tarder");
        mart1.setPath("Images/StoreCut/default.png");
        mart1.setType(Mart.StoreCategory.Organic);
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
        restaurant3.addDashToMenu(menu7);
        restaurant3.addDashToMenu(menu8);
        restaurant3.addDashToMenu(menu9);
        
        
        
        Employee emp11 = restaurant3.getEmployeeDirectory().createEmployee("Sam", "Alfred", "8398983923", "sam@deadhorse.com");
        UserAccount user14 = restaurant3.getUserAccountDirectory().createEmployeeAccount("sam", "sam123", new BossRole(), emp11);
        
        SupervisorOrganization sup5 = (SupervisorOrganization) restaurant3.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Supervisor);
        Employee emp12 = sup5.getEmployeeDirectory().createEmployee("Rachel", "Green", "8988399333", "rachel@deadhorse.com");
        UserAccount user15 = sup5.getUserAccountDirectory().createEmployeeAccount("rachel", "rachel123", new SupervisorRole(), emp12);
        return system;
    }
    
}
