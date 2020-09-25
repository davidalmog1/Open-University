package mmn11;

public class Stock {

	// variables

	private FoodItem[] _stock;
	private int _noOfItems;
	private final int max = 100;

	// constructor

	public Stock() {
		_stock = new FoodItem[max];
	}

	// getters & setters

	public FoodItem[] get_stock() {
		return _stock;
	}

	public void set_stock(FoodItem[] _stock) {
		this._stock = _stock;
	}

	public int get_noOfItems() {
		return _noOfItems;
	}

	public void set_noOfItems(int _noOfItems) {
		this._noOfItems = _noOfItems;
	}

	public int getMax() {
		return max;
	}

	// methods

	public boolean addItem(FoodItem newItem) {
		// if the array is empty
		if (get_noOfItems() == 0) {
			_stock[0] = new FoodItem(newItem);
			set_noOfItems(get_noOfItems() + 1);
			return true;
		}
		// if it's possible to add new item or not
		if (get_noOfItems() > 98)
			return false;
		for (int i = 0; i < get_noOfItems() - 1; i++) {
			String s_name = _stock[i].getName();
			// if the new item is already exist or partly exist
			// the first (if) is a quick check.
			if (newItem.getName().equals(s_name)
					&& newItem.getCatalogueNumber() == get_stock()[i].getCatalogueNumber()) {
				// the second (if) check if the new item equals one of the items in the array
				// list
				if (newItem.getExpiryDate().equals(get_stock()[i].getExpiryDate())
						&& newItem.getProductionDate().equals(get_stock()[i].getProductionDate())) {
					_stock[i].setQuantity(newItem.getQuantity() + _stock[i].getQuantity());
					return true;
				}

				else {
					chenge_position(i, newItem);
					set_noOfItems(get_noOfItems() + 1);
					return true;
				}
			} else
				continue;
		}
		_stock[get_noOfItems()] = new FoodItem(newItem);
		set_noOfItems(get_noOfItems() + 1);
		return true;
	}// end

	// this methods return the number of items in the array
	public int getNumOfItems() {
		return get_noOfItems();
	}

	// this methods return list of items that need to be order
	public String order(int amount) {
		String order = "";
		for (int i = 0; i < get_noOfItems(); i++) {
			if (_stock[i] == null)
				break;
			else {
				int qunt = quantity_from_item(_stock[i]);
				if (qunt < amount)
					order = order + _stock[i].getName() + ",";
				else
					continue;
			}
		}
		return order;
	}

	// this method items can be in some temperature
	public int howMany(int temp) {
		int num = 0;
		for (int i = 0; i < get_noOfItems(); i++) {
			if (_stock[i].getMinTemperature() < temp && temp < _stock[i].getMaxTemperature())
				num += +_stock[i].getQuantity();
		}
		return num;
	}

	// this method get date an delete all the items that the ExpiryDate is before
	public void removeAfterDate(Date d) {
		for (int i = 0; i < get_noOfItems(); i++) {
			System.out.println("\n" + "< " + i + " >" + "\n");
			if (_stock[i].getExpiryDate().before(d)) {
				del(i);
			} else
				continue;
		}
		System.out.println("\n" + "< " + "END" + " >" + "\n");
	}

	public String toString(int i) {
		if (_noOfItems > 0) {
			return ("FoodItem " + _stock[i].getName() + "  Catalougue num:" + _stock[i].getCatalogueNumber()
					+ "  ProductionDate: " + _stock[i].getProductionDate() + "  ExpiryDate: "
					+ _stock[i].getExpiryDate() + "   Quantity: " + _stock[i].getQuantity());
		}
		return "null";
	}

	// this method return the most expensive item in the stock
	public FoodItem mostExpensive() {
		int index = 0;
		int most = _stock[0].getPrice();
		for (int i = 1; i < get_noOfItems(); i++) {
			if (_stock[i].getPrice() > most) {
				most = _stock[i].getPrice();
				index = i;
			} else
				continue;
		}
		return _stock[index];
	}

	// this method return the number of items in the stock
	public int howManyPieces() {
		int count = 0;
		for (int i = 0; i < get_noOfItems(); i++) {
			count += _stock[i].getQuantity();
		}
		return count;
	}

	// this method get list of items that need to be reduced from Quantity
	public void updateStock(String[] itemsList) {
		for (int i = 0; i < itemsList.length; i++) {
			for (int x = 0; x < get_noOfItems(); x++) {
				String name = _stock[i].getName();
				if (itemsList[i].equals(name)) {
					_stock[i].setQuantity(_stock[i].getQuantity() - 1);
					break;
				} else
					continue;
			}
		}
	}

/**
 * 
 *  -----------------------------------------my methods------------------------------------
 *  
**/
	// this method check if the foodItem already exists
	private int exists(FoodItem a) {
		for (int i = 0; i < getNumOfItems() - 1; i++) {
			if (_stock[i].equals(a)) {
				return i;
			} else
				continue;
		}
		return -1;
	}

	// this method change position of two items
	private void chenge_position(int location, FoodItem enter) {
		for (int i = get_noOfItems(); i > location; i--) {
			_stock[i] = _stock[i - 1];
		}
		_stock[location] = null;
		_stock[location] = enter;
	}

	// this method return all Quantity of item
	private int quantity_from_item(FoodItem item) {
		int count = item.getQuantity();
		for (int i = 0; i < get_noOfItems() - 1; i++) {
			if (_stock[i].getCatalogueNumber() == item.getCatalogueNumber()
					&& _stock[i].getExpiryDate().equals(item.getExpiryDate()) != true)
				count += _stock[i].getQuantity();
			else
				continue;
		}
		return count;
	}

	// this method delete the item in index = (location)
	private void del(int location) {
		if (location < 0)
			return;
		else {
			_stock[location] = null;
			close_holes();
			set_noOfItems(get_noOfItems() - 1);
		}
	}

	// this method Close holes in the array
	private void close_holes() {
		for (int i = 0; i < get_noOfItems(); i++) {
			if (_stock[i] == null) {
				for (int x = i; x < get_noOfItems(); x++) {
					_stock[x] = _stock[x + 1];
				}
			} else
				continue;
		}
	}

	// this method check if item (other) is equal to one of items in the array
	private int quic_check(FoodItem other) {
		for (int i = 0; i < get_noOfItems(); i++) {
			if (get_stock()[i].getName().equals(other.getName())
					&& get_stock()[i].getCatalogueNumber() == other.getCatalogueNumber())
				return i;
			else
				continue;
		}
		return -1;
	}

	
	
	
}// end class
