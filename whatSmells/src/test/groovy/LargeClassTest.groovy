/**
 * Test suite for @{link DuplicatedCode}
 **/
import spock.lang.*

class LargeClassTest extends Specification {
    // Test Values

    def "Test testLargeClass"(){

    	def largeClass = new LargeClass()

    	when:
    	largeClass.setNumberOfPets(3)

    	then:
    	3 == largeClass.getNumberOfPets()

    }
}