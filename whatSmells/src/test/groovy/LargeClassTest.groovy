import util.*
/**
 * Test suite for @{link DuplicatedCode}
 **/
import spock.lang.*

class LargeClassTest extends Specification {
    // Test Values

    def "Test testLargeClass"(){
    	def dataAccessLayer = Mock(DAL)
    	def configurationAccessor = Mock(Config)

    	def largeClass = new LargeClass(dataAccessLayer, configurationAccessor)

    	when:
    	largeClass.setNumberOfPets(3)

    	then:
    	3 == largeClass.getNumberOfPets()

    }
}