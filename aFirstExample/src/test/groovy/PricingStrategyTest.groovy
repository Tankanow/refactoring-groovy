/**
 * Test suite for PricingStrategy
 **/
import spock.lang.*

class PricingStrategyTest extends Specification {

    def "Test the pricing strategies"(){

        expect:
        charge == pricingStrategy.getCharge(daysRented)

        where:
        charge 		|	pricingStrategy 			|	daysRented
        2.0			|	PricingStrategy.REGULAR		|	1
        2.0			|	PricingStrategy.REGULAR		|	2
        3.5			|	PricingStrategy.REGULAR		|	3
        3.0			|	PricingStrategy.NEW_RELEASE |	1
        6.0			|	PricingStrategy.NEW_RELEASE |	2
        9.0			|	PricingStrategy.NEW_RELEASE |	3
        1.5			|	PricingStrategy.CHILDRENS 	|	2
        1.5			|	PricingStrategy.CHILDRENS 	|	3
        3.0			|	PricingStrategy.CHILDRENS 	|	4
    }

}  