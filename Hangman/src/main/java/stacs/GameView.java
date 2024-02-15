package stacs;

import java.util.Scanner;
import static stacs.GameWord.getRandomWord;

/**
 * The GameView use to show the game's information of state. It is included the letter that the
 * player has guessed, the remaining times of guessing, letters that the player has guessed and
 * showed the hangman's body. Besides, this class also show the prompt information in the console
 * if player input right or invalid character.
 */
public class GameView {
    /**
     * This method is mainly used to print the relevant information of game to the console.
     * This method print the current state , remaining time of guessing, the letter player has
     * been guessed and draw the different part of Hangman to console.
     *
     * @param game The GameControl object that contains the game's current state information.
    */
    public static void interfaceState(GameControl game) {

    }

    /**
     * This method draw the different parts of Hangman's body
     *Drawn from bottom to top are Hangman's head, body, left hand, right hand, left foot, and
     *right foot.
     *Player can see the progress of the game through Hangman's body.
     *
     *hangmanImages[0]: Drawing the head of Hangman.
     *hangmanImages[1]: Drawing the body of Hangman.
     *hangmanImages[2]: Drawing the left hand of Hangman.
     *hangmanImages[3]: Drawing the right hand of Hangman.
     *hangmanImages[4]: Drawing the left leg of Hangman.
     *hangmanImages[5]: Drawing the right leg of Hangman.
     */
    public static String[] hangmanImages = {

    };

    /**
     * This method use to generate underlines base on the length of the word player need to guess.
     * @param guessWord The word player need to guess in the game.
     * @return A string of underscores representing the unguessed state of the guessWord.
     */
    public static String underlineWord(String guessWord){
        

        return "underline";
    }

    /**
     * Initializes and runs the Hangman game user interface.
     * This method sets up the game by initializing it and then enters the game loop
     * where it manages user input and game state until the game ends.
     */
    public static void hangManGui() {

    }

    /**
     * Initializes the game with a word player need to guess.
     * This method attempts to start a new game by selecting a random word. If no word is available,
     * it indicates failure to start the game by returning null.
     *
     * @return A GameControl instance initialized with a random guess word.
     */
    public static GameControl initializeGame() {

        GameControl GameControl = null;
        return GameControl;
    }

    /**
     * Executes the game loop, accepting user input and updating the game state until the game concludes.
     * This method keeps the game active by prompting the player to guess letters, processing those guesses,
     * and updating the game state accordingly until the player either wins or runs out of attempts.
     *
     * @param game The current game instance to be played.
     * @param scanner The scanner object used to read user input.
     */
    public static void runGameLoop(GameControl game, Scanner scanner) {
 
    }

    /**
     * Displays the result of the game once it concludes.
     * This method informs the player of the outcome of the game, displaying a congratulatory message if they win,
     * or a game over message along with the correct word if they lose.
     *
     * @param game The game instance for which to display the result.
     */
    public static void displayGameResult(GameControl game) {

    }
}
