/**
 * Test suite for Movie
 **/
import spock.lang.*

class MovieTest extends Specification {

	String TEST_MOVIE_TITLE = "Pulp Fiction"
	PricingStrategy TEST_MOVIE_PRICINGSTRATEGY = PricingStrategy.REGULAR
    PricingStrategy MOCK_PRICINGSTRATEGY = Mock()
    int TEST_DAYS_RENTED = 1

    def "Create a new Movie and get its properties"(){

    	def pulpFiction = new Movie(TEST_MOVIE_TITLE,TEST_MOVIE_PRICINGSTRATEGY)

    	expect:
    	pulpFiction.getTitle() == TEST_MOVIE_TITLE
    	pulpFiction.getPricingStrategy() == TEST_MOVIE_PRICINGSTRATEGY
    }

    def "Don't set a title after Movie construction!"(){

    	setup:
    	def pulpFiction = new Movie(TEST_MOVIE_TITLE,TEST_MOVIE_PRICINGSTRATEGY)

    	when:
    	pulpFiction.setTitle("cannot set title")

    	then:
    	thrown(groovy.lang.MissingMethodException)
    }

    def "Test getCharge with Mock PricingStrategy"(){

        setup: 
        double expectedCharge = 1
        def pulpFiction = new Movie(TEST_MOVIE_TITLE, MOCK_PRICINGSTRATEGY)

        when:
        double actualCharge = pulpFiction.getCharge(TEST_DAYS_RENTED)

        then:
        1 * MOCK_PRICINGSTRATEGY.getCharge(TEST_DAYS_RENTED) >> expectedCharge
        actualCharge == expectedCharge
    }

    def "Test getFrequentRenterPoints for non NEW_RELEASE"(){

        setup:
        def pulpFiction = new Movie(TEST_MOVIE_TITLE,TEST_MOVIE_PRICINGSTRATEGY)

        expect:
        1 == pulpFiction.getFrequentRenterPoints(TEST_DAYS_RENTED)
    }

    def "Test getFrequentRenterPoints for NEW_RELEASE"(){

        setup:
        int enoughDaysRentedToGetExtraPoint = 2
        def pulpFiction = new Movie(TEST_MOVIE_TITLE,PricingStrategy.NEW_RELEASE)

        expect:
        2 == pulpFiction.getFrequentRenterPoints(enoughDaysRentedToGetExtraPoint)
    }
}  