package stacs;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static stacs.GameBoard.hangmanImages;

public class Hangman {
    private final String guessWord; //Reserving the word that user need to guess.
    private final StringBuilder currentGuessWord; //Reserving the current state that user guessed.
    private int remainingTimes = 6; //Reserving current remaining times.
    private final List<Character> alreadyGuessedLetters = new ArrayList<>(); //Reserving the words which are guessed.
    public static void main(String[] args) {
        String guessWord = getRandomWord();
        Hangman game =new Hangman(guessWord);
        Scanner scanner = new Scanner(System.in);
        if (guessWord == null) {
            System.out.println("Word list is empty");
            return;
        }
        System.out.println("Hangman game star");
        while (!game.isWordEqual() && game.isAttempt()){
            System.out.println("Please guess a letter:");
            String input = scanner.nextLine().trim(); // 移除输入两端的空白字符
            if (input == null || input.isEmpty()) {
                System.out.println("No input detected. Please enter a letter.");
                continue; // 如果用户没有输入，提示重新输入
            }
            char guess = input.toLowerCase().charAt(0); // 取输入的第一个字符作为猜测的字母
            if (!Character.isLetter(guess)) {
                System.out.println("Invalid input. Please enter a letter.");
                continue; // 确保用户输入的是字母
            }
            game.guessResult(guess);
            GameBoard.interfaceState(game);
        }
        if (game.isWordEqual()) {
            System.out.println("\nCongratulations, you've won! The word was: " + game.guessWord);
        } else {
            System.out.println("\nGame over. The word was: " + game.guessWord);
        }
    }

    public Hangman(String guessWord) {
        this.guessWord = guessWord.toLowerCase(); //将输入的文本单词转化为小写
        this.currentGuessWord = new StringBuilder(GameBoard.underlineWord(guessWord));
    }

    public boolean guessResult(char guessedLetter){
        boolean isCorrect = false;
        guessedLetter = Character.toLowerCase(guessedLetter); //将用户输入的字母转化为小写

        for (int j = 0; j< currentGuessWord.length(); j++){
            if ( guessWord.charAt(j) == guessedLetter){
                currentGuessWord.setCharAt(j,guessedLetter);
                isCorrect = true;
            }
        }
        if (!isCorrect) {
            remainingTimes--;
        }

        if (!alreadyGuessedLetters.contains(guessedLetter)) {
            alreadyGuessedLetters.add(guessedLetter);
        }
        return isCorrect;
    }

    public boolean isWordEqual(){
        return guessWord.equals(currentGuessWord.toString());
    }

    public boolean isAttempt(){
        return remainingTimes > 0;
    }

    public static String getRandomWord() {
        List<String> receiveWords = new ArrayList<>();
        Random random = new Random();
        try (InputStream is = Hangman.class.getResourceAsStream("/wordlist.txt");
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
        int index = 6 - remainingTimes; // 从0到6的索引
        return hangmanImages[index];
    }

}