package se.lab4;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rugal Bernstein
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

    @Test
    public void testCompareTo()
    {
        System.out.println("compareTo");
        CMeeting other = new CMeeting(13, 0, 14, 0, TimeZone.Toronto);
        int expResult = -1;
        int result = meeting.compareTo(other);
        assertEquals(expResult, result);
    }

}
