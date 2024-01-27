package inventory;

public class DVD extends Product{
	private int length;
	private int ageRating;
	private String filmStudio;
	
	public DVD(int number,String name, int qty, double price, int length, int rating, String studio) {
		super(number, name, qty, price);
		this.length = length;
		this.ageRating = rating;
		this.filmStudio = studio;
	}//end constructor

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}

	public String getFilmStudio() {
		return filmStudio;
	}

	public void setFilmStudio(String filmStudio) {
		this.filmStudio = filmStudio;
	}
	
	//get total value of inventory for this DVD Product
	//which includes 5% restocking fee
	public double getIventoryValue() 
	{
		return (1.05* (super.getPrice() * super.getQtyInStock()));		
	}//end method getInvetoryValue
	
	
	//override toString() Method from the Product class
	//allow display of each DVD object ti the console
	public String toString()
	{
		return "\n\nItem Number: " + getItemNumber()
				+ "\nName: " + getName()
				+ "\nMovie length: " + getLength()
				+ "\nAge Rating: " + getAgeRating()
				+ "\nFilm Studio: " +getFilmStudio()
				+ "\nQuantity in stock: " + getQtyInStock()
				+ "\nPrice: " + getPrice()
				+ "\nStock Value: " + getInventoryValue()
				+ "\nProduct Status: " + (getActive()?"Active":"Dicontinued");
	}//end method toString
}
