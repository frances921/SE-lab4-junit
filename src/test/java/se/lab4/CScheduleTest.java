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

    public CScheduleTest()
    {
    }

    @Before
    public void setUp()
    {
        System.out.println("setUp");
        schedule = new CSchedule();
        System.out.println(schedule);
    }

    @After
    public void tearDown()
    {
        System.out.println("tearDown");
        System.out.println(schedule);
        System.out.println("----------------------------------------------");
    }

	@Test
    public void testAddMeetingSucceed()
    {
        System.out.println("addMeetingSucceeded");
        CMeeting meeting = new CMeeting(13, 0, 13, 45, TimeZone.Hawaii);
        boolean result = schedule.addMeeting(meeting);
        Assert.assertTrue(result);
    }

    @Test
    public void testAddMeetingFail()
    {
        System.out.println("addMeetingFailed");
        CMeeting meeting = new CMeeting(12, 0, 12, 45, TimeZone.Hawaii);
        schedule.addMeeting(meeting);
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
    	CMeeting meeting2 = new CMeeting(17, 0, 17, 45, TimeZone.China);    	
    	boolean result1 = schedule.addMeeting(meeting1);
    	boolean result2 = schedule.addMeeting(meeting2);
    	System.out.println(String.format("Add meeting at 17 to 17:45 in Hawaii: %b", result1));
    	System.out.println(String.format("Add meeting at 17 to 17:45 in Arizona: %b", result2));
    	Assert.assertTrue(result2);
    }
    
    @Test
    public void testOverlappedMeetingFail() {
    	System.out.println("Add 2 meeting with time overlapped fail");
    	CMeeting meeting1 = new CMeeting(17, 0, 17, 45, TimeZone.Hawaii);
    	CMeeting meeting2 = new CMeeting(17, 40, 18, 30, TimeZone.Hawaii); 
    	schedule.addMeeting(meeting1);
    	boolean result = schedule.addMeeting(meeting2);
    	Assert.assertFalse(result);
    }

}
