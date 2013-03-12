import util.*
/**
 * Often classes are much too large.  One symptom of a class that is too large is lots of 
 * instance variables.
 **/
class LargeClass {

	String firstName
	String lastName
	String uuid
	String pw
	int age
	boolean isRetired
	boolean hasCar
	boolean hasHouse
	String favoriteColor
	int numberOfPets
	List<String> petNames
	int numberOfChildren
	List<String> childNames

	// And maybe we have some dependencies too (at least these dependencies are abstractions =/)
	DAL dataAccessLayer
	Config configurationAccessor

	public LargeClass(DAL dataAccessLayer, Config configurationAccessor){
		this.dataAccessLayer = dataAccessLayer
		this.configurationAccessor = configurationAccessor
	}

	// and we're going to do some of our dependencies work for it and make that method public
	public void loadConfiguration(){
		configurationAccessor.loadConfig()
	}

	// and maybe there are some more public methods here before we even get to the getters 
	// and setters for all of those instance variables

}