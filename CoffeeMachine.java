/* CoffeeMachine
 * Program that lets the user experience to buy coffee in a machine.
 * John Luis F. Magtoto
 */
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //let me use the other class
        coffee cof = new coffee();
        while(true) {
            System.out.println("Welcome to coffee machine!");
            System.out.println("What would you like? (expresso/latte/cappucino):");
            String kape = cof.scan.nextLine();
            System.out.println();
            //lets you choose type of coffee or the caller of the methods in the other class
            if(kape.equalsIgnoreCase("expresso")) {
                System.out.println("The drink cost $3");
                System.out.println("Please insert payment.");
                float payment = cof.payment(scan, 3);
                if(payment >= 3) {
                    System.out.println("Change: $" + String.format("%.02f", (payment - 3.00f)));
                    cof.expresso();
                    cof.GetIngredient();
                } else {
                    System.out.println("Insuficient amount of money to buy this coffee.\n");
                }
            } else if (kape.equalsIgnoreCase("latte")) {
                System.out.println("The drink cost $4");
                System.out.println("Please insert payment.");
                float payment = cof.payment(scan, 4);
                if(payment >= 4) {
                    System.out.println("Change: $" + String.format("%.02f", (payment - 4.00f)));
                    cof.latte();
                    cof.GetIngredient();
                } else {
                    System.out.println("Insuficient amount of money to buy this coffee.\n");
                }
            } else if (kape.equalsIgnoreCase("capuccino")) {
                System.out.println("The drink cost $2");
                System.out.println("Please insert payment.");
                float payment = cof.payment(scan, 2);
                if(payment >= 2) {
                    System.out.println("Change: $" + String.format("%.02f", (payment - 2.00f)));
                    cof.cappucino();
                    cof.GetIngredient();
                } else {
                    System.out.println("Insuficient amount of money to buy this coffee.\n");
                }
            } else if(kape.equalsIgnoreCase("report")) {    //displays the status of the ingredients
                cof.GetIngredient();
            } else if(kape.equalsIgnoreCase("off")) {       //shuts off the coffee machine
                System.out.println("Shutting down....");
                break;
            } else {
                System.out.println("Invalid Input Please choose only from the three (expresso/latte/Capuccino).\n");
                continue;
            }
        }
    }
}
//where methods created
class coffee {

    public Scanner scan = new Scanner(System.in);
    public int water, milk, beans;
    public float money;

        //declare the initial value of the ingredients
        public coffee() {
            this.water = 1000;
            this.milk = 1000;
            this.beans = 500;
            this.money = 0;
        }
    //method for expresso coffee
    public void expresso() {
        if(this.beans >= 100 && this.milk >= 20 && this.water >= 100){
            System.out.println("\nMaking Expresso...");
            System.out.println("\nTaking 100ml of beans.");
            this.beans -= 100;
            System.out.println("Taking 20ml Liter of Milk.");
            this.milk -= 20;
            System.out.println("Taking 100ml of Water.");
            this.water -= 100;
            System.out.println("\nYour Expresso is Ready.");
            this.money += 3;
        } else{
            System.out.println("\nAvailable Coffee Power (Gram): "+ this.beans);
            System.out.println("Available Milk (Liter): " + this.milk);
            System.out.println("Available Water (Liter): "+ this.water);
            System.out.println("\nSorry some of the ingredients are not available, please refill before making another coffee.");
        }
    }
    //method for latte coffee
    public void latte() {
        if(this.beans >= 90 && this.milk >= 50 && this.water >= 50){
            System.out.println("\nMaking Latte...");
            System.out.println("\nTaking 90g of beans.");
            this.beans -= 90;
            System.out.println("Taking 50ml Liter of Milk.");
            this.milk -= 50;
            System.out.println("Taking 110ml of Water.");
            this.water -= 110;
            System.out.println("\nYour Latte is Ready.");
            this.money += 4;
        } else{
            System.out.println("\nAvailable Coffee Power (Gram): "+ this.beans);
            System.out.println("Available Milk (Liter): " + this.milk);
            System.out.println("Available Water (Liter): "+ this.water);
            System.out.println("\nSorry some of the ingredients are not available, please refill before making another coffee.");
        }
    }
    //method for latte coffee
    public void cappucino() {
        if(this.beans >= 90 && this.milk >= 50 && this.water >= 50){
            System.out.println("\nMaking Cappucino...");
            System.out.println("\nTaking 80g of beans.");
            this.beans -= 80;
            System.out.println("Taking 60ml Liter of Milk.");
            this.milk -= 60;
            System.out.println("Taking 110ml of Water.");
            this.water -= 110;
            System.out.println("\nYour Cappucino is Ready.");
            this.money += 2;
        } else{
            System.out.println("\nAvailable Coffee Power(Gram) "+ this.beans);
            System.out.println("Available Milk(Liter) " + this.milk);
            System.out.println("Available Water(Liter) "+ this.water);
            System.out.println("\nSorry some of the ingredients are not available, please refill before making another coffee.");
        }
    }
    //displays the status of the ingredients or the report
    public void GetIngredient() {   
        System.out.println("Available Coffee Power (Grams): "+ this.beans + "g");
        System.out.println("Available Milk (ml): "+ this.milk + "ml");
        System.out.println("Available Water (ml): "+ this.water + "ml");
        System.out.println("Available Money ($): $" + this.money + "\n");
    } 

    //examines the payments and the change.
    public static float payment(Scanner scanner, double price) {
        float quarters = getNumberOfCoins(scanner, "quarters");
        float dimes = getNumberOfCoins(scanner, "dimes");
        float nickles = getNumberOfCoins(scanner, "nickles");
        float pennies = getNumberOfCoins(scanner, "pennies");
        float total = (quarters * 0.25f) + (dimes * 0.1f) + (nickles * 0.05f) + (pennies * 0.01f);
        System.out.println();
        System.out.println("You entered: $" + String.format("%.02f", total) + ".");
        return total;
    }   
    //handle the erroneous inputs in the coins
    public static float getNumberOfCoins(Scanner scan, String cof) {
        while(true) {
            System.out.print("Insert number of " + cof + ": ");
            try {
                float amT = Float.parseFloat(scan.nextLine());
                if (amT < 0) {
                    continue;
                }
                return amT;
            } catch (NumberFormatException NFE) {
                System.out.println("\nInvalid Input please enter only numbers:");
                continue;
            }
        }
    }
}