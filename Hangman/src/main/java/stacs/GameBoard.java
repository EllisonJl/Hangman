package stacs;

public class GameBoard {

    /** This method is mainly used to print the relevant information of game to the console.
     * this method print
    */
    public static void interfaceState(Hangman game) {
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

}
