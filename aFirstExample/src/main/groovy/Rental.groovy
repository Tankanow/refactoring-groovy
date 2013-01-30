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
	 * Get the change for this rental
	 **/
	double getCharge(){

		double result = 0
		//determine amounts for each line
		switch (movie.getPriceCode()) {
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

		return result
	}
}