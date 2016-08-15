import java.util.Arrays;
/**
 * Created by Ruusa on 15.02.2016.
 */
public class EX03 {

    /**
     * Given text and a rotation, encrypts text.
     * @param plainText plain text, readable by humanoids
     *                  with relative ease.
     * @param rotation
     * @return encrypted text
     */
    public static String encrypt(String plainText, int rotation) {
        if (plainText == null) {
            return null;}
        if (plainText.length() == 0) {
            return plainText;}
        int length = plainText.length();
        plainText = plainText.toLowerCase();
        char[] encodedTextInChars = new char[length];
        for (int i = 0; i < length; i ++) {
            char charInString = plainText.charAt(i);
            int charAsciiValue = (int) charInString;
            int newCharAsciiValue = charAsciiValue + rotation;
            if (charAsciiValue > 0 && charAsciiValue < 65 ) { // kui ascii väärtus on märgid, numbrid või tühik, siis jääb samaks
                newCharAsciiValue = charAsciiValue;}
            if (newCharAsciiValue > 122) {
                newCharAsciiValue = newCharAsciiValue - 26;}
            char newChar = (char) newCharAsciiValue;
            encodedTextInChars[i] = newChar;
        }
        String encodedTextWithoutMinimize = new String(encodedTextInChars);
        String encodedText = minimizeText(encodedTextWithoutMinimize);
        return encodedText;
    }

    /**
     * Finds the most frequently occurring letter in text.
     * @param text either plain or encrypted text.
     * @return the most frequently occurring letter in text.
     */
    public static String findMostFrequentlyOccurringLetter(String text) {
        if (text == null) {
            return null;}
        if (text.length() == 0) {
            return text;}
        int length = text.length();
        char[] textInChars = new char[length];
        for (int i = 0; i < length; i++) {
            textInChars[i] = text.charAt(i);}
        Arrays.sort(textInChars);
        int[] charCount = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((int) textInChars[i] < 65 || (int) textInChars[i] > 122 || ((int) textInChars[i] > 90 && (int) textInChars[i] < 97)) {
                    charCount[i] = 0;}
                if (textInChars[i] == textInChars[j]) {
                    charCount[i] += 1;}
            }
        }
        int indexOfHighestValue = 0;
        int highestValue = 0;
        for (int i = 0; i < charCount.length; i++) {
            if (highestValue < charCount[i]) {
                highestValue = charCount[i];
                indexOfHighestValue = i;
            }
        }
        String mostFrequentChar = String.valueOf(textInChars[indexOfHighestValue]);
        return mostFrequentChar;
    }
    /**
     * Removes the most prevalent letter from text.
     * @param text either plain or encrypted text.
     * @return text in which the most prevalent letter has been removed.
     */
    public static String minimizeText(String text) {
        if (text == null) {
            return null;}
        if (text.length() == 0) {
            return text;}
        text = text.toLowerCase();
        String minimizedText = text.replace(findMostFrequentlyOccurringLetter(text), "");
        return minimizedText;
    }

    /**
     * Given the initial rotation and the encrypted text, this method
     * decrypts said text.
     * @param cryptoText Encrypted text.
     * @param rotation How many letters to the right the alphabet was
     *                 shifted in order to encrypt text.
     * @return Decrypted text.
     */
    public static String decrypt(String cryptoText, int rotation) {
        if (cryptoText == null) {
            return null;}
        if (cryptoText.length() == 0) {
            return cryptoText;}
        int length = cryptoText.length();
        cryptoText = cryptoText.toLowerCase();
        char[] encodedTextInChars = new char[length];
        for (int i = 0; i < length; i ++) {
            char charInString = cryptoText.charAt(i);
            int charAsciiValue = (int) charInString;
            int newCharAsciiValue = charAsciiValue - rotation;
            if (charAsciiValue > 0 && charAsciiValue < 65 ) {
                newCharAsciiValue = charAsciiValue;}
            if (newCharAsciiValue < 97 && newCharAsciiValue > 64) {
                newCharAsciiValue = newCharAsciiValue + 26;}
            char newChar = (char) newCharAsciiValue;
            encodedTextInChars[i] = newChar;
        }
        String encodedText = new String(encodedTextInChars);
        return encodedText;
    }

    /**
     * The main method, which is the entry point of the program.
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        System.out.println(encrypt("you too Brutus?", 1)); // => zv u csvuvt?
        // (both u and o appear 3 times, o comes earlier in alphabet)
        System.out.println(decrypt("zpv upp csvuvt?", 1)); // => you too brutus?
        System.out.println(findMostFrequentlyOccurringLetter("you too Brutus?")); // => o
        System.out.println(minimizeText("you too Brutus?")); // yu t brutus?
    }
}