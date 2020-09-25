package mmn11;

public class Date {

	// variables

	private int _day, _month, _year;

	// constructor

	public Date(int day, int month, int year) {
		// year
		if (year >= 1000 && year <= 9999 && month >= 1 && month <= 12 && day >= 1 && day <= 31) {
			_year = year;
			_month = month;
			switch (_month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				_day = day;
				break;
			case 2:
				if (day <= 28) {
					_day = day;
					break;
				}
				if (isLeap(_year) == true && day > 29) {
					_year = 2000;
					_month = 1;
					_day = 1;
					break;
				}
				if (isLeap(_year) != true && day > 28) {
					_year = 2000;
					_month = 1;
					_day = 1;
					break;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				if (day <= 30) {
					_day = day;
					break;
				} else {
					_day = 1;
					_month = 1;
					_year = 2000;
					break;
				}
			default:
				_day = 1;
				_month = 1;
				_year = 200;
			}// E switch
		} // E if

		else {
			_day = 1;
			_month = 1;
			_year = 2000;
		}

	}// end constructor

	public Date(Date other) {
		_day = other._day;
		_month = other._month;
		_year = other._year;
	} // end constructors

	// getters & setters

	public int getDay() {
		return _day;
	}

	public void setDay(int dayToSet) {
		if (dayToSet >= 1 && dayToSet <= 31) {
			this._day = dayToSet;
		}
	}

	public int getMonth() {
		return _month;
	}

	public void setMonth(int monthToSet) {
		if (monthToSet >= 1 && monthToSet <= 12)
			this._month = monthToSet;
		else
			; // ; = pass
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int yearToSet) {
		if (yearToSet > 999 && yearToSet < 10000)
			this._year = yearToSet;
		else
			; // ; = pass

	}

	// methods

	// This method checks if the dates are equals
	public boolean equals(Date other) {
		if (_day == other._day && _month == other._month && _year == other._year)
			return true;
		else
			return false;
	}

	// This method checks if this date is after other date
	public boolean before(Date other) {
		if (getYear() < other._year)
			return true;
		if (getYear() == other._year && getMonth() < other._month)
			return true;
		if (getYear() == other._year && getMonth() == other._month && getDay() < other._day)
			return true;
		else
			return false;

	}

	// This method checks if this date is before other date
	public boolean after(Date other) {
		if (before(other) == true) {
			return false;
		} else
			return true;
	}

	// This method print the date
	public String toString() {
		final String zero = "0";
		if (getDay() > 9 && getMonth() < 10)
			return getDay() + "/" + zero + getMonth() + "/" + getYear();
		if (getDay() < 10 && getMonth() > 9)
			return zero + getDay() + "/" + getMonth() + "/" + getYear();
		if (getDay() < 10 && getMonth() < 10)
			return zero + getDay() + "/" + zero + getMonth() + "/" + getYear();
		else
			return getDay() + "/" + getMonth() + "/" + getYear();
	}


	// This method check if current year its leap year
	private boolean isLeap(int year) {
		if (year % 4 != 0) {
			return false;
		} else if (year % 400 == 0) {
			return true;
		} else if (year % 100 == 0) {
			return false;
		} else {
			return true;
		}
	}

	// this method returns the difference between two dates
	public int difference(Date other) {
		// variables
		final double dayinyear = 365.242199;
		int difference;
		int dif_year;
		int dif_month_and_day;
		int other_day_month = getdaysinmonth(other.getYear(), other.getMonth())+other.getDay();
		int day_month = getdaysinmonth(getYear(), getMonth())+getDay();
		System.out.println(other_day_month +" :other_day_month ");
		System.out.println(day_month +" :day_month");
		// calculate year difference
		if(getYear() == other.getYear())
			dif_year=(int)((getYear()-other.getYear())*dayinyear);
		else
			dif_year=(int)((getYear()-other.getYear()-1)*dayinyear);	
		if(dif_year <0 ) 
			dif_year=dif_year*(-1);
		//calculate month+day
		dif_month_and_day=other_day_month-day_month;
		if (dif_month_and_day <0)
			dif_month_and_day=dif_month_and_day*(-1);
		//calculate all
		difference=dif_month_and_day+dif_year;
		return difference;
	}// end method

	// this method returns the following day
	public Date tomorrow() {
		// variables
		int new_y = 0, new_m = 0, new_d = 0;

		int leap_year_dayin_month[] = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int year_dayin_month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		switch (getMonth()) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
			if (getDay() >= 31) {
				new_y = getYear();
				new_m = (getMonth() + 1);
				new_d = 1;
				break;
			} else {
				new_y = getYear();
				new_m = getMonth();
				new_d = (getDay() + 1);
				break;
			}
		case 2:
			if ((isLeap(getYear()) == true && getDay() >= 29) || (isLeap(getYear()) == false && getDay() >= 28)) {
				new_y = getYear();
				new_m = (getMonth() + 1);
				new_d = 1;
				break;
			} else {
				new_y = getYear();
				new_m = getMonth();
				new_d = (getDay() + 1);
				break;
			}
		case 4:
		case 6:
		case 9:
		case 11:
			if (getDay() >= 30) {
				new_y = getYear();
				new_m = (getMonth() + 1);
				new_d = 1;
				break;
			} else {
				new_y = getYear();
				new_m = getMonth();
				new_d = (getDay() + 1);
				break;
			}
		case 12 :
			if(getDay() >=31) {
				new_y=(getYear()+1);
				new_m=1;
				new_d=1;
					break;           
			}
			else {
				new_y=getYear();
				new_m=getMonth();
				new_d=(getDay()+1);
			}

		} // end switch

		Date newdate = new Date(new_d, new_m, new_y);
		return newdate;
	}// end method

	// this method return the amount of day from the start of the year
	private int getdaysinmonth(int year, int month) {
		int val = 0;
		int leap_year_dayin_month[] = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int year_dayin_month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeap(year) == true) {
			for (int i = 0; i < month; i++) {
				val += leap_year_dayin_month[i];
			}
			return val + getDay();
		} else {
			for (int i = 0; i < month; i++) {
				val += year_dayin_month[i];
			}
			return val + getDay();
		}
	}// end method
	
	
	

}// end class
