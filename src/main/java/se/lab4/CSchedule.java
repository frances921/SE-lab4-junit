package se.lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will store a list of meetings. No conflicted meeting is allow.
 *
 * @author Rugal Bernstein
 */
public class CSchedule
{

    private final List<CMeeting> meetings = new ArrayList<>();

    /**
     * Add meeting by guaranteeing no confliction happens.<BR>
     * If successfully added, a clone object will be add into container, thus, parameter is
     * different from actual meeting in schedule list.
     *
     * @param meeting
     *
     * @return true if add a meeting object into schedule successfully; false if invalid parameter
     *         or confliction occurs.
     */
    public boolean addMeeting(CMeeting meeting)
    {
        if (null == meeting)
        {
            return false;
        }
        for (CMeeting m : meetings)
        {
            if (m.compareTo(meeting) == 0)
            {
                return false;
            }
        }
        try
        {
            meetings.add(meeting.clone());
        }
        catch (CloneNotSupportedException ex)
        {

        }
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("CSchedule:\n");
        for (CMeeting meeting : meetings)
        {
            sb.append("--").append(meeting.toString()).append("\n");
        }
        return sb.toString();
    }

}
