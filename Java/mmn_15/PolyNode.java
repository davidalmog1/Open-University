
/*
 * need to import IntNode class 
 */

public class PolyNode {

	// variables
	private int power;
	private double coefficient;
	private PolyNode next;

	// constructors
	// set next to null
	public PolyNode(int power, double coefficient) {
		next = null;
		if (power < 0) {
			power = 0;
			coefficient = 0;
		} else {
			this.power = power;
			this.coefficient = coefficient;
		}
	}

	// gets all the values
	public PolyNode(int power, double coefficient, PolyNode next) {
		this.next = next;
		if (power < 0) {
			power = 0;
			coefficient = 0;
		} else {
			this.power = power;
			this.coefficient = coefficient;
		}
	}

	// copy constructor
	public PolyNode(PolyNode p) {
		this.next = p.next;
		this.power = p.power;
		this.coefficient = p.coefficient;
	}

	// getters & setters
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if (power > 0)
			this.power = power;
		else
			;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public PolyNode getNext() {
		return next;
	}

	public void setNext(PolyNode next) {
		this.next = next;
	}

	// methods
	public String toString() {
		String s;
		// c = 0
		if (coefficient == 0)
			return s = " ";
		// p = 0
		if (power == 0)
			return s = "" + (int) coefficient;
		// c == 1/-1
		if ((coefficient == 1 || coefficient == -1) && power > 1) {
			if (coefficient == 1)
				return s = "x^" + power;
			else {
				if (power % 2 == 0)
					return s = "-x^" + power;
				else
					return s = "-x^" + power;
			}
		}
		// p = 0
		if (power == 0)
			return s = "" + coefficient;
		// p = 1 + if ( c = 1/-1 )
		if (power == 1) {
			if (coefficient != 1 && coefficient != -1) {
				return s = "" + coefficient + "x";
			} else {
				if (coefficient == 1)
					return s = "x";
				else
					return s = "-x";
			}
		}
		return s = "" + coefficient + "x^" + power;
	}


}// end class
