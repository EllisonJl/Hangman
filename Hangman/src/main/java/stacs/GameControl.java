package stacs;

import java.util.ArrayList;
import java.util.List;
import static stacs.GameView.hangmanImages;

/**
 * The GameControl class is responsible for managing the state and logic of the Hangman game.
 * It maintains the current word that the player need to be guessed, tracks the letters that
 * have been guessed so far, and keeps count of the remaining attempts. This class offers
 * methods to process guesses, check game state.
 */
public class GameControl {


    /**
     * Constructs a GameControl object with the specified guess word.
     * Initializes the guess word in lowercase, sets up the initial state of the current guess word
     * as a series of underscores representing each letter.
     *
     * @param guessWord The word that needs to be guessed in the game.
     */
    public GameControl(String guessWord) {

    }

    /**
     * This method first converts the guessed letter to lowercase to ensure case-insensitive
     * comparison. It then checks if the guessed letter is part of the guess word by updating
     * the current guessed word state. Depending on whether the guess was correct, it updates
     * the remaining attempts and records the guessed letter. The method returns a boolean
     * indicating whether the guess was correct.
     *
     * @param guessedLetter The letter guessed by the player.
     * @return true if the guessed letter is part of the guess word, false otherwise.
     */
    public boolean guessResult(char guessedLetter) {


        return false; // Return the guessed result.
    }

    /**
     * This method use to checks if the current guessed word matches the original guess word exactly.
     *
     * @return true if the current guessed word matches the original word exactly, false otherwise.
     */
    public boolean isWordEqual(){

        return false;
    }

    /**
     * This method use to checks if the player has any attempts remaining to guess the word.
     * This method evaluates whether the player still has a chance to continue guess word
     *
     * @return true if there are remaining attempts left, false otherwise.
     */
    public boolean isAttempt(){

        return false;
    }

    /**
     * This method returns a string representation of the current guessed word, where each
     * correctly guessed letter is shown in its correct position and unguessed letters are represented
     * by underscores.
     *
     * @return A string representing the current state of the guessed word.
     */
    public String getCurrentGuessWord() {

        return "hello";
    }

    /**
     * Gets the number of remaining attempts the player has to guess the word.
     * This method returns the current count of attempts that the player has left before
     * the game is over.
     *
     * @return The number of remaining attempts.
     */
    public int getRemainingTimes() {

        return 6;
    }

    /**
     * Retrieves a list of characters that have already been guessed.
     * This method returns a list containing all the letters that the player has guessed so far,
     * regardless of whether those guesses were correct or incorrect.
     *
     * @return A List of Characters representing the letters already guessed by the player.
     */
    public List<Character> getAlreadyGuessedLetters() {

        return new ArrayList<>();
    }

    /**
     * This method mainly use to show Hangman's Images in the console log through the rest times
     * of guessing. The game will draw the head of Hangman if the player guess wrongly in first
     * time, then it would add different parts of Hangman as the remaining times decrease
     *
     * @return Return different parts of Hangman image.
     */
    public String getHangmanImage() {

        return hangmanImages[6];
    }

    /**
     * guessWord have used Private to decorate, so other class can't interview directly. This
     * method mainly use to return the guessWord variable to other classes.
     * @return Return guessWord to other class.
     */
    public String getGuessWord(){

        return "guessWord";
    }

    /**
     * Updates the current guessed word based on the player's guessed letter.
     * This method iterates through the original guess word, comparing each character with the
     * guessed letter. If a match is found, the corresponding underscore in the current guessed word
     * is replaced with the correct letter. It tracks whether the guessed letter was correct and
     * found in the guess word.
     *
     * @param guessedLetter The letter guessed by the player.
     * @return true if the guessed letter is part of the guess word, false otherwise.
     */
    private boolean updateCurrentGuessWord(char guessedLetter) {
        boolean isCorrect = false;

        return isCorrect;
    }

    /**
     * Updates the number of remaining attempts based on whether the last guess was correct.
     * If the guessed letter is incorrect, it decrements the `remainingTimes` counter
     *
     * @param isCorrect A boolean indicating whether the player's guess is correct.
     */
    private void updateRemainingTimes(boolean isCorrect) {

    }

    /**
     * Records a guessed letter by adding it to the list of already guessed letters.
     * If the guessed letter has not been guessed before, it is added to the `alreadyGuessedLetters`
     *
     * @param guessedLetter The letter that was guessed by the player.
     */
    private void recordGuessedLetter(char guessedLetter) {

    }
}