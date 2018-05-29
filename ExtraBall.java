import java.util.Set;
import java.util.HashSet;

public class ExtraBall {

	public double expectedPayout(int[] card, int[] balls, String[] patterns, int[] prizes) {
		Set<Integer> setOfBalls = new HashSet<>();
		for (int ball : balls) {
			setOfBalls.add(ball);
		}

		int ballsLeft = 75 - balls.length;
		double chanceOfSpecificBall = 1 / (double) ballsLeft;
		int sum = 0;

		for (int i = 0; i < patterns.length; i++) {
			boolean oneBallNeeded = false;
			for (int j = 0; j < patterns[i].length(); j++) {
				if (patterns[i].charAt(j) == 'X') {
					if (!setOfBalls.contains(card[j])) {
						if (oneBallNeeded) {
							oneBallNeeded = false;
							break;
						} else {
							oneBallNeeded = true;
						}
					}
				}
			}
			if (oneBallNeeded) {
				sum += prizes[i];
			}
		}

		return sum * chanceOfSpecificBall;
	}

}
