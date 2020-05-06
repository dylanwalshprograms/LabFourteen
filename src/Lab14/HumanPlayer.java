package Lab14;
import java.util.Scanner;

public class HumanPlayer extends Player {
	
	private Scanner scnr;

	public HumanPlayer(String name, Scanner scnr) {
		super(name);
		this.scnr = scnr;
	}

	@Override
	public Roshambo generateRoshambo() {
		String input = Validator.getStringMatchingRegex(scnr, "Rock, paper, or scissors? (R/P/S): ", "[rps]");
		if (input.startsWith("r")) {
			return Roshambo.ROCK;
		} else if (input.startsWith("p")) {
			return Roshambo.PAPER;
		} else {
			return Roshambo.SCISSORS;
		}
	}

}