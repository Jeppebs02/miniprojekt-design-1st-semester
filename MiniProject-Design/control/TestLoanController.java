package control;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;

/**
 * The test class ShoppingControllerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestLoanController
{
    LoanController loanController;
    
    /**
     * Default constructor for test class ShoppingControllerTest
     */
    public TestLoanController()
    {
    }

    @BeforeAll
    public static void init()
    {
        LoanContainer lc = LoanContainer.getInstance();
        FriendController fc = new FriendController();
        LPContainer lpc = LPContainer.getInstance();
        LPController lpController = new LPController();
        
        Friend friend1 = fc.createFriend("Magnus", "UCN1", 9000, "Aalborg", 22112233);
        fc.saveFriend(friend1);
        
        Friend friend2 = fc.createFriend("Oscar", "UCN2", 9200, "Aalborg", 11112233);
        fc.saveFriend(friend2);
        
        
        Friend friend3 = fc.createFriend("Kasper", "UCN3", 9400, "Nørresundby", 21112233);
        fc.saveFriend(friend3);
        
        
        Friend friend4 = fc.createFriend("Matias", "Sin brændte bil", 9100, "Aalborg", 12112233);
        fc.saveFriend(friend4);
        
        Friend friend5 = fc.createFriend("Jeppe", "Under en bro", 9000, "Nørresundby", 33112233);
        fc.saveFriend(friend5);
        
     
        
        LP test1 = new LP(1111, "Gammel plade 1", "Gammel Artist 1", "1-1-1924");
        lpController.createLPCopy(test1, 111111, "20/04/2020", 500);
        lpc.addLP(test1);
        
        LP test2 = new LP(1222, "Gammel plade 2", "Gammel Artist 2", "1-3-1923");
        lpController.createLPCopy(test2, 222222, "12/02/2002", 300);
        lpc.addLP(test2);
        
        LP test3 = new LP(1333, "Gammel plade 3", "Gammel Artist 3", "1-2-1922");
        lpController.createLPCopy(test3, 333333, "09/08/1999",100);
        lpc.addLP(test3);
        
        LP test4 = new LP(1444, "Gammel plade 4", "Gammel Artist 4", "1-4-1920");
        lpController.createLPCopy(test4, 444444,"18/12/1893",1000);
        lpc.addLP(test4);
        
        LP test5 = new LP(1555, "Gammel plade 5", "Gammel Artist 5", "1-5-1919");
        lpController.createLPCopy(test5,555555, "21/07/2009", 250);
        lpc.addLP(test5); 
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testCreateLoan()
    {
        //Arrange
        LoanController lc = new LoanController();
        //fill test data i BeforeAll
        
        //act
        Loan loan = lc.createLoan("10-10-2010", 5);
        
        //Assert
        assertNotNull(lc);
        assertEquals("10-10-2010", loan.getBorrowDate());
        assertEquals(5, loan.getPeriod());
    }
    
    
}