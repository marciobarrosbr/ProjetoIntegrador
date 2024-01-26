package inventory;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ProductTester {

	public static void main(String[] args) {
		// create a Scanner object for keyboard import
		Scanner in = new Scanner(System.in);
		//create local variables
		int maxSize, menuChoice;
		
		maxSize = getNumProduct(in);
		if(maxSize==0) {
			//Display a no product message if zero in entered
			System.out.println("No products required");
		}else {
			Product[] products = new Product[maxSize];
			addToInventory(products, in);  //method that puts all the products in the array
			do {
				menuChoice = getMenuOption(in);
				executeMenuChoice(menuChoice,products,in);
			}while(menuChoice!=0);
		}//end if		
	}//end method main
	
	public static int getMenuOption(Scanner in) {
		int MenuOption= -1;
		do {
			try {
				System.out.println("\n\n1. View Inventory\n2. AddStock\n3. Deduct Stock\n"
						+". Discontinue Product\n0. Exit");			
				MenuOption = in.nextInt();
				if(MenuOption <0 || MenuOption>4) {
					System.out.println("Please read the menu...");
				}//end if
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Incorrect data type entered!");
				in.next();  //clean the cache memory and proceed to next steps
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Erro encontrado\n");
				in.next(); //clean the cache memory and proceed to next steps
			}			
		}while(MenuOption<0 || MenuOption>4);
		//return the valid input from the user
		return MenuOption;
	}//end method static getMenuOption
	
	static void executeMenuChoice(int choice, Product[] products, Scanner in) {
		switch (choice) {
		case 1: System.out.println("View product List");
				displayInventory(products);	
			break;
		case 2: System.out.println("Add stock");
				addInventory(products, in);
			break;
		case 3: System.out.println("Deduct Stock");
				deductInventory(products, in);
			break;
		case 4:System.out.println("Discontinue Stock");
		discontinueInventory(products, in);
			break;
		default: 	System.out.println("Encerrando programa...");
			break;
		}//end switch
	}//end method executeMenuChoice
	
	static void discontinueInventory(Product[] products, Scanner in) {
		int productChoice;
		productChoice = getProductNumber(products, in);
		products[productChoice].setActive(false);
	}//end static method discontinueInventory
	
	public static void addInventory(Product[] products, Scanner in) 
	{
		int productChoice;
		int updateValue = -1;
		productChoice = getProductNumber(products, in);
		do {
			try {
				System.out.println("Hopw many products do you want to add? ");
				updateValue = in.nextInt();
				if(updateValue<0) {
					System.out.println("Please only positive values to add to stock");
				}//end if
			} catch (InputMismatchException e) {
				System.out.println("Incorrect data type intered");
				in.next();  //clean the cache memory and proceed to next steps
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Please entered a valid value");
				in.next();  //clean the cache memory and proceed to next steps
			}//end try catch
		}while(updateValue<0);
		products[productChoice].addToInvetory(updateValue);
	}//end method addInventory
	
	public static void deductInventory(Product[] products, Scanner in) 
	{
		int productChoice;
		int updateValue = -1;
		productChoice = getProductNumber(products, in);
		do {
			try {
				System.out.println("How many item do you want to deduct from stock: ");
				updateValue = in.nextInt();
				if(updateValue<0 || updateValue>products[productChoice].getQtyInStock()) {
					System.out.println("There is nor enough stock to remove that amount, only "+ (products[productChoice].getQtyInStock())+" left!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Incorrect data type intered");
				in.next();
			}catch(Exception e) {
				e.printStackTrace();
				in.next();
			}
		}while(updateValue<0 || productChoice>products[productChoice].getQtyInStock());
		products[productChoice].deductFromInventory(updateValue);
	}//end method static deductInventory
	
	public static int getProductNumber(Product[] products, Scanner in) {
		int productChoise = -1;
		for(int i=0; i<products.length; i++) {
			System.out.println(i +" : " + products[i].getName());
		}//end for
		do {
			try {
				System.out.println("Please enter the number of the product you want to update: ");
				productChoise = in.nextInt();
				if(productChoise<0 || productChoise>products.length -1) {
					System.out.println("Please only values between 0 and "+ (products.length-1));
				}//end if
			} catch (InputMismatchException e) {
				System.out.println("incorrect data type entered");
				in.next();
			}catch(Exception e) {
				System.out.println(e);
				in.next();
			}//end try catch		
		}while(productChoise<0 || productChoise>products.length-1);
		return productChoise;		
	}//end static method getProductNumber 
	
	
	
	//method that return 0 (zero) or any number of index of the array of products
	static int getNumProduct(Scanner in) {
		int maxSize = -1;
		do {
			try {
				//display prompt to user
				System.out.println("Enter the number of products you would like to add: ");
				System.out.println("Enter 0 (zero) if you do not wish to add products: ");
				//prompt the user until they enter a number >= zero
				maxSize = in.nextInt();
				if(maxSize<0) {
					System.out.println("Incorrect Value entered");
				}//end if
			}
			catch (InputMismatchException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("Incorrect data type entered!");
				in.nextLine();  //clean the cache memory and proceed to next steps
			}
			catch(Exception e) {
				System.out.println(e);
				in.nextLine();  //clean the cache memory and proceed to next steps
				//in.nextLine();
			}
		}while(maxSize<0);
		return maxSize;
	}//end static getNumproduct
	
	public static void addToInventory(Product[] products, Scanner in) {
		int tempNumber;
		String tempName;
		int tempQty;
		double tempPrice;
		do {
			try {
				for(int i=0; i<products.length; i++) {
					in.nextLine();
					//ask the user to enter product information
					System.out.println("\n\nPlease enter the item number: ");
					tempNumber = in.nextInt();
					System.out.println("\n\nPlease enter the product name: ");
					tempName = in.next();
					in.nextLine();
					System.out.println("\n\nPlease enter the quantity of stock this product: ");
					tempQty = in.nextInt();
					System.out.println("\n\nPlease enter the price for this product: ");
					tempPrice = in.nextDouble();
					//create a product object and store it in the products array
					products[i] = new Product(tempNumber, tempName, tempQty, tempPrice);
//					in.nextLine();
				}//end for with Scanner method				
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("Icorrect data type entered");
				in.nextLine();  //clean the cache memory and proceed to next step
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error. ivalid entry");
				in.nextLine();  //clean the cache memory and proceed to next step
			}//end method try catch
		}while(products[0]==null);
	}//end method static addToInventory
	
	public static void displayInventory(Product[] products) {
		//display the content of the products array
		for(Product index: products) {
			 System.out.print(index);
		}//end for to print products
	}//end static method displyaInventory
}//end class PruductTester
