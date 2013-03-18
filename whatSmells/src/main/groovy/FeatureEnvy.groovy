import util.*
/**
 * Classes should encapsulate data and the methods that act on that data.  Class methods
 * should not covet the data of other classes.
 *
 * A version of this I see a lot is the other side of the Data Class smell: because of a 
 * Data Class (class with only getters and setters) another class must manipulate the data
 * in that class.
 **/
public class FeatureEnvy {

	def featureEnvyMethod(DataClass dataClass){
		int i = dataClass.intField
		String s = dataClass.stringField
		boolean b = booleanField

		if (b) {
			if (i > 0){
				return "I'm making decisions about the data in DataClass, in this case: ${s}."
			}
		}


	}
		
}