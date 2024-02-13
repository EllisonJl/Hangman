package stacs;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This class use to generate the random word from word list file.
 */
public class GameWord {
    /**
     * Retrieves a random word from a predefined list of words.
     * This method reads words from a text file located in the resources directory ("/wordlist.txt"),
     * filters out any empty lines to ensure only valid words are added to the list, and then
     * selects one word at random from this list. The randomness is achieved using the `Random`
     * class, ensuring that each invocation can potentially return a different word.
     *
     * @return A randomly selected word from the list. If the word list is empty or if there
     *         is an error reading the file, the method returns null.
     */
    public static String getRandomWord() {
        List<String> receiveWords = new ArrayList<>();
        Random random = new Random(); // Create a random instance.
        try (InputStream is = GameControl.class.getResourceAsStream("/wordlist.txt");
             Scanner scanner = new Scanner(is,"UTF-8")) {//Creates a Scanner object to read text from the InputStream with UTF-8 encoding.
            while (scanner.hasNextLine()) { // Continuous to read the contex from the file.
                String line = scanner.nextLine();
                if (!line.isEmpty()) { // The word from file will add into receiveWords instance if the line is not empty.
                    receiveWords.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        if (receiveWords.isEmpty()) {
            return null;
        }

        int randomIndex = random.nextInt(receiveWords.size()); // Generates a random index between 0 and the size of the receiveWords list (exclusive), effectively selecting a word at random from the list.
        return receiveWords.get(randomIndex); // Return the word randomly selected index from the receiveWords list.
    }
}
