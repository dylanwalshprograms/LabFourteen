package Lab14;
import java.util.Scanner;

public class RoshamboApp {

	private static Scanner scnr = new Scanner(System.in);
	private static int wins = 0;
	private static int losses = 0;
	
	public static void main(String[] args) {
		System.out.println("Welcome to roshambo!");
		System.out.println();
		Player player1 = createHumanPlayer();
		System.out.println();
		Player player2 = selectOpponent();
		boolean keepGoing;
		do {
			roshamboGame(player1, player2);
			keepGoing = Validator.getYesOrNo(scnr, "Play again? (y/n)");
		}while (keepGoing);
		System.out.println(player1.getName() + " won " + wins + " times");
		System.out.println(player2.getName() + " won " + losses + " times");
		System.out.println("Thanks for playing!");
	}
	
	private static void roshamboGame(Player player1, Player player2) {
		Roshambo hand1 = player1.generateRoshambo();
		Roshambo hand2 = player2.generateRoshambo();
		System.out.println(player1.getName() + " played " + hand1);
		System.out.println(player2.getName() + " played " + hand2);
		System.out.println();
		if (hand1 == Roshambo.ROCK && hand2 == Roshambo.PAPER) {
			System.out.println(player2.getName() + " wins!");
			losses++;
		}
		else if (hand1 == Roshambo.ROCK && hand2 == Roshambo.SCISSORS) {
			System.out.println(player1.getName() + " wins!");
			wins++;
		}
		else if (hand1 == Roshambo.PAPER && hand2 == Roshambo.ROCK) {
			System.out.println(player1.getName() + " wins!");
			wins++;
		}
		else if (hand1 == Roshambo.SCISSORS && hand2 == Roshambo.ROCK) {
			System.out.println(player2.getName() + " wins!");
			losses++;
		}
		else if (hand1 == Roshambo.PAPER && hand2 == Roshambo.SCISSORS) {
			System.out.println(player2.getName() + " wins!");
			losses++;
		}
		else if (hand1 == Roshambo.SCISSORS && hand2 == Roshambo.PAPER) {
			System.out.println(player1.getName() + " wins!");
			wins++;
		}
		else {
			System.out.println("Tie!");
		}
	}
	
	private static Player selectOpponent() {
		String input = Validator.getString(scnr, "Would you like to face Ronny, Racheal, or Peter?").toLowerCase();

		if (input.startsWith("ro")) {
			return new RockPlayer("Ronny");
		} else if (input.startsWith("ra")){
			return new RandomPlayer("Racheal");
		} else {
			return new PaperPlayer("Peter");
		}
	}
	
	private static HumanPlayer createHumanPlayer() {
		// Pick name
		System.out.print("What's your name? ");
		String name = scnr.nextLine();
		// Create player
		return new HumanPlayer(name, scnr);
	}
}