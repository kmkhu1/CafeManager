import java.util.ArrayList;

public class CafeManager
{
    private ArrayList <MenuItem> menuOffers;
    private ArrayList <Order> customerOrders;
    
    public CafeManager()
    {
        menuOffers = new ArrayList<MenuItem>();
        customerOrders = new ArrayList<Order>();
        setDefaultMenu();
    }
    
    public void showCafeInterface()                                                     //displays the interface for the menu
    {
        System.out.println("Choose by entering corrisponding number");
        System.out.println("-------Cafe Options-------");
        System.out.println("1 - View menu items");
        System.out.println("2 - Add to menu items");
        System.out.println("3 - Add a new customer order");
        System.out.println("4 - View customer order");
        System.out.println("5 - Close an order");
        System.out.println("6 - Exit");
        System.out.println("--------------------------");
    }
    
    public ArrayList getMenuOffers()                                                    //returns a duplicate of the menuOffers Array
    {
        ArrayList <MenuItem> duplicate = new ArrayList <MenuItem>();
        for(MenuItem i:menuOffers)
        {
            MenuItem copy = new MenuItem();
            copy = i;
            duplicate.add(copy);
        }
        return duplicate;
    }
    
    public ArrayList getCustomerOrders()                                                //returns a duplicate of the customer orders array
    {
        ArrayList <Order> duplicate = new ArrayList <Order>();
        for(Order i:customerOrders)
        {
            Order copy = new Order();
            copy = i;
            duplicate.add(copy);
        }
        return duplicate;
    }
    
    public void addToMenu(MenuItem mo)                                                  //adds a menu item to the menu offers array, essentially upating the menu
    {
        MenuItem duplicate = new MenuItem();
        duplicate = mo;
        menuOffers.add(duplicate);
        System.out.println(duplicate.getName() + " has been added to the menu");
    } 
    
    public void updateOrders(Order co)
    {
        Order duplicate = new Order();
        duplicate = co;
        customerOrders.add(duplicate);
    }
    
    public void setDefaultMenu()                                                        //displays all currently available items on the menu
    {
        menuOffers.add(new MenuItem("Beef","Meat of a cow",60,"Cook on stove"));
        menuOffers.add(new MenuItem("Mutton","Meat of a sheep",65,"Cook on open flame"));
        menuOffers.add(new MenuItem("Pork","Meat of a pig",70,"Cook in microwave"));
        menuOffers.add(new MenuItem("Fish","Meat from the sea",75,"Just season and serve"));
        menuOffers.add(new MenuItem("Fruit","Grow on trees",20,"Do not cook!"));
        menuOffers.add(new MenuItem("Vegetables","Grow on the ground",15,"Boil for short period"));
        menuOffers.add(new MenuItem("Dessert","Sweet pleasures",60,"Bake in oven, and serve with icecream"));
    }
    
    public Order getSingleOrder(int i)
    {
        Order duplicate = new Order();
        duplicate = customerOrders.get(i);
        return duplicate;
    }
}