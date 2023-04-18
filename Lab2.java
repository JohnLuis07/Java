package chickennuggets;
import java.util.Scanner;

public class Lab2{
    public static void main(String[] args) {
        System.out.println("Enter names of chicken: ");
        Scanner in = new Scanner(System.in);
        
        String chicken1 = in.nextLine();
        String chicken2 = in.nextLine();
        String chicken3 = in.nextLine();

        Chicken nugget1 = new Chicken(chicken1);
        Chicken nugget2 = new Chicken(chicken2);
        Chicken nugget3 = new Chicken(chicken3);
        
        System.out.println("Name of chicken: " + nugget2.chickenName + "\nChicken count: " + Chicken.chickenCount);
        System.out.println("Name of chicken: " + nugget1.chickenName + "\nChicken count: " + Chicken.chickenCount);
        System.out.println("Name of chicken: " + nugget3.chickenName + "\nChicken count: " + Chicken.chickenCount);
    }
}