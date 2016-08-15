/**
 * Created by Ruusa on 12.04.2016.
 */
import java.io.IOException;

/**
 * Homework 02 - Droptris AI.
 * https://courses.cs.ttu.ee/pages/ITI0011:HW02_Droptris
 */
public class HW02 {
    /**
     * The main method. You can use this to initialize the game.
     * Tester will not execute the main method.
     * @param args Arguments from command line
     */

    /**
     * Int array to put O blocks in different places.
     */
    public static int[] lastNumber = new int[1];

    /**
     * The main method. You can use this to initialize the game.
     * Tester will not execute the main method.
     * @param args Arguments from command line
     */
    public static void main(String[] args) {
        Configuration c = new Configuration(1, 1, 1);
        run(c.toString());
    }

    /**
     * Optional setup. This method will be called
     * before the game is started. You can do some
     * precalculations here if needed.
     *
     * If you don't need to precalculate anything,
     * just leave it empty.
     */
    public static void setup() {
    }

    /**
     * The method to execute your AI.
     * @param connectionString JSON-formatted connection string.
     *                         If you implement Socket connection yourself
     *                         you should use this string directly when connecting.
     *                         If you use DroptrisConnection, you can ignore that.
     * @return The final score. You should read the score from the server.
     */
    public static int run(String connectionString) {
        try {
            DroptrisConnection conn = new DroptrisConnection("roruus", true);
            String line;
            // read "welcome" line from connection
            line = conn.readLine();
            System.out.println(line);
            // read block
            line = conn.readLine();
            System.out.println(line);
            while (line != null) {
                line = conn.readLine();
                System.out.println(line);
                String[] chars = line.split("");
                String character = chars[1];
                if (character == "O") {
                    if (lastNumber[0] == 0) {
                        conn.sendAction("{\"column\": 2, \"rotation\": 0}");
                        lastNumber[0] = 1;
                    }
                    if (lastNumber[0] != 1 && lastNumber[0] != 0) {
                        conn.sendAction("{\"column\": 4, \"rotation\": 0}");
                        lastNumber[0] = 0;
                    }
                }
                if (character == "I") {
                    conn.sendAction("{\"column\": 6, \"rotation\": 0}");
                }
                if (character != "I" && character != "O") {
                    conn.sendAction("{\"column\": 0, \"rotation\": 0}");
                }
            }
                if (line == null) {
                // in this example, we still get blocks
                // as the game is not over, but in general
                // if connection readLine returns null,
                // there are no more blocks
                System.out.println("no more blocks!");
            }
            System.out.println(conn.readScoreData());
            System.out.println("game over!");
            // you should implement score parsing
            // here we just return 400
            return lastNumber[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
