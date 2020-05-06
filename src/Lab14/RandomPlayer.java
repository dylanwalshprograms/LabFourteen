package Lab14;

import java.util.Random;

public class RandomPlayer extends Player{

	public RandomPlayer(String name) {
		super(name);
	}

	@Override
	public Roshambo generateRoshambo() {
		Random randGen = new Random();
		int randomNumber = randGen.nextInt(3) + 1;
		if (randomNumber == 1) {
			return Roshambo.PAPER;
		}
		else if (randomNumber == 2) {
			return Roshambo.ROCK;
		}
		else {
			return Roshambo.SCISSORS;
		}
	}
}
