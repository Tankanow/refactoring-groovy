import util.DAL
/**
 * How many times have you seen one of these?
 **/

class LongMethod {

	private DAL dal

	public LongMethod(DAL dal){
		this.dal = dal
	}

	public boolean executeABunchOfStuff(String firstName, String lastName){

		int lengthOfFirstName = firstName.length()
		int lengthOfLastName = lastName.length()
		boolean isPalindromicName = false

		String reversedFirstName = firstName.reverse()
		String reversedLastName = lastName.reverse()

		String uuid = dal.retrieveUUIDbyName(lastName)
		String pw = dal.retrievePWbyName(lastName)

		loadLoginInformation(uuid, pw)

		if ("${firstName}${lastName}" == "${reversedLastName}${reversedFirstName}"){
			isPalindromicName = true
		}

		return isPalindromicName
	}


	private loadLoginInformation(String uuid, String pw){
		println ("I just loaded some login info")
	}
}