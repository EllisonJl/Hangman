package stacs;

import java.util.ArrayList;
import java.util.List;
import static stacs.GameView.hangmanImages;

public class GameControl {
    private final String guessWord; //Reserving the word that user need to guess.
    private final StringBuilder currentGuessWord; //Reserving the current state that user guessed.
    private final List<Character> alreadyGuessedLetters = new ArrayList<>(); //Reserving the words which are guessed.
    private int remainingTimes = 6; //Reserving current remaining times.

    public GameControl(String guessWord) {
        this.guessWord = guessWord.toLowerCase(); //将输入的文本单词转化为小写
        this.currentGuessWord = new StringBuilder(GameView.underlineWord(guessWord));
    }

    public boolean isWordEqual(){
        return guessWord.equals(currentGuessWord.toString());
    }

    public boolean isAttempt(){
        return remainingTimes > 0;
    }

    public String getCurrentGuessWord() {
        return currentGuessWord.toString();
    }

    public int getRemainingTimes() {
        return remainingTimes;
    }

    public List<Character> getAlreadyGuessedLetters() {
        return alreadyGuessedLetters;
    }

    public String getHangmanImage() {
        int index = remainingTimes; // 从0到6的索引
        return hangmanImages[index];
    }

    public String getGuessWord(){
        return guessWord;
    }
    private boolean updateCurrentGuessWord(char guessedLetter) {
        boolean isCorrect = false;
        for (int j = 0; j < currentGuessWord.length(); j++) {
            if (guessWord.charAt(j) == guessedLetter) {
                currentGuessWord.setCharAt(j, guessedLetter);
                isCorrect = true;
            }
        }
        return isCorrect;
    }

    private void updateRemainingTimes(boolean isCorrect) {
        if (!isCorrect) {
            remainingTimes--;
        }
    }

    private void recordGuessedLetter(char guessedLetter) {
        if (!alreadyGuessedLetters.contains(guessedLetter)) {
            alreadyGuessedLetters.add(guessedLetter);
        }
    }

    public boolean guessResult(char guessedLetter) {
        guessedLetter = Character.toLowerCase(guessedLetter);

        boolean isCorrect = updateCurrentGuessWord(guessedLetter);

        updateRemainingTimes(isCorrect);

        recordGuessedLetter(guessedLetter);

        return isCorrect;
    }
}