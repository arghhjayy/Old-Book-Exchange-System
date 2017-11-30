enum Condition{
	rough, poor, good, very_good, excellent, new_like
}

public class Book {
	
	private String id;
	private int number;
	private String name;
	private String author;
	private String edition;
	private int year;
	private int orig_price;
	private int price;
	
	//Have to add support for this
	private Condition condition;

	public Book(String id, int number, String name, String author, String edition, int year, int orig_price, int price) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.author = author;
		this.edition = edition;
		this.year = year;
		this.orig_price = orig_price;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getEdition() {
		return edition;
	}

	public int getYear() {
		return year;
	}

	public int getOrig_price() {
		return orig_price;
	}

	public int getPrice() {
		return price;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setOrig_price(int orig_price) {
		this.orig_price = orig_price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString()
	{
		return this.name + " by " + this.author;
	}
}