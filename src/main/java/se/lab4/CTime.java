package se.lab4;

/**
 * This class is responsible for maintaining a valid time object.<BR>
 * Specifically, Hour must be between 0 and 23 inclusively and minute must be between 0 and 59
 * inclusively.<BR>
 * Setters of this class applied "High cohesion" pattern.
 *
 * @author Rugal Bernstein
 */
public final class CTime implements Comparable<CTime>
{

    private static final int MINUTE = 60;

    private static final String OUTPUT_TEMPLATE = "CTime{ TimeZone=%d, hour=%d, minute=%d }";

    private static final int DEFAULT_TIME_ZONE = -5;

    private int currentTimeZone = DEFAULT_TIME_ZONE;

    private int hour = 0;

    private int minute = 0;

    /**
     * Initialize default constructor, with both hour and minute set as 0.
     */
    CTime()
    {
    }

    CTime(int hour, int minute)
    {
        this();
        this.setHour(hour);
        this.setMinute(minute);
    }

    CTime(int hour, int minute, int timeZone)
    {
        this(hour, minute);
        this.setCurrentTimeZone(timeZone);
    }

    public int getCurrentTimeZone()
    {
        return currentTimeZone;
    }

    public void setCurrentTimeZone(int timeZone)
    {
        if (isValidTimeZone(timeZone))
        {
            timeOffSetByHour(timeZone - this.currentTimeZone);
            this.currentTimeZone = timeZone;
        }
    }

    /**
     * Get the value of minute
     *
     * @return the value of minute
     */
    public int getMinute()
    {
        return minute;
    }

    /**
     * Offset hour number.
     *
     * @param offSet can be positive or negative.
     */
    public void timeOffSetByHour(int offSet)
    {
        this.hour += offSet;
        this.hour %= 24;
    }


    {

    }

    /**
     * Set the value of minute.<BR>
     * Input minute has to be a valid minute number.
     *
     * @param minute new and valid value of minute
     */
    public void setMinute(int minute)
    {
        if (isValidMinute(minute))
        {
            this.minute = minute;
        }
    }

    private boolean isValidMinute(int minute)
    {
        return minute >= 0 && minute < 60;
    }

    private boolean isValidHour(int hour)
    {
        return hour >= 0 && hour < 24;
    }

    private boolean isValidTimeZone(int timeZone)
    {
        return timeZone >= -12 && timeZone <= 12;
    }

    /**
     * Get the value of hour
     *
     * @return the value of hour
     */
    public int getHour()
    {
        return hour;
    }

    /**
     * Set the value of hour.<BR>
     * Input hour has to be a valid hour number.
     *
     * @param hour new and valid value of hour
     */
    public void setHour(int hour)
    {
        if (isValidHour(hour))
        {
            this.hour = hour;
        }
    }

    @Override
    public int compareTo(CTime t)
    {
        return this.getTotalMinutes() - t.getTotalMinutes();
    }

    private int getTotalMinutes()
    {
        return this.hour * MINUTE + this.minute;
    }

    @Override
    public String toString()
    {
        return String.format(OUTPUT_TEMPLATE, this.currentTimeZone, this.hour, this.minute);
    }

}
