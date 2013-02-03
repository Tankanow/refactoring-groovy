/**
 * A simple POGO for a Movie 
 *
 * Based on Fowler's example in Refactoring Chapter 1
 **/
class Movie {

	final String title
	final PricingStrategy pricingStrategy

	/**
	 * Return a new instance of Movie with the given title and priceCode
	 **/
	Movie(String title, PricingStrategy pricingStrategy){
		this.title = title
		this.pricingStrategy = pricingStrategy
	}

	/**
	 * Get the charge for this movie for the given number of daysRented
	 **/
	double getCharge(int daysRented){

		return pricingStrategy.getCharge(daysRented)
	}

	/**
	 * Get the frequent renter points for this movie for the given number of daysRented
	 **/
	int getFrequentRenterPoints(int daysRented){

		return pricingStrategy.getFrequentRenterPoints(daysRented)
	}
}