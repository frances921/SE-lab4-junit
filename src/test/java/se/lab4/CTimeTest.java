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
public class CTimeTest
{

    public CTimeTest()
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
    public void testSetCurrentTimeZone()
    {
        System.out.println("setCurrentTimeZone");
        int timeZone = 0;
        CTime instance = new CTime();
        instance.setCurrentTimeZone(timeZone);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMinute()
    {
        System.out.println("getMinute");
        CTime instance = new CTime();
        int expResult = 0;
        int result = instance.getMinute();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTimeOffSetByHour()
    {
        System.out.println("timeOffSetByHour");
        int offSet = 0;
        CTime instance = new CTime();
        int expResult = 0;
        int result = instance.timeOffSetByHour(offSet);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetMinute()
    {
        System.out.println("setMinute");
        int minute = 0;
        CTime instance = new CTime();
        instance.setMinute(minute);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetHour()
    {
        System.out.println("setHour");
        int hour = 0;
        CTime instance = new CTime();
        instance.setHour(hour);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCompareTo()
    {
        System.out.println("compareTo");
        CTime t = null;
        CTime instance = new CTime();
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}
