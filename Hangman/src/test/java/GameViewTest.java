package stacs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class GameViewTest {

    private GameControl game;
    private List<String> testWords;
    private String selectedWord;
    private Random random = new Random();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        testWords = Arrays.asList("maven", "debug", "cache");
        selectedWord = testWords.get(random.nextInt(testWords.size()));
        game = new GameControl(selectedWord);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testInitialization() {
        assertEquals("_".repeat(selectedWord.length()), game.getCurrentGuessWord());
    }

    @Test
    void testWinCondition() {
        for (char letter : selectedWord.toCharArray()) {
            game.guessResult(letter);
        }
        assertTrue(game.isWordEqual());
    }

    @Test
    void testInterfaceStateOutput() {
        GameView.interfaceState(game);
        String expectedOutput = "Current guess word: " + game.getCurrentGuessWord() + System.lineSeparator() +
                "Remaining times: " + game.getRemainingTimes() + System.lineSeparator() +
                "Guessed letters: " + game.getAlreadyGuessedLetters() + System.lineSeparator() +
                game.getHangmanImage() + System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }

    @Test
    void testDisplayGameResultOutput() {
        selectedWord = "debug";
        game = new GameControl(selectedWord);

        game.guessResult('d');
        game.guessResult('e');
        game.guessResult('b');
        game.guessResult('u');
        game.guessResult('g');

        GameView.displayGameResult(game);
        assertTrue(outputStreamCaptor.toString().trim().contains("Congratulations, you've won!"), "The output should contain the win message.");
    }


    @Test
    void testDisplayGameResultLossOutput() {
        for (int i = 0; i < game.getRemainingTimes(); i++) {
            game.guessResult('z');
        }
        GameView.displayGameResult(game);
        assertTrue(outputStreamCaptor.toString().trim().contains("Game over."));
    }
}
