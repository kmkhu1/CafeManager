import java.util.InputMismatchException;
public class Driver
{
    public static void main(String[] args)
    {
        try
        {
            CafeManager manager = new CafeManager();
            MenuSystem cafe = new MenuSystem(manager);
            cafe.displayMenu();
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Please eneter only the numbers allowed as indicated by by the menu. Program is now stopped");
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please only enter words when appropriate, otherwise only enter numbers. Program is now stopped");
        }
    }
}