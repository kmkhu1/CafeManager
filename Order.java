import java.util.ArrayList;

public class Order
{
    //private static int orderNumberTracker = 0;
    private int orderNumber;
    private String tableNo;
    private double totalCost;
    private boolean open;
    ArrayList <MenuItem> orders;
    
    public Order()
    {
        
        orderNumber = 0;
        open = true;
        tableNo = "";
        orders = new ArrayList<MenuItem>();
        totalCost = 0;
    }
    
    public Order(int on, String tn)
    {
       
        orderNumber = on;
        open = true;
        tableNo = tn;
        orders = new ArrayList<MenuItem>();
        totalCost = 0;
    }
    
    public void addOrder(MenuItem food)
    { 
        MenuItem duplicate = new MenuItem();
        duplicate = food; 
        orders.add(duplicate);
        System.out.println(duplicate.getName() +" has been added to the order");
    }
    
    public int getOrderNumber()
    {
        return orderNumber;
    }
    
    public String getTableNo()
    {
        return tableNo;
    }
    
    public void setTableNo(String tn)
    {
        tableNo = tn;
    }
    
    public void setOrderNumber(int on)
    {
        orderNumber = on;
    }
        
    public ArrayList getOrders()                                                //returns a duplicate arraylist of all the menu itesm odered
    {
        ArrayList <MenuItem> duplicate = new ArrayList<MenuItem>();
        for(MenuItem i:orders)
        {
            MenuItem copy = new MenuItem();
            copy = i;
            duplicate.add(copy);
        }
        return(duplicate);
    }
    
    public void calculateTotalPrice()                                            //calculates the total price of all the menu items by adding all thier prices
    {
        for(MenuItem i:orders)
        {
            totalCost += i.getPrice();
        }
    }
    
    public String showItems()                                                   //shows the details of each order, including all the menuItems i that order
    {
        totalCost = 0;
        String listOfOrders = "";
        for(MenuItem i: orders)
        {
            listOfOrders += i.getName() + ", " + i.getDiscription() + ": " + i.getPrice()+"\n";
        }
        calculateTotalPrice();
        return "orderNumber: " + orderNumber + "\nTable Number: " + tableNo +"\n\nMenu items on this order:\n" + listOfOrders + "\n\nTotal: " + totalCost;
    }
    
    
    public String toString()
    {
        String listOfOrders = "";
        for(MenuItem i: orders)
        {
            listOfOrders = i.getName() + ", " + i.getDiscription() + ": " + i.getPrice()+"\n";
        }
        return "orderNumber: " + orderNumber + "\nTable Number: " + tableNo +"\n\nOrders:\n" + listOfOrders + "\n\nTotal: " + totalCost + "\nOpen?: " + open;
    }
    
    public void closeOrder()                                                    //closes an order by changing boolean variabe
    {
        open = false;
        System.out.println("Order " + this.orderNumber + " closed");
    }
    
    public boolean isOpen()                         
    {
        return open;
    }
}