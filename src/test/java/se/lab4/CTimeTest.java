package se.lab4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rugal Bernstein
 */
public class CTimeTest
{

    private CTime time;

    public CTimeTest()
    {
    }

    @Before
    public void setUp()
    {
        System.out.println("setUp");
        time = new CTime(16, 47, TimeZone.Toronto.getTimeZone());
        System.out.println(time);
    }

    @After
    public void tearDown()
    {
        System.out.println("tearDown");
        System.out.println(time);
    }

    @Test
    public void testSetCurrentTimeZone()
    {
        System.out.println("setCurrentTimeZone");
        int timeZone = TimeZone.China.getTimeZone();
        time.setCurrentTimeZone(timeZone);
    }

    @Test
    public void testSetMinute()
    {
        System.out.println("setMinute");
        int minute = -1;
        time.setMinute(minute);
        Assert.assertNotEquals(minute, time.getMinute());
    }

    @Test
    public void testSetHour()
    {
        System.out.println("setHour");
        int hour = 0;
        time.setHour(24);
        Assert.assertNotEquals(hour, time.getHour());
    }

    @Test
    public void testCompareTo()
    {
        System.out.println("compareTo");
        CTime other = new CTime(16, 57, TimeZone.Toronto.getTimeZone());
        int expResult = -10;
        int result = time.compareTo(other);
        Assert.assertEquals(expResult, result);
    }

}
