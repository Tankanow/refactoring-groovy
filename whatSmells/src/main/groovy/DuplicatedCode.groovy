/**
 * The most pungent code smell is Duplication.  There are even static code analyzers for this
 * issue.  Code Duplication can occur in two methods of the same class, or two related subclasses
 * or really anywhere in a project.  When you see duplicated code, prepare yourself to use one
 * or more of the following patterns: 
 *   - Extract Method
 *   - Pull Up Method
 *   - Form Template Method
 *   - Substitute Algorithm 
 *   - Extract Class 
 **/

 class DuplicatedCode {

 	
 	/**
 	 * Add one to the given int, then multiply by 2
 	 **/	
 	static def addOneThenMultiplyByTwo(int i){
 		def result = i + 1
 		result * 2
 	}		

 	/**
 	 * Add one to the given int, then subtract 1 
 	 **/	
 	static def addOneThenSubtractOne(int i){
 		def result = i + 1
 		result - 1
 	}
 }