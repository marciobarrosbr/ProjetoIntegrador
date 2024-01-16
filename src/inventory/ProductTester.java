package inventory;
import java.util.Scanner;
public class ProductTester {

	public static void main(String[] args) {
		// create a Scanner object for keyboard import
		Scanner in = new Scanner(System.in);
		//create local variables
		int tempNumber;
		String tempName;
		int tempQty;
		double tempPrice;
		
		//ask the user to enter product information
		in.nextLine();
		System.out.println("\n\nPlease enter the item number: ");
		tempNumber = in.nextInt();
		System.out.println("\n\nPlease enter the product name: ");
		tempName = in.nextLine();
		System.out.println("\n\nPlease enter the quantity of stock this product: ");
		tempQty = in.nextInt();
		System.out.println("\n\nPlease enter the price for this product: ");
		tempPrice = in.nextDouble();
		
		
		
		Product p1 = new Product(tempNumber, tempName, tempQty, tempPrice);
		
		//ask the user to enter product information
		in.nextLine();
		System.out.println("\n\nPlease enter the item number: ");
		tempNumber = in.nextInt();
		System.out.println("\n\nPlease enter the product name: ");
		tempName = in.nextLine();
		System.out.println("\n\nPlease enter the quantity of stock this product: ");
		tempQty =in.nextInt();
		System.out.println("\n\nPlease enter the price for this product: ");
		tempPrice = in.nextDouble();
		in.close();
		//create two objects using the default constructor
		Product p2 = new Product(tempNumber, tempName, tempQty, tempPrice);
		
		//create four objects using values for the arguments
		//this will use the overloaded constructor
		Product p3 = new Product(3, "Hot shots", 75, 8.99);
		Product p4 = new Product(4, "Brothers In Arms", 200, 7.75);
		Product p5 = new Product(5, "Fantastic", 500, 9.50);
		Product p6 = new Product(6, "The Party album", 150, 4.00);
		
		//set the active field to false
		p6.setActive(false);
		//display the description of each object as outlined in the
		//toString() method
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		System.out.println(p6);
	}//end method main
	
	
	
}//end class PruductTester
