import java.util.Scanner;
import java.util.ArrayList;
public class MenuSystem
{
    private int userChoice;
    private static Scanner keyboard;
    private CafeManager manager;
    public MenuSystem()
    {
        userChoice = 1;
        keyboard = new Scanner(System.in);
        manager = new CafeManager();
    }
    
    public MenuSystem(CafeManager c)
    {
        manager = new CafeManager();
        userChoice = 1;
        keyboard = new Scanner(System.in);
        manager = c;
    }
    
    public void displayMenu()
    {
        
        do
        {
            manager.showCafeInterface();
            userChoice = keyboard.nextInt();
            keyboard.nextLine();
            switch(userChoice)
            {
                case 1: showMenu();
                break;
                case 2: addMenuItem();
                break;
                case 3: addAnOrder();
                break;
                case 4: viewAnOrder();
                break;
                case 5: closeAnOrder();
                break;
                case 6: quit();
                break;
                default: System.out.println("please enter only numbers 1 to 6");
            }
        }
        while(userChoice != 6);
                                              
    }
    
    private void addAnOrder()
    {
        int stop = 0;
        ArrayList<MenuItem> menu = manager.getMenuOffers();                                         //getting all the mwnu items from the array in the cafe manager class
        Order meal = new Order();
        System.out.print("Enter a table number: ");
        meal.setTableNo(keyboard.nextLine());
        do
        {
            showMenu();                                                                             //shows the menu items available on the menu                                                  
            System.out.print("Enter corresponding order number to choose menu item: ");
            meal.addOrder(menu.get(keyboard.nextInt()));                                            //adding the chosen menu item to the order                                                      
            
            keyboard.nextLine();
            
            meal.showItems();                                                                       //shows all the items on the order
            System.out.println("Add another item? 1 - yes, 2 - no");
            stop = keyboard.nextInt();
            keyboard.nextLine();
        }
        while(stop != 2);
        manager.updateOrders(meal);                                                                 //adding the order to the lisr of orders int the cafe manager
        meal.setOrderNumber(manager.getCustomerOrders().indexOf(meal));                             //setting the order number based on its location in the array in the cafe manager class
    }
    
    private void viewAnOrder()
    {
        ArrayList<Order> allOrders = manager.getCustomerOrders();
        if(allOrders.size() > 0)
        {
            System.out.println("-------------- Orders -------------");
            for(Order i:allOrders)
            {
                System.out.println("Order Number: " + i.getOrderNumber() + "; Table Number: " + i.getTableNo() + ";  Open: "+i.isOpen());
            }
            System.out.println("----------------------------------");
            System.out.print("Enter corresponding order number to view order deatils: ");
            userChoice = keyboard.nextInt();
            System.out.println("----------------------------------------------------------- ");
            keyboard.nextLine();
            
            if(manager.getSingleOrder(userChoice).isOpen())                                         //determines the order's ability to be viewed based on whether its open or closed 
            {
                System.out.println(manager.getSingleOrder(userChoice).showItems());                 //prints the items chosen
            }
            else
            {
                System.out.println("This order is closed and cannot be viewed");
            }

        }
        else
        {
            System.out.println("You have at lease one order placed");
            addAnOrder();
        }
    }
    
    private void closeAnOrder()
    {
        System.out.println("-------------- Orders -------------");
        ArrayList<Order> allOrders = manager.getCustomerOrders();
        for(Order i:allOrders)
        {
            System.out.println("Order Number: " + i.getOrderNumber() + "; Table Number: " + i.getTableNo());    //prints all the orders made by the customer
        }
        System.out.println("----------------------------------");
        System.out.print("Enter corresponding order number to close it: ");
        userChoice = keyboard.nextInt();
        System.out.println();
        allOrders.get(userChoice).closeOrder();
    }
    
    private static void staffTraining()
    {
        System.out.println("Staff Trained");
    }
    
    private void addMenuItem()
    {
        String wordResponse = "";
        double numResponse = 0;
        MenuItem newItem = new MenuItem();
        System.out.print("Enter the item name: ");
        wordResponse = keyboard.nextLine();
        newItem.setName(wordResponse);
        System.out.print("Enter the item Description: ");
        wordResponse = keyboard.nextLine();
        newItem.setDescription(wordResponse.trim());
        System.out.print("Enter the item price: ");
        numResponse = keyboard.nextDouble();
        keyboard.nextLine();
        newItem.setPrice(numResponse);
        System.out.print("Enter the item preperation method: ");
        wordResponse = keyboard.nextLine();
        newItem.setPreperationMethod(wordResponse);
        manager.addToMenu(newItem);
        System.out.println();
        
    }
    
    private void showMenu()                                                             //shows all the items availale on the menu
    {
        ArrayList<MenuItem> menu = manager.getMenuOffers();
        int itemNo = 0;
        for(MenuItem i:menu)
        {
            itemNo = menu.indexOf(i);
            System.out.println("\n------------------ Menu Item "+itemNo+" ------------------");
            System.out.println("Name:\t\t\t" + i.getName() +"\nDescription:\t" + i.getDiscription() + "\nPrice:\t\t\tR " + i.getPrice() + "\nPreperation Method:\t" + i.getPreperationMethod());
            System.out.println("-------------------------------------------------\n");
        }
    }
    
    private static void quit()
    {
        System.out.println("Thank you for using the Cafe Menu System");
    }
    
    public String toString()
    {
        return("User Choice: " + userChoice + "Scanner: " + keyboard); 
    }
}