package se.lab4;

/**
 *
 * @author Administrator
 */
public enum TimeZone
{

    Baker_Island(-12), Niue(-11), Hawaii(-10), Gambier_Islands(-9), British_Columbia(-8), Arizona(-7), Mexico(-6), Cuba(-5), Bolivia(-4), Argentina(-3), Brazil(-2), Cape_Verde(-1),
    Iceland(0),
    Algeria(1), Egypt(2), Yemen(3), Oman(4), Pakistan(5), Bangladesh(6), Vietnam(7), China(8), Japan(9), Queensland(10), Solomon_Islands(11), Fiji(12);

    private final int timeZone;

    public int getTimeZone()
    {
        return timeZone;
    }

    private TimeZone(int timeZone)
    {
        this.timeZone = timeZone;
    }

}
