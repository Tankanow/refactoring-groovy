/**
 * Test suite for @{link DuplicatedCode}
 **/
import spock.lang.*

class DuplicatedCodeTest extends Specification {
    // Test Values

    def "Test addOneThenSubtractOne"(){

        expect:
        expected == DuplicatedCode.addOneThenSubtractOne(input)

        where:
        input   |   expected 
        1       |   1
        2       |   2
    }

    def "Test addOneThenMultiplyByTwo"(){

        expect:
        expected == DuplicatedCode.addOneThenMultiplyByTwo(input)

        where:
        input   |   expected
        1       |   4
        2       |   6

    }
}  
