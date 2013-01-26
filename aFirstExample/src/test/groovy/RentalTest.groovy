/**
 * Test suite for Rental
 **/
import spock.lang.*

class RentalTest extends Specification {

    static final COBRA = new Movie("Cobra",Movie.REGULAR)
    static final NO_DAYS_RENTED = 0

    def "Create a new Rental and get its properties"(){

    	when:
    	def rental = new Rental(COBRA, NO_DAYS_RENTED)

    	then:
        rental.getMovie() == COBRA
        rental.getDaysRented() == NO_DAYS_RENTED

    }

    def "Don't set the Movie after Rental construction"(){

        setup:
        def rental = new Rental(COBRA, NO_DAYS_RENTED)

        when:
        rental.setMovie(COBRA)

        then:
        thrown(groovy.lang.MissingMethodException)
    }

    def "Don't set the daysRented after Rental construction"(){

        setup:
        def rental = new Rental(COBRA, NO_DAYS_RENTED)

        when:
        rental.setDaysRented(-1)

        then:
        thrown(groovy.lang.MissingMethodException)
    }
}  