import util.*
/**
 * I don't see this one as much any more in object methods; however, there are definitely
 * a fair share of enterprise constructors with _more_ than enough parameters.
 * A large parameter list indicates a possible ill-designed object hierarchy.
 **/

 class LongParameterList {

 	public LongParameterList(DAL dal, Config config, String username, String password
 							,int numberOfRetries, int portNumber, int numberOfAllowedConnections
 							,String hostName, boolean isEnoughParameters){

 		// Do we really need this many dependencies?
 	}
 }