
public class AdditionGame {

	public int getMaximumPoints(int A, int B, int C, int N) {
		int pointsEarned = 0;
		for (int i = N; i > 0; i--) {
			// choose highest number
			if (A > 0 && A >= B && A >= C) {
				pointsEarned += A;
				A--;
				continue;
			}
			if (B > 0 && B >= A && B >= C) {
				pointsEarned += B;
				B--;
				continue;
			}
			if (C > 0 && C >= A && C >= B) {
				pointsEarned += C;
				C--;
				continue;
			}
		}
		return pointsEarned;
	}

	public static void main(String[] args) {
		AdditionGame additionGame = new AdditionGame();
		System.out.println(additionGame.getMaximumPoints(3, 5, 48, 40));
	}

}
