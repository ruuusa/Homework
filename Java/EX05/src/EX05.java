
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Ruusa on 28.02.2016.
 */

public class EX05 {
    /** prints out examples.
     * @param args lol
     * */
    public static void main(final String[] args) {
        System.out.println(getNicelyFormattedMovie("tere|")); // null
        System.out.println(getNicelyFormattedMovie("2016-02-24|Movie1|description|8.0"));
        /*
Movie1
Release date: 24/02/2016
Description: description
Average rating: 8.0    <- no new line in the end
         */
    }
    /** Takes a string with |'s separating information and returns it as modified text.
     *
     * @param inputFilename is the input filename
     * @param outputFilename is the output filename
     * @return returns the number of movies in the file
     */
    public static int convert(final String inputFilename, final String outputFilename) {
        int numberOfMovies = 0;
        try {
            BufferedReader movieReader = Files.newBufferedReader(Paths.get(inputFilename));
            String lineFromFile = movieReader.readLine();
            BufferedWriter movieWriter = Files.newBufferedWriter(Paths.get(outputFilename));
            while (lineFromFile != null) {
                String[] randomString = lineFromFile.split("\n");
                String[] movieInfo = new String[randomString.length];
                for (int i = 0; i < randomString.length; i++) {
                    movieInfo[i] = getNicelyFormattedMovie(lineFromFile);
                    numberOfMovies += 1;
                }
                for (String aMovieInfo : movieInfo) movieWriter.write(aMovieInfo + "\n");
            }
            movieReader.close();
            movieWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberOfMovies;
    }

    /** Takes a string with |'s separating information and returns it as modified text.
     *
     * @param movieLine is the input string
     * @return returns the modified text
     */
    public static String getNicelyFormattedMovie(final String movieLine) {
        String[] movieInfo = movieLine.split("\\|");
        if (movieLine == null || movieLine.equals("") || movieInfo.length < 3) {
            return null;
        }
        return movieInfo[1] + "\nRelease date: " + movieInfo[0] + "\nDescription: " + movieInfo[2]
                + "\nAverage Rating: " + movieInfo[3];
    }
}
