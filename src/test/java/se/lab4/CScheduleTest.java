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

    private final CMeeting toronto = new CMeeting(12, 0, 12, 45, TimeZone.Toronto);

    public CScheduleTest()
    {
    }

    @Before
    public void setUp()
    {
        System.out.println("setUp");
        schedule = new CSchedule();
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
    
    @Test
    public void testAddMoreMeetingsSucceed() {
    	System.out.println("Add more meetings");
    	CMeeting meeting1 = new CMeeting(8, 0, 8, 35);
    	CMeeting meeting2 = new CMeeting(11, 0, 11, 35);
    	schedule.addMeeting(meeting1);
    	boolean result = schedule.addMeeting(meeting2);
    	Assert.assertTrue(result);
    }
    
    @Test
    public void testAddMeetingWithDiffTZ() {
    	System.out.println("Add 2 meetings in different timezone with same local time");
    	CMeeting meeting1 = new CMeeting(17, 0, 17, 45, TimeZone.Hawaii);
    	CMeeting meeting2 = new CMeeting(17, 0, 17, 45, TimeZone.Arizona);    	
    	boolean result1 = schedule.addMeeting(meeting1);
    	boolean result2 = schedule.addMeeting(meeting2);
    	System.out.println(String.format("Add meeting at 17 to 17:45 in Hawaii: ", result1));
    	System.out.println(String.format("Add meeting at 17 to 17:45 in Arizona: ", result2));
    	Assert.assertTrue(result2);
    }

}
