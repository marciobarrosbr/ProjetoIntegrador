package inventory;
import java.util.InputMismatchException;
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
		int maxSize = -1;
		
		//display prompt to user
		do {
			try {
				System.out.println("Enter the number of products you would like to add: ");
				System.out.println("Enter 0 (zero) if you do not wish to add products: ");
				//prompt the user until they enter a numberr >= zero
				maxSize = in.nextInt();
				if(maxSize<0) {
					System.out.println("Incorrect Value entered");
				}//end if
			}
			catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("Incorrect data type entered!");
				in.nextLine();
			}
			catch(Exception e) {
				System.out.println(e);
				in.nextLine();
			}
		}while(maxSize<0);
		in.nextLine();
		//create a array if maxSize number >0
		if(maxSize==0) {
			//Display a no products message if zero entered
			System.out.println("No products required!");
		}else {
			Product[] products = new Product[maxSize];
			for(int i=0; i<products.length; i++) {
				//ask the user to enter product information
				
				System.out.println("\n\nPlease enter the item number: ");
				tempNumber = in.nextInt();
				System.out.println("\n\nPlease enter the product name: ");
				tempName = in.next();
				System.out.println("\n\nPlease enter the quantity of stock this product: ");
				tempQty = in.nextInt();
				System.out.println("\n\nPlease enter the price for this product: ");
				tempPrice = in.nextDouble();
				//create a product object and store it in the products array
				products[i] = new Product(tempNumber, tempName, tempQty, tempPrice);
				in.nextLine();
			}//end for
			//display the content of the products array
			for(Product product: products) {
				System.out.println(product);
			}//end for to print products
		}//end if else			
	}//end method main	
}//end class PruductTester
