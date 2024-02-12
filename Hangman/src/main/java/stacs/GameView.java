package stacs;

import java.util.Scanner;
import static stacs.GameWord.getRandomWord;

public class GameView {

    /** This method is mainly used to print the relevant information of game to the console.
     * this method print
    */
    public static void interfaceState(GameControl game) {
        System.out.println("Current guess word: " + game.getCurrentGuessWord());
        System.out.println("Remaining times: " + game.getRemainingTimes());
        System.out.println("Guessed letters: " + game.getAlreadyGuessedLetters());
        System.out.println(game.getHangmanImage());
    }

    public static String[] hangmanImages = {
            "+---+\n|   |\n|   O\n|  /|\\\n|  / \\\n|\n=======",
            "+---+\n|   |\n|   O\n|  /|\\\n|  / \n|\n=======",
            "+---+\n|   |\n|   O\n|  /|\\\n|    \n|\n=======",
            "+---+\n|   |\n|   O\n|  /|\n|    \n|\n=======",
            "+---+\n|   |\n|   O\n|   |\n|    \n|\n=======",
            "+---+\n|   |\n|   O\n|    \n|    \n|\n=======",
            "+---+\n|   |\n|    \n|    \n|    \n|\n======="
    };

    public static String underlineWord(String guessWord){
        StringBuilder underline = new StringBuilder();
        for (int i = 0; i< guessWord.length(); i++){
            underline.append("_");
        }
        return underline.toString();
    }

    public static void hangManGui() {
        Scanner scanner = new Scanner(System.in);
        GameControl game = initializeGame();
        if (game == null) return;
        runGameLoop(game, scanner);
        displayGameResult(game);
    }

    public static GameControl initializeGame() {
        String guessWord = getRandomWord();
        if (guessWord == null) {
            System.out.println("Word list is empty");
            return null; // 返回null表示初始化失败
        }
        return new GameControl(guessWord); // 返回游戏实例
    }

    public static void runGameLoop(GameControl game, Scanner scanner) {
        System.out.println("Hangman game start");
        while (!game.isWordEqual() && game.isAttempt()) {
            System.out.println("Please guess a letter:");
            String input = scanner.nextLine().trim();
            if (input == null || input.isEmpty()) {
                System.out.println("No input detected. Please enter a letter.");
                continue;
            }
            char guess = input.toLowerCase().charAt(0);
            if (!Character.isLetter(guess)) {
                System.out.println("Invalid input. Please enter a letter.");
                continue;
            }
            game.guessResult(guess);
            GameView.interfaceState(game);
        }
    }

    public static void displayGameResult(GameControl game) {
        if (game.isWordEqual()) {
            System.out.println("\nCongratulations, you've won! The word was: " + game.getGuessWord());
        } else {
            System.out.println("\nGame over. The word was: " + game.getGuessWord());
        }
    }
}
