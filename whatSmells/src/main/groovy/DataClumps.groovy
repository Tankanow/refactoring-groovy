/**
 * Do you often see fields hanging around together?  Have you ever tried removing a parameter
 * from a parameter list only to find the remaining parameters don't make sense without it?
 * These are signs of Data Clumps, candidates for class extraction.  The best part of this
 * smell is often after extracting a new class, you find Feature Envy nearby that can be 
 * integrated into the new class.
 */
public class DataClumps {

	def updateAddress(String firstName, String lastName, int streetNumber
					 ,String streetName, String streetType, String city, String state
					 ,String zipCode)
}