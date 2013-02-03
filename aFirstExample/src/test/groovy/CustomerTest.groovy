/**
 * Test suite for @{link Customer}
 **/
import spock.lang.*

class CustomerTest extends Specification {
    // Test Values
    /** Names */
    static final MY_NAME = "Adam Tankanow"
    /** Movies */
    static final RAN = new Movie("Ran",PricingStrategy.REGULAR)
    static final BAMBI = new Movie("Bambi",PricingStrategy.CHILDRENS)
    static final DJANGO = new Movie("Django",PricingStrategy.NEW_RELEASE)
    /** Rentals */
    static final RENTAL = new Rental(RAN,0)

    def "Create a new Customer and add a Rental"(){

        setup:
        def adam_tankanow = new Customer(MY_NAME)

        when:
        adam_tankanow.addRental(RENTAL)

        then:
        adam_tankanow.getName() == MY_NAME
        adam_tankanow.rentals.get(0) == RENTAL
    }

    def "Don't even think about setting a Customer's name after construction"(){
        setup:
        def adam_tankanow = new Customer(MY_NAME)

        when:
        adam_tankanow.setName("Why are you trying to set my name again?")

        then:
        thrown(groovy.lang.MissingMethodException)
    }

    def "How about some statements for a few example rentals so we can get full code coverage"(){

        setup:
        Customer customer = new Customer("Adam")

        when:
        customer.rentals = rentals

        then:
        customer.statement() == statement 

        where:
        rentals                     |   statement
        [new Rental(RAN,1)]         |   "Rental Record for Adam\n\tRan\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points"
        [new Rental(RAN,3)]         |   "Rental Record for Adam\n\tRan\t3.5\nAmount owed is 3.5\nYou earned 1 frequent renter points"
        [new Rental(DJANGO,1)]      |   "Rental Record for Adam\n\tDjango\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points"
        [new Rental(DJANGO,2)]      |   "Rental Record for Adam\n\tDjango\t6.0\nAmount owed is 6.0\nYou earned 2 frequent renter points"
        [new Rental(BAMBI,1)]       |   "Rental Record for Adam\n\tBambi\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points"
        [new Rental(BAMBI,4)]       |   "Rental Record for Adam\n\tBambi\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points"
    }


    def "Let's test that new htmlStatement method"(){

        setup:
        Customer customer = new Customer("Adam")

        when:
        customer.rentals = rentals

        then:
        customer.htmlStatement() == htmlStatement 

        where:
        rentals                     |   htmlStatement
        [new Rental(RAN,1)]         |   "<H1>Rentals for <EM>Adam</EM></H1><P>\nRan: 2.0<BR>\n<P>You owe <EM>2.0</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>"
        [new Rental(RAN,3)]         |   "<H1>Rentals for <EM>Adam</EM></H1><P>\nRan: 3.5<BR>\n<P>You owe <EM>3.5</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>"
        [new Rental(DJANGO,1)]      |   "<H1>Rentals for <EM>Adam</EM></H1><P>\nDjango: 3.0<BR>\n<P>You owe <EM>3.0</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>"
        [new Rental(DJANGO,2)]      |   "<H1>Rentals for <EM>Adam</EM></H1><P>\nDjango: 6.0<BR>\n<P>You owe <EM>6.0</EM><P>\nOn this rental you earned <EM>2</EM> frequent renter points<P>"
        [new Rental(BAMBI,1)]       |   "<H1>Rentals for <EM>Adam</EM></H1><P>\nBambi: 1.5<BR>\n<P>You owe <EM>1.5</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>"
        [new Rental(BAMBI,4)]       |   "<H1>Rentals for <EM>Adam</EM></H1><P>\nBambi: 3.0<BR>\n<P>You owe <EM>3.0</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>"
    }
}  
