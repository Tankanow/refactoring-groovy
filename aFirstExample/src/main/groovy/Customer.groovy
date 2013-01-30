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

		String result = "Rental Record for ${getName()}\n"

		rentals.each { 
			result += "\t${it.getMovie().getTitle()}\t${String.valueOf(it.getCharge())}\n" 
		}

		//add footer lines
		result += "Amount owed is ${String.valueOf(getTotalCharge())}\n"
		result += "You earned ${String.valueOf(getTotalFrequentRenterPoints())} frequent renter points"
	}


	/**
	 * Get the total charge for this customer
	 **/ 
	public double getTotalCharge(){

		rentals.inject(0) { acc, aRental ->
			acc + aRental.getCharge()
		}

	}

	/**
	 * Get the total frequent renter points for this customer
	 **/
	public int getTotalFrequentRenterPoints(){

		rentals.inject(0) { acc, aRental ->
			acc + aRental.getFrequentRenterPoints()
		}

	}	
 }