/**
 * The Rental class represents a Cusomter renting a Movie.
 * 
 * Based on Fowler's example in Refactoring Chapter 1
 **/
class Rental {

	final Movie movie
	final int daysRented

 	/**
 	 * Return a new instance of Rental with the given Movie and daysRented
 	 **/
	Rental(Movie movie, int daysRented){
		this.movie = movie
		this.daysRented = daysRented
	}


	/**
	 * Get the charge for this rental
	 **/
	double getCharge(){

		return movie.getCharge(daysRented);
	}

	/**
	 * Get the frequent renter points for this method
	 **/
	int getFrequentRenterPoints(){

		return movie.getFrequentRenterPoints(daysRented);
	}
}