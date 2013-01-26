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
}