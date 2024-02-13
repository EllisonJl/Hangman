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
        System.out.println("Current guess word: " + game.getCurrentGuessWord());
        System.out.println("Remaining times: " + game.getRemainingTimes());
        System.out.println("Guessed letters: " + game.getAlreadyGuessedLetters());
        System.out.println(game.getHangmanImage());
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
            "+---+\n|   |\n|    \n|    \n|    \n|\n=======",
            "+---+\n|   |\n|   O\n|    \n|    \n|\n=======",
            "+---+\n|   |\n|   O\n|   |\n|    \n|\n=======",
            "+---+\n|   |\n|   O\n|  /|\n|    \n|\n=======",
            "+---+\n|   |\n|   O\n|  /|\\\n|    \n|\n=======",
            "+---+\n|   |\n|   O\n|  /|\\\n|  / \n|\n=======",
            "+---+\n|   |\n|   O\n|  /|\\\n|  / \\\n|\n=======",
    };

    /**
     * This method use to generate underlines base on the length of the word player need to guess.
     * @param guessWord The word player need to guess in the game.
     * @return A string of underscores representing the unguessed state of the guessWord.
     */
    public static String underlineWord(String guessWord){
        StringBuilder underline = new StringBuilder();
        for (int i = 0; i< guessWord.length(); i++){ // Adding the underscores according to the length of word.
            underline.append("_");
        }
        return underline.toString();
    }

    /**
     * Initializes and runs the Hangman game user interface.
     * This method sets up the game by initializing it and then enters the game loop
     * where it manages user input and game state until the game ends.
     */
    public static void hangManGui() {
        Scanner scanner = new Scanner(System.in); // Initialize the Scanner object to receive user's input from console.
        GameControl game = initializeGame(); // Initialize game's state.
        if (game == null) return; // The method will exit if the word list is null.
        runGameLoop(game, scanner); // Responsible for dealing with game circle.
        displayGameResult(game); // Deal with the game result.
    }

    /**
     * Initializes the game with a word player need to guess.
     * This method attempts to start a new game by selecting a random word. If no word is available,
     * it indicates failure to start the game by returning null.
     *
     * @return A GameControl instance initialized with a random guess word.
     */
    public static GameControl initializeGame() {
        String guessWord = getRandomWord(); // Using getRandonWord method to acquire a random word for the word list.
        if (guessWord == null) {
            System.out.println("Word list is empty");
            return null;
        }
        return new GameControl(guessWord);
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
        System.out.println("Hangman game start");
        while (!game.isWordEqual() && game.isAttempt()) { // Judging whether the game is over or not.
            System.out.println("Please guess a letter:");
            String input = scanner.nextLine().trim(); // Eliminating the space of letter in two sides.
            if (input == null || input.isEmpty()) { // Judging whether the input is null or not.
                System.out.println("No input detected. Please enter a letter.");
                continue;
            }
            char guess = input.toLowerCase().charAt(0);// The game will transfer the letter player input into lower case. Then take the first letter player input.
            if (!Character.isLetter(guess)) { // If the player enters something other than a letter, a prompt will be displayed.
                System.out.println("Invalid input. Please enter a letter.");
                continue;
            }
            game.guessResult(guess); // Update the game state with the user's guessed letter
            GameView.interfaceState(game); // Update interface information based on current game status
        }
    }
    /**
     * Displays the result of the game once it concludes.
     * This method informs the player of the outcome of the game, displaying a congratulatory message if they win,
     * or a game over message along with the correct word if they lose.
     *
     * @param game The game instance for which to display the result.
     */
    public static void displayGameResult(GameControl game) {
        if (game.isWordEqual()) { // Judging whether the word player has guessed is equal to the word the game has given or not.
            System.out.println("\nCongratulations, you've won! The word was: " + game.getGuessWord());
        } else {
            System.out.println("\nGame over. The word was: " + game.getGuessWord());
        }
    }
}
