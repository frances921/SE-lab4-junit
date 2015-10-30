package se.lab4;

/**
 * This class is responsible for maintaining valid meeting object.<BR>
 * By saying valid means both start and stop {@link CTime} objects should be valid, also, stop time
 * always after the start time and that no meeting lasts more than 1 hour.<BR>
 * Also, location is important in TimeZone decision.
 *
 * @author Rugal Bernstein
 */
public class CMeeting implements Comparable<CMeeting>
{

    private static final String OUTPUT_TEMPLATE = "CMeeting\n  start=%s\n  stop=%s\n  location=%s";

    private static final TimeZone DEFAULT_TIMEZONE = TimeZone.Toronto;

    private CTime start = null;

    private CTime stop = null;

    private TimeZone location;

    /**
     * Initialize object with default time zone
     *
     * @param startHour
     * @param startMinute
     * @param stopHour
     * @param stopMinute
     */
    public CMeeting(int startHour, int startMinute, int stopHour, int stopMinute)
    {
        this(startHour, startMinute, stopHour, stopMinute, DEFAULT_TIMEZONE);
    }

    /**
     * Initialize object with all parameters specified. Start and stop time should be valid, which
     * means CTime object and meeting time duration should valid.
     *
     * @param startHour
     * @param startMinute
     * @param stopHour
     * @param stopMinute
     * @param location
     *
     * @throws IllegalArgumentException will be thrown when illegal start and stop time specified.
     */
    public CMeeting(int startHour, int startMinute, int stopHour, int stopMinute, TimeZone location)
    {
        this.location = location;
        CTime newStart = new CTime(startHour, startMinute, location.getTimeZone());
        CTime newStop = new CTime(stopHour, stopMinute, location.getTimeZone());
        int duration = newStop.compareTo(newStart);
        if (isValidMeeting(duration))
        {
            this.start = newStart;
            this.stop = newStop;
        }
        throw new IllegalArgumentException();
    }

    private boolean isValidMeeting(int duration)
    {
        return duration > 0 && duration <= 60;
    }

    public CTime getStart()
    {
        return start;
    }

    public CTime getStop()
    {
        return stop;
    }

    public TimeZone getLocation()
    {
        return location;
    }

    public void setLocation(TimeZone location)
    {
        this.location = location;
    }

    public void setStart(int hour, int minute)
    {
        CTime newTime = new CTime(hour, minute, location.getTimeZone());
        if (null == stop)
        {
            this.start = newTime;
        }
    }

    @Override
    public String toString()
    {

        return String.format(OUTPUT_TEMPLATE, start, stop, location.name());
    }

    @Override
    public int compareTo(CMeeting other)
    {
        if (this.stop.compareTo(other.start) <= 0)
        {
            return -1;
        }
        if (other.stop.compareTo(this.start) <= 0)
        {
            return 1;
        }
        return 0;
    }

}
