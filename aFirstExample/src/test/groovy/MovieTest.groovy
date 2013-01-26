/**
 * Test suite for Movie
 **/
import spock.lang.*

class MovieTest extends Specification {

	String TEST_MOVIE_TITLE = "Pulp Fiction"
	int TEST_MOVIE_PRICECODE = Movie.REGULAR

    def "Create a new Movie and get its properties"(){

    	setup:
    	def pulpFiction = new Movie(TEST_MOVIE_TITLE,-1)

    	when:
    	pulpFiction.setPriceCode(TEST_MOVIE_PRICECODE)

    	then:
    	pulpFiction.getTitle() == TEST_MOVIE_TITLE
    	pulpFiction.getPriceCode() == TEST_MOVIE_PRICECODE
    }

    def "Don't set a title after Movie construction!"(){

    	setup:
    	def pulpFiction = new Movie(TEST_MOVIE_TITLE,-1)

    	when:
    	pulpFiction.setTitle("cannot set title")

    	then:
    	thrown(groovy.lang.MissingMethodException)
    }
}  