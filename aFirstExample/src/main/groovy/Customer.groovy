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
			result += "\t${it.getMovie().getTitle()}\t${it.getCharge()}\n" 
		}

		//add footer lines
		result += "Amount owed is ${getTotalCharge()}\n"
		result += "You earned ${getTotalFrequentRenterPoints()} frequent renter points"
	}


	String htmlStatement(){

		String result = "<H1>Rentals for <EM>${getName()}</EM></H1><P>\n"

		rentals.each {
			//show figures for each rental
			result += "${it.getMovie().getTitle()}: ${it.getCharge()}<BR>\n"
		}

		//add footer lines
		result += "<P>You owe <EM>${getTotalCharge()}</EM><P>\n"
		result += "On this rental you earned <EM>${getTotalFrequentRenterPoints()}</EM> frequent renter points<P>"
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