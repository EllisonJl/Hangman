package stacs;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameWord {
    public static String getRandomWord() {
        List<String> receiveWords = new ArrayList<>();
        Random random = new Random();
        try (InputStream is = GameControl.class.getResourceAsStream("/wordlist.txt");
             Scanner scanner = new Scanner(is,"UTF-8")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
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

        int randomIndex = random.nextInt(receiveWords.size());
        return receiveWords.get(randomIndex);
    }
}
