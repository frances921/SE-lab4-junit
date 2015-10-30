package se.lab4;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rugal Bernstein
 */
public class CMeetingTest
{

    public CMeetingTest()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testSetStart()
    {
        System.out.println("setStart");
        int hour = 0;
        int minute = 0;
        CMeeting instance = null;
        instance.setStart(hour, minute);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetStop()
    {
        System.out.println("setStop");
        int hour = 0;
        int minute = 0;
        CMeeting instance = null;
        instance.setStop(hour, minute);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCompareTo()
    {
        System.out.println("compareTo");
        CMeeting other = null;
        CMeeting instance = null;
        int expResult = 0;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}
