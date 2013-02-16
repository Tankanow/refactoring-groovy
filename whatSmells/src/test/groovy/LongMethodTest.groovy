/**
 * Test suite for @{link LongMethod}
 **/
import spock.lang.*

class LongMethodTest extends Specification {
    // Test Values

    def "Test longMethodTest"(){

    	expect:
    	3 == LongMethod.longMethod("foo")
    }
}