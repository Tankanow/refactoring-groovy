/**
 * Provides pricing calculations for Movies
 **/
interface PricingStrategy {

	static def REGULAR 		= [
		getCharge: { int daysRented -> 
			2 + (daysRented > 2 ? (daysRented - 2) * 1.5 : 0)
		},
		getFrequentRenterPoints: {int daysRented ->
			1
		}
	] as PricingStrategy

	static def NEW_RELEASE 	= [
		getCharge: { int daysRented ->
			daysRented * 3
		},
		getFrequentRenterPoints: { int daysRented -> 
			daysRented > 1 ? 2 : 1
		}
	] as PricingStrategy

	static def CHILDRENS 	= [
		getCharge: { int daysRented ->
			1.5 + (daysRented > 3 ? (daysRented - 3) * 1.5 : 0)
		},
		getFrequentRenterPoints: {int daysRented ->
			1
		}
	] as PricingStrategy

	/** 
	 * Get the charge for the given number of daysRented
	 **/
	def getCharge(int daysRented)	

	/** 
	 * Get the frequent renter points for the given number of daysRented
	 **/
	def getFrequentRenterPoints(int daysRented)
}


