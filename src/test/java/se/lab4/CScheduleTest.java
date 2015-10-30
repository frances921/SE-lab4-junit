package se.lab4;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rugal Bernstein
 */
public class CScheduleTest
{

    private CSchedule schedule;

    private final CMeeting hawaii = new CMeeting(12, 0, 12, 45, TimeZone.Hawaii);

    private final CMeeting china = new CMeeting(12, 0, 12, 45, TimeZone.China);

    private final CMeeting toronto = new CMeeting(12, 0, 12, 45, TimeZone.Toronto);

    public CScheduleTest()
    {
    }

    @Before
    public void setUp()
    {
        System.out.println("setUp");
        schedule = new CSchedule();
        schedule.addMeeting(china);
        schedule.addMeeting(hawaii);
        schedule.addMeeting(toronto);
        System.out.println(schedule);
    }

    @After
    public void tearDown()
    {
        System.out.println("tearDown");
        System.out.println(schedule);
        System.out.println("-----------------------------------------------");
    }

    @Test
    public void testAddMeetingSucceed()
    {
        System.out.println("addMeeting");
        CMeeting meeting = new CMeeting(13, 0, 13, 45, TimeZone.Hawaii);
        boolean result = schedule.addMeeting(meeting);
        Assert.assertTrue(result);
    }

    @Test
    public void testAddMeetingFail()
    {
        System.out.println("addMeeting");
        CMeeting meeting = new CMeeting(12, 0, 12, 45, TimeZone.Hawaii);
        boolean result = schedule.addMeeting(meeting);
        Assert.assertFalse(result);
    }

}
