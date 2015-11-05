package se.lab4;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rugal Bernstein, Jing Tao
 */
public class CMeetingTest
{

    private CMeeting meeting;

    public CMeetingTest()
    {
    }

    @Before
    public void setUp()
    {
        System.out.println("setUp");
        meeting = new CMeeting(12, 0, 12, 30, TimeZone.Toronto);
        System.out.println(meeting);
    }

    @After
    public void tearDown()
    {
        System.out.println("tearDown");
        System.out.println(meeting);
    }
   /*
    @Test
    public void testCompareTo()
    {
        System.out.println("compareTo");
        CMeeting other = new CMeeting(13, 0, 14, 0, TimeZone.Toronto);
        int expResult = -1;
        int result = meeting.compareTo(other);
        assertEquals(expResult, result);
    }
   */
    // Regular case
 	@Test
 	public void testRegularMeeting() {	
 		
 		CMeeting meeting2 = new CMeeting(12, 0, 12, 30, TimeZone.Toronto);
 		
 	}
 	
 	// Boundary value test: One hour meeting should pass
 	@Test
 	public void testOneHourMeeting() {
 		CMeeting meeting3 = new CMeeting(12, 0, 13, 0, TimeZone.Toronto);
 	}

	// Boundary value test: throws exception when start time is equal to end time
 	@Test(expected = IllegalArgumentException.class)
 	public void endTimeShouldNotEqualToStartTime() {
 		CMeeting meeting4 = new CMeeting(12, 0, 12, 0, TimeZone.Toronto);
 	}
 	
 	// Throws exception when end time is before start time
 	@Test(expected = IllegalArgumentException.class)
 	public void endTimeShouldBeAfterStartTime() {
 		
 		CMeeting meeting5 = new CMeeting(12, 0, 11, 30, TimeZone.Toronto);
 		
 	}
 	
 	// Throws exception when meeting is more than 1 hour
 	@Test(expected = IllegalArgumentException.class)
 	public void meetingShouldNotBeMoreThanOneHour() {
 		CMeeting meeting6 = new CMeeting(12, 0, 13, 30, TimeZone.Toronto);
 	}
 	

 }
    
    
