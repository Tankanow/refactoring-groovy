/**
 * A simple POGO for a Movie 
 *
 * Based on Fowler's example in Refactoring Chapter 1
 **/
class Movie {

	static final int REGULAR     = 0
	static final int NEW_RELEASE = 1
	static final int CHILDRENS   = 2

	final String title
	int priceCode

	/**
	 * Return a new instance of Movie with the given title and priceCode
	 **/
	Movie(String title, int priceCode){
		this.title = title
		this.priceCode = priceCode
	}

	/**
	 * Get the charge for this movie for the given number of daysRented
	 **/
	double getCharge(int daysRented){

		double result = 0;
		//determine amounts for each line
		switch (priceCode) {
			case Movie.REGULAR: 
				result += 2
				if (daysRented > 2)
					result += (daysRented - 2) * 1.5
				break
			case Movie.NEW_RELEASE:
				result += daysRented * 3
				break
			case Movie.CHILDRENS:
				result += 1.5
				if (daysRented > 3)
					result += (daysRented - 3) * 1.5 
				break
		}

		return result;
	}

	/**
	 * Get the frequent renter points for this movie for the given number of daysRented
	 **/
	int getFrequentRenterPoints(int daysRented){
		// add bonus for a two day new release rental
		if ((priceCode == Movie.NEW_RELEASE) &&
			daysRented > 1) {
			return 2
		}

		return 1
	}
}