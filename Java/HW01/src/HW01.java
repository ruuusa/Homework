import java.util.*;

/**
 * Created by Ruusa on 24.02.2016.
 */

/**
 *
 */
public class HW01 {
    /**
     * Value to return in makeMove in case
     * the cell was empty.
     */
    public static final int CELL_EMPTY = 0;

    /**
     * Value to return in makeMove in case
     * the cell contained treasure.
     */
    public static final int CELL_TREASURE = 1;

    /**
     * Value to return in makeMove in case
     * the cell does not exist.
     */

    public static final int CELL_ERROR = -1;

    /**
     * Creates map to be used in the exercise
     * height sets the height of the map
     * width sets the width of the map
     */
    public static String mapWithTreasures[][];

    /**
     * Creates map to be used in the exercise
     * height sets the height of the map
     * width sets the width of the map
     */
    public static String mapWithoutTreasures[][];

    /**
     * Array to contain values from input.
     * Global needed due to try, catch loops
     */
    public static int intValues2[];

    /**
     * Digging move counter that is used globally
     */
    public static int moveCounter = 0;

    /**
     * Global int that shows, how many treasures are left.
     */
    public static int treasuresLeftCounter = 0;

    /**
     * Global int that shows, how many mm games have been played.
     */
    public static int gamesPlayed = 0;

    /**
     * Global boolean to start game.
     */
    public static boolean start = true;

    /**
     * Main entry.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        while (start) {
            String mmOrNot = input("Kas soovite mängida aardeotsimise MM'i? ");
            if (mmOrNot.equals("jah")) {
                mmGameLaunch(true);
            } else {
                regularGameLaunch(true);
            }
        }
    }

    /**
     * Makes move to cell in certain row and column.
     * and returns the contents of the cell.
     * Use CELL_* constants in return.
     *
     * @param row Row to make move to.
     * @param col Column to make move to.
     * @return Contents of the cell.
     */
    public static int makeMove(int row, int col) {
        try {
            if (row > 0 && col > 0) {
                if (mapWithTreasures[row - 1][col - 1].equals("1")) return CELL_TREASURE;
                if (mapWithTreasures[row - 1][col - 1].equals("0")) return CELL_EMPTY;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            return CELL_ERROR;
        }
        if (row < 1 || col < 1) return CELL_ERROR;
        return 0;
    }

    /**
     * Creates a map with certain measures and treasures.
     * @param height    Height of the map.
     * @param width     Width of the map.
     * @param treasures The number of treasures on the map.
     * @return The map (with treasures).
     */
    public static String[][] createMap(int height, int width, int treasures) {
        String mapWithTreasures[][] = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                mapWithTreasures[i][j] = "0";
            }
        }
        Random random = new Random();
        for (int i = 0; i < treasures; i++) {
            int x, y;
            do {
                x = random.nextInt(height);
                y = random.nextInt(width);
            } while (mapWithTreasures[x][y] == "1");
            {
                mapWithTreasures[x][y] = "1";
            }
        }
        return mapWithTreasures;
    }

    /**
     * Creates a map with certain measures.
     * @param height    Height of the map.
     * @param width     Width of the map.
     * @return The map without treasures. Only for printing.
     */
    public static String[][] creatingMapWithoutTreasures(int height, int width) {
        String mapWithoutTreasures[][] = new String[height][width];
        int i = 0;
        while (i < height) {
            for (int j = 0; j < width; j++) {
                mapWithoutTreasures[i][j] = ".";
            }
            i++;
        }
        return mapWithoutTreasures;
    }

    public static int howClose(int row, int col) {
        while (!mapWithoutTreasures[row][col] != "")
    }
    /**
     * Allows users to insert input.
     * @param text the text after which input is needed.
     * @return The text with input availability.
     */
    public static String input(final String text) {
        Scanner scan = new Scanner(System.in);
        System.out.print(text);
        return scan.nextLine();
    }

    /**
     * Controls, whether the user input for creating a map is correct (as in int, int, int).
     * @param input the input text.
     * @return Returns, whether the input text matches requirements or not.
     */
    public static boolean stringControl1(String input) {
        String correctPattern = "^[1-9][0-9]*[,][1-9][0-9]*[,][0-9][0-9]*$";
        if (!input.matches(correctPattern)) {
            return false;
        }
        if (input.matches(correctPattern)) {
            return true;
        }
        return false;
    }

    /**
     * Controls, whether the user input for choosing a coordinate to dig is correct (as in int, int).
     * @param input the input text.
     * @return Returns, whether the input text matches requirements or not.
     */
    public static boolean stringControl2(String input) {
        String correctPattern = "^[1-9][0-9]*[,][1-9][0-9]*$";
        if (!input.matches(correctPattern)) {
            return false;
        }
        if (input.matches(correctPattern)) {
            return true;
        }
        return false;
    }

    /**
     * Takes user input and returns the values from it (rows, cols, treasures).
     * Needed to create the map.
     * @param text the input text.
     * @return Returns the values from the input (rows, cols, treasures).
     */
    public static int[] stringToArray1(String text) {
        String textToList[] = text.split(",");
        int rows = Integer.parseInt(textToList[0]);
        int cols = Integer.parseInt(textToList[1]);
        int treasures = Integer.parseInt(textToList[2]);
        int values[] = new int[3];
        values[0] = rows;
        values[1] = cols;
        values[2] = treasures;
        return values;
    }

    /**
     * Takes user input and returns the values from it (rows, cols, treasures).
     * Needed to make moves for digging.
     * @param text the input text.
     * @return Returns the values from the input (rows, cols, treasures).
     */
    public static int[] stringToArray2(final String text) {
        String textToList[] = text.split(",");
        int rows = Integer.parseInt(textToList[0]);
        int cols = Integer.parseInt(textToList[1]);
        int values[] = new int[3];
        values[0] = rows;
        values[1] = cols;
        return values;
    }

    /**
     * Launches the MM game.
     * @param mmOrNot is not used.
     * @return Returns the game to be played. Every time the map goes bigger by 1 row and column, but the amount of treasures stay the same.
     */
    public static boolean mmGameLaunch(final boolean mmOrNot) {
        String beginning = "";
        while (!stringControl1(beginning)) {
            beginning = input("Sisesta M (ridade arv), N (veergude arv), X (aarete arv): ");
            beginning = beginning.replaceAll(" ", "");
        }
        int intValues[] = stringToArray1(beginning);
        while (intValues[2] > intValues[1] * intValues[0]) {
            beginning = input("Sisesta M (ridade arv), N (veergude arv), X (aarete arv): ");
            beginning = beginning.replaceAll(" ", "");
            if (stringControl1(beginning)) {
                intValues = stringToArray1(beginning);
            }
        }
        if (stringControl1(beginning)) {
            System.out.println("Edukat kaevamist!\n");
        }
        while (gamesPlayed < 5) {
            mapWithTreasures = createMap(intValues[0], intValues[1], intValues[2]);
            mapWithoutTreasures = creatingMapWithoutTreasures(intValues[0], intValues[1]);
            treasuresLeftCounter = intValues[2];
            for (int r = 0; r < mapWithoutTreasures.length; r++) {
                for (int c = 0; c < mapWithoutTreasures[r].length; c++)
                    System.out.print(mapWithoutTreasures[r][c]);
                    System.out.println();
            }
            while (treasuresLeftCounter > 0) {
                System.out.print("\nKaevamisi: " + moveCounter + ", aardeid jäänud: " + treasuresLeftCounter + "\n");
                String midaKaevame = input("Mida kaevame (rida, veerg): ");
                try {
                    intValues2 = stringToArray2(midaKaevame);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
                }
                while (!stringControl2(midaKaevame) || makeMove(intValues2[0], intValues2[1]) == -1 || mapWithoutTreasures[intValues2[0] - 1][intValues2[1] - 1].equals("+")) {
                    midaKaevame = input("Mida kaevame (rida, veerg): ");
                    midaKaevame = midaKaevame.replaceAll(" ", "");
                    try {
                        intValues2 = stringToArray2(midaKaevame);
                    } catch (NumberFormatException exception) {
                    }
                }
                if (stringControl2(midaKaevame)) {
                    if ((makeMove(intValues2[0], intValues2[1])) == 1) {
                        System.out.print("\n");
                        mapWithoutTreasures[intValues2[0] - 1][intValues2[1] - 1] = "+";
                        for (int r = 0; r < mapWithoutTreasures.length; r++) {
                            for (int c = 0; c < mapWithoutTreasures[r].length; c++)
                                System.out.print(mapWithoutTreasures[r][c]);
                                System.out.println();
                        }
                        System.out.println("\nAare!\n");
                        treasuresLeftCounter -= 1;
                        moveCounter += 1;
                    }
                    if ((makeMove(intValues2[0], intValues2[1])) == 0) {
                        mapWithoutTreasures[intValues2[0] - 1][intValues2[1] - 1] = " ";
                        System.out.print("\n");
                        for (int r = 0; r < mapWithoutTreasures.length; r++) {
                            for (int c = 0; c < mapWithoutTreasures[r].length; c++)
                                System.out.print(mapWithoutTreasures[r][c]);
                                System.out.println();
                        }
                        moveCounter += 1;
                    }
                }
            }
            if (treasuresLeftCounter == 0) {
                intValues[0] += 1;
                intValues[1] += 1;
                gamesPlayed += 1;
                if (gamesPlayed != 5) {
                    System.out.println("Algab uus mäng!\nMänguväli on 1 rea ja veeru võrra suurem! Aarete arv on sama.\n");
                }
            }
        }
        if (gamesPlayed == 5) {
            String endQuestion = input("Aardejahi MM on läbi! Kokku tehti " + moveCounter + " kaevamist.\nKas soovid veel mängida? ");
            if (endQuestion.equals("jah")) {
                treasuresLeftCounter = 0;
                moveCounter = 0;
                start = true;
            }
            else {
                start = false;
            }
        }
        return false;
    }

    /**
     * Launches the regular game.
     * @param mmOrNot is not used.
     * @return Returns the game to be played.
     */
    public static boolean regularGameLaunch(boolean mmOrNot) {
        String beginning = "";
        while (!stringControl1(beginning)) {
            beginning = input("Sisesta M (ridade arv), N (veergude arv), X (aarete arv): ");
            beginning = beginning.replaceAll(" ", "");
        }
        int intValues[] = stringToArray1(beginning);
        while (intValues[2] > intValues[1] * intValues[0]) {
            beginning = input("Sisesta M (ridade arv), N (veergude arv), X (aarete arv): ");
            beginning = beginning.replaceAll(" ", "");
            if (stringControl1(beginning)) {
                intValues = stringToArray1(beginning);
            }
        }
        if (stringControl1(beginning)) {
            System.out.println("Edukat kaevamist!\n");
        }
        mapWithTreasures = createMap(intValues[0], intValues[1], intValues[2]);
        mapWithoutTreasures = creatingMapWithoutTreasures(intValues[0], intValues[1]);
        treasuresLeftCounter = intValues[2];
        for (int r = 0; r < mapWithoutTreasures.length; r++) {
            for (int c = 0; c < mapWithoutTreasures[r].length; c++)
                System.out.print(mapWithoutTreasures[r][c]);
                System.out.println();
        }
        while (treasuresLeftCounter > 0) {
            System.out.print("\nKaevamisi: " + moveCounter + ", aardeid jäänud: " + treasuresLeftCounter + "\n");
            String midaKaevame = input("Mida kaevame (rida, veerg): ");
            try {
                intValues2 = stringToArray2(midaKaevame);
            } catch (NumberFormatException exception) {
            }
            while (!stringControl2(midaKaevame) || makeMove(intValues2[0], intValues2[1]) == -1 || mapWithoutTreasures[intValues2[0] - 1][intValues2[1] - 1].equals("+")) {
                midaKaevame = input("Mida kaevame (rida, veerg): ");
                midaKaevame = midaKaevame.replaceAll(" ", "");
                try {
                    intValues2 = stringToArray2(midaKaevame);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
                }
            }
            if (stringControl2(midaKaevame)) {
                if ((makeMove(intValues2[0], intValues2[1])) == 1) {
                    System.out.print("\n");
                    mapWithoutTreasures[intValues2[0] - 1][intValues2[1] - 1] = "+";
                    for (int r = 0; r < mapWithoutTreasures.length; r++) {
                        for (int c = 0; c < mapWithoutTreasures[r].length; c++)
                            System.out.print(mapWithoutTreasures[r][c]);
                            System.out.println();
                    }
                    System.out.println("\nAare!\n");
                    treasuresLeftCounter -= 1;
                    moveCounter += 1;
                }
                if ((makeMove(intValues2[0], intValues2[1])) == 0) {
                    mapWithoutTreasures[intValues2[0] - 1][intValues2[1] - 1] = " ";
                    System.out.print("\n");
                    for (int r = 0; r < mapWithoutTreasures.length; r++) {
                        for (int c = 0; c < mapWithoutTreasures[r].length; c++)
                            System.out.print(mapWithoutTreasures[r][c]);
                            System.out.println();
                    }
                    moveCounter += 1;
                }
            }
        }
        if (treasuresLeftCounter == 0) {
            String endQuestion = input("Mäng läbi! Kokku tehti " + moveCounter + " kaevamist.\nKas soovid veel mängida? ");
            if (endQuestion.equals("jah")) {
                treasuresLeftCounter = 0;
                moveCounter = 0;
                start = true;
            }
            else {
                start = false;
            }
        }
        return false;
    }
}
