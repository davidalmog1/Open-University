
/*
 * need to import the IntNode class
 */


public class Polynom {

	// variables
	private PolyNode head;

	// constructor
	public Polynom() {
		head = null;
	}

	public Polynom(PolyNode p) {
		head = p;
	}

	// getters & setters
	public PolyNode getHead() {
		return head;
	}

	public void setHead(PolyNode head) {
		this.head = head;
	}

	// methods

	/*
	 * this method add new node to an existing polynom
	 * @param ployNode
	 * @return Polynom
	 */
	public Polynom addNode(PolyNode p) {
		// head == null
		if (getHead() == null) {
			setHead(p);
			return this;
		}
		// variables
		PolyNode temp = getHead();
		// if p > temp or p == temp
		if ((p.getPower() > temp.getPower()) || (temp.getPower() == p.getPower())) {
			// p > temp
			if ((p.getPower() > temp.getPower())) {
				p.setNext(temp);
				setHead(p);
				return this;
			} // p == temp
			else
				head.setCoefficient(head.getCoefficient() + p.getCoefficient());
			return this;
		} else if (temp.getNext() == null) {
			head.setNext(p);
			return this;
		}
		// p < temp
		else {
			while (temp.getNext() != null) {
				if ((temp.getNext().getPower() < p.getPower()) || (temp.getNext().getPower() == p.getPower())) {
					// p > temp.next
					if (temp.getNext().getPower() < p.getPower()) {
						p.setNext(temp.getNext());
						temp.setNext(p);
						return this;
					} // p == temp.next
					else {
						temp.getNext().setCoefficient(temp.getNext().getCoefficient() + p.getCoefficient());
						return this;
					}
				} else
					temp = temp.getNext();
			}
			// if p < temp.endPoly
			temp.setNext(p);
			return this;
		}
	}

	/*
	 * this method multiplies the poly by a given number
	 * @param int
	 * @return Polynom
	 */
	public Polynom multByScalar(int num) {
		if (getHead() == null) {
			System.out.println("\n" + "head is null !" + "\n");
			return this;
		}
		// variables
		PolyNode temp = getHead();
	
		while (temp != null) {
			temp.setCoefficient(temp.getCoefficient() * num);
			temp = temp.getNext();
		}
		return this;
	}

	/*
	 * this program adding new poly to the exist poly.
	 * @param Polynom
	 * @return Polynom 
	 */
	public Polynom addPol(Polynom other) {
		// head = null
		if(head == null) {
			setHead(other.getHead());
			return this;
		}
		//variables 
		PolyNode tempother = new PolyNode(other.head);
		return addPol_option_B(tempother);
	}
	// private method
	private Polynom addPol_option_B(PolyNode other) {
		if(other.getNext() == null) {
			addNode(other);
			return this ;
		}
		PolyNode a  = new PolyNode(other.getPower(),other.getCoefficient());
		addNode(a);
		return addPol_option_B(other.getNext());
	}
	
	/* 
	 *this method multiplay the given poly by the current poly
	 *@param Polynom 
	 *@return Polynom
	 */
	public Polynom multPol (Polynom other) {
		if(head == null)
			return null;
		//variables
		PolyNode y = new PolyNode(head); // current 
		PolyNode x = new PolyNode(other.head); //given poly
		while( y != null) {
			while(x != null) {
				if(x.getNext() == null) {
					y.setPower(y.getPower() + x.getPower());
					y.setCoefficient(y.getCoefficient() * x.getCoefficient());
					y = y.getNext();
				}
				PolyNode temp = new PolyNode(x.getPower()+y.getPower(),x.getCoefficient() * y.getCoefficient(),null);
				addNode(temp);
				x = x.getNext();
			}
		}
		return this;
	}
	
	/*
	 * this method calculates the derivative of the 
	 * a polynom on which it is applied and returns the derivative poly.
	 * @return Polynom
	 */
	public Polynom differential() {
		// head = null
		if(head == null)
			return this;
		//variables
		PolyNode temp = new PolyNode(head);
		// head.getPower > 0 
		if(temp.getPower() > 0) 
		return differential(temp);
		// head.getPower = 0
		else {
			setHead(null);
			return this;
		}
		//private method
	}
	private Polynom differential(PolyNode temp) {
		// if we got to the end of the polynum
		if(temp == null) {
			head.setCoefficient(head.getCoefficient() * head.getPower());
			head.setPower(head.getPower() - 1);
			return this;
		}
		// if temp(power) > 0
		if(temp.getPower() > 0) {
			temp.setCoefficient(temp.getCoefficient() * temp.getPower());
			temp.setPower(temp.getPower()-1);
			return differential(temp.getNext());
		}
		// if temp(power) = 0
		else {
			PolyNode to_remove = new PolyNode(temp);
			temp = temp.getNext();
			removeNode(to_remove);
			return differential(temp);
		}
	}
	
	/*
	 * this method get an Node to remvoe 
	 *@param rm = the element to remove
	 *@return polynom 
	 */
	private Polynom removeNode(PolyNode rm) {
		if(head == null)
				return this;
		PolyNode temp = new PolyNode(head);
		if( rm.equals(temp)) {	
		temp = temp.getNext();
		setHead(temp);
		return this;
		}
		else {
			while( temp.getNext() != rm)
				temp = temp.getNext();
		}
		if(rm.getNext() != null)
		temp.setNext(rm.getNext());
		else
			temp.setNext(null);
		return this;
	}
	
	/*
	 * this method Print the polynum
	 * @return String
	 */
	public String toString() {
		if (getHead() == null) {
			return " empty ";
		}
		// variables
		String returning = "r = ";
		PolyNode temp = new PolyNode(getHead());
		returning += temp.toString();
		temp = temp.getNext();
		while (temp != null) {
			if (temp.getCoefficient() > 0)
				returning += " + " + temp.toString();
			else
				returning += " " + temp.toString();
			temp = temp.getNext();
		}
		return returning;
	}

}// end class
