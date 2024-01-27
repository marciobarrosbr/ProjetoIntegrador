package inventory;

public class CD extends Product {
	private String artist;
	private int numberOfSongs;
	private String label;
	
	public CD(int number, String name, int qty, double price, String artist, int numSongs, String label) {
		super(number, name, qty, price);
		this.artist = artist;
		this.numberOfSongs = numSongs;
		this.label = label;
	}//end constructor

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getNumberOfSongs() {
		return numberOfSongs;
	}

	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = numberOfSongs;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	public String toString()
	{
		return "\n\nItem Number: " + getItemNumber()
				+ "\nName: " + getName()
				+ "\nArtist: " + getArtist()
				+ "\nSong on Album: " + getNumberOfSongs()
				+ "\nRecord Label: " +getLabel()
				+ "\nQuantity in stock" + getQtyInStock()
				+ "\nPrice: " + getPrice()
				+ "\nStock Value: " +getInventoryValue()
				+ "\nProduct Status: " + (getActive()?"Active":"Dicontinued");
	}//end method toString	
}//end class DVD
