/**
 * The Customer class represents a customer of the store.  A customer has access to a
 * statement.
 *
 * Based on Fowler's example in Refactoring Chapter 1
 **/
 class Customer {

 	final String name
 	List rentals = []

 	/**
 	 * Return a new instance of Customer with the given name
 	 **/
 	Customer(String name){
 		this.name = name
 	}

 	/**
 	 * Add the given rental to this Customer's rentals list
 	 **/
 	void addRental(Rental rental){
 		rentals.add(rental)
 	}

 	/**
 	 * Return a statement for this Customer
 	 **/
	String statement() { 
		double totalAmount = 0
		int frequentRenterPoints = 0

		String result = "Rental Record for ${getName()}\n"

		rentals.each { 
			// add frequent renter points
			frequentRenterPoints ++
			// add bonus for a two day new release rental
			if ((it.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
				it.getDaysRented() > 1) 
				frequentRenterPoints ++

			//show figures for this rental
			result += "\t${it.getMovie().getTitle()}\t${String.valueOf(it.getCharge())}\n" 
			totalAmount += it.getCharge()
		}

		//add footer lines
		result += "Amount owed is ${String.valueOf(totalAmount)}\n"
		result += "You earned ${String.valueOf(frequentRenterPoints)} frequent renter points"
		result
	}
 }