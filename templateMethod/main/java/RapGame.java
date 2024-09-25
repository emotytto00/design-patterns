import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class RapGame extends GameClass {
    private int numberOfPlayers;
    private int maxRounds;
    private int currentRound;
    private ArrayList<String[]> rhymes;
    private Scanner scanner;
    private int failedPlayer = -1;
    private int winner = -1;
    private Random random;

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.maxRounds = 5;
        this.currentRound = 0;
        this.rhymes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        System.out.println("Yo yo yo! Rap game is starting with " + numberOfPlayers + " MC's.");
        System.out.println("Each MC will drop some banging bars. The game ends after " + maxRounds + " rounds or if a MC fumbles yo.");
    }

    @Override
    public boolean endOfGame() {
        return currentRound >= maxRounds || failedPlayer != -1;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("MC " + (player + 1) + "'s turn to spit some heat!");

        System.out.print("First rhyme: ");
        String firstRhyme = scanner.nextLine();

        // Get the second rhyme
        System.out.print("Second rhyme: ");
        String secondRhyme = scanner.nextLine();

        if (!isValidRhymePair(firstRhyme, secondRhyme)) {
            System.out.println("MC " + (player + 1) + " failed to rhyme! That's wack yo.");
            failedPlayer = player;
        } else {
            rhymes.add(new String[]{firstRhyme, secondRhyme});  // Add the rhyme pair to the list
            System.out.println("MC " + (player + 1) + " dropped a banger!");
        }

        currentRound++;
    }

    @Override
    public void displayWinner() {
        if (failedPlayer != -1) {
            System.out.println("MC " + (failedPlayer + 1) + " lost the game by failing to rhyme. Better luck next time G!");
            winner = (failedPlayer == 0) ? numberOfPlayers - 1 : failedPlayer - 1;
        } else {
            System.out.println("All MC's dropped bangers! Winner will be announced shortly...");
            winner = random.nextInt(numberOfPlayers);
        }
        System.out.println("MC " + (winner + 1) + " is the rapsuperstar!");
    }

    private boolean isValidRhymePair(String firstRhyme, String secondRhyme) {
        if (firstRhyme.trim().length() < 2 || secondRhyme.trim().length() < 2) {
            return false;
        }

        String lastTwoCharsFirst = firstRhyme.substring(firstRhyme.length() - 2).toLowerCase();
        String lastTwoCharsSecond = secondRhyme.substring(secondRhyme.length() - 2).toLowerCase();

        return lastTwoCharsFirst.equals(lastTwoCharsSecond);
    }

    public static void main(String[] args) {
        GameClass rapGame = new RapGame();
        rapGame.play(3);
    }
}