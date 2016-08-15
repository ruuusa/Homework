/**
 * Created by Ruusa on 10.02.2016.
 */
public class EX02 {

    /**
     * Constant.
     * Every 3 days, feed worms.
     */
    public static final int WORM_FEEDING_DAY = 3;

    /**
     * Constant.
     * Every 5 days, bathe in sand.
     */
    public static final int BATHING_DAY = 5;

    /**
     * Constant.
     * Total number of days for which instructions are needed.
     */
    public static final int NUMBER_OF_DAYS = 30;

    /**
     * Entry point of the program.
     * @param args Arguments from command line.
     */
    public static void main(String[] args) {
        // call and print getInstructionForCurrentDay inside a loop here
        for (int i = 1; i <= NUMBER_OF_DAYS; i++) {
            System.out.println(getInstructionForCurrentDay(i));

        }
    }

    /**
     * Return instruction for given day.
     * @param currentDay number of day to print instructions for.
     */
    public static String getInstructionForCurrentDay(int currentDay) {
        if (currentDay <= 0) {
            return "Can't fly back in time";}
        if (currentDay % (WORM_FEEDING_DAY * BATHING_DAY) == 0) {
            return "Day " + currentDay + " : " + "glide in wind";}
        if (currentDay % WORM_FEEDING_DAY == 0) {
            return "Day " + currentDay + " : " + "feed worms";}
        if (currentDay % BATHING_DAY == 0) {
            return "Day " + currentDay + " : " + "bathe in sand";}
        else {
            return "Day " + currentDay + " : " + "give fruit and water";}
    }
}
