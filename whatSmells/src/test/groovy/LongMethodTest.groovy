import util.DAL

/**
 * Test suite for @{link LongMethod}
 **/
import spock.lang.*

class LongMethodTest extends Specification {
    // Test Values

    def "Test longMethodTest"(){
    	def dal = Mock(DAL)	
    	def longMethod = new LongMethod(dal)

    	expect:
    	true == longMethod.executeABunchOfStuff("foo", "oof")
    }
}