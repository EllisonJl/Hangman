package stacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static stacs.GameView.hangmanImages;

class GameControlTest {
    private GameControl game;

    @BeforeEach
    void setUp() {
        game = new GameControl("maven");
    }

    @Test
    void testInitialization() {
        assertEquals("_____", game.getCurrentGuessWord(), "Initial guess word should be all underscores");
        assertEquals("maven", game.getGuessWord(), "The guess word should be stored in lowercase");
    }

    @Test
    void testCorrectGuess() {
        assertTrue(game.guessResult('v'), "Guessing a correct letter should return true");
        assertEquals("__v__", game.getCurrentGuessWord(), "The current guess word should update correctly for correct guesses");
        assertTrue(game.getAlreadyGuessedLetters().contains('v'), "The guessed letter 'a' should be recorded");
    }

    @Test
    void testIncorrectGuess() {
        assertFalse(game.guessResult('z'), "Guessing an incorrect letter should return false");
        assertFalse(game.guessResult('z'), "Guessing an incorrect letter should return false");
        assertFalse(game.guessResult('z'), "Guessing an incorrect letter should return false");
        assertEquals(3, game.getRemainingTimes(), "The remaining times should decrease by 1 for incorrect guesses");
        assertTrue(game.getAlreadyGuessedLetters().contains('z'), "The guessed letter 'z' should be recorded");
    }

    @Test
    void testWinCondition() {
        "maven".chars().forEach(c -> game.guessResult((char) c));
        assertTrue(game.isWordEqual(), "The game should recognize when the word has been correctly guessed");
    }

    @Test
    void testLoseCondition() {
        for (int i = 0; i < 6; i++) {
            game.guessResult('s');
        }
        assertFalse(game.isAttempt(), "The game should end when there are no remaining attempts");
    }

    @Test
    void testHangmanImageAfterFiveIncorrectGuesses() {
        for (int i = 0; i < 5; i++) {
            game.guessResult('x');
        }
        assertEquals(hangmanImages[5], game.getHangmanImage(), "The hangman image should correspond to the number of remaining times after five incorrect guesses.");
    }
}
