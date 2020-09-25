package mmn11;

public class FoodItem {

	// variables
	private final String name;
	private final long catalogueNumber; // only+
	private int quantity; // only+
	private Date productionDate;
	private Date expiryDate;
	private final int minTemperature;
	private final int maxTemperature;
	private int price; // only+

	// constructors
	public FoodItem(String name, long catalogueNumber, int quantity, Date productionDate, Date expiryDate,
			int minTemperature, int maxTemperature, int price) {

		// quantity
		if (quantity < 0)
			this.quantity = 0;
		else
			this.quantity = quantity;

		// name
		if (name.equals(" "))
			this.name = "item";
		else
			this.name = name;

		// catalogueNumber
		if (catalogueNumber < 1000)
			this.catalogueNumber = 9999;
		else
			this.catalogueNumber = catalogueNumber;

		// productionDate + expiryDate
		if (expiryDate.before(productionDate))
			get_date_and_copyiit(productionDate.tomorrow());
		else {
			this.expiryDate = expiryDate;
			this.productionDate = productionDate;
		}

		// Temperature
		if (minTemperature > maxTemperature) {
			int temp = minTemperature;
			minTemperature = maxTemperature;
			maxTemperature = temp;
		}
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
		// price
		if (price < 0)
			this.price = 1;
		else
			this.price = price;

	}// End constructor

// copy constructor
	public FoodItem(FoodItem other) {
		this.price=other.price;
		this.quantity=other.quantity;
		this.expiryDate=other.expiryDate;
		this.productionDate=other.productionDate;
		this.catalogueNumber=other.getCatalogueNumber();
		this.minTemperature=other.getMinTemperature();
		this.maxTemperature=other.getMaxTemperature();
		this.name=other.getName();
	}
	
	
	
//Quantity
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity < 0)
			this.quantity=0;
		else
			this.quantity = quantity;
	}
//date production
	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		if (expiryDate.before(productionDate))
			; //like pass
		else {
			this.expiryDate = expiryDate;
			this.productionDate = productionDate;
		}
	}
//date expirydate
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		if (expiryDate.before(productionDate))
			; //like pass
		else {
			this.expiryDate = expiryDate;
			this.productionDate = productionDate;
		}
	}
//price
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0)
			this.price=1;
		else
			this.price = price;
	}
//name
	public String getName() {
		return name;
	}
//CatalogueNumber
	public long getCatalogueNumber() {
		return catalogueNumber;
	}
//min tempertaure
	public int getMinTemperature() {
		return minTemperature;
	}
//max tempertaure
	public int getMaxTemperature() {
		return maxTemperature;
	}

	
	
// methods

	private void get_date_and_copyiit(Date a) {

		expiryDate.setDay(a.getDay());
		expiryDate.setMonth(a.getMonth());
		expiryDate.setYear(a.getYear());

	}
	
//this method check if two FoodItems are equals	
	public boolean equals(FoodItem other) {
	if(this.name == other.getName() && this.catalogueNumber == other.getCatalogueNumber()
	 &&	this.price==other.getPrice() && this.expiryDate ==other.getExpiryDate() 
	 && this.productionDate ==other.getProductionDate() && this.quantity==other.getQuantity()
	 && this.minTemperature==other.getMinTemperature() && this.maxTemperature==other.getMaxTemperature())
	return true;
	else 
		return false;
	}
	
//this method check if the product is fresh
	public boolean isFresh(Date d) {
		
		if(productionDate.before(d) && d.before(expiryDate))
			return true;
		else
			return false;
	}

// print to the screen the values 
	public String toString() {
	return "name : "+name+"\n"+"catalogueNamber : "+catalogueNumber+"\n"+"Quantity : "+quantity
		+"\n"+"Production Date : "+productionDate+"\n"+"expiry Date : "+expiryDate
		+"\n"+"Min Temperature : "+minTemperature+"\n"+"Max Temperature : "+maxTemperature
		+"\n"+"Price : "+price;
	}
	
// this method checks how created before
	public boolean olderFoodItem(FoodItem other) {
		
		if (productionDate.before(other.productionDate))
			return true;
		else
			return false;
	}
	
//this method say how many Items gets this amount
	public int howManyItems(int amount) {
		if(amount <price)
			return 0;
		else {
			int a =(amount/price);
			if(a >= quantity)
				return quantity;
			else
				return a;
		}
	}

//this method say how is cheaper
	public boolean isCheaper(FoodItem other) {
		if(price < other.getPrice())
			return true;
		else
			return false;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}// end class
