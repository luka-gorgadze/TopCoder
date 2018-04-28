

public class AlmostPerfectNumber {

	public int count(int left, int right, int k) {
		int perfectNumberCounter = 0;
		int sumOfDivisors;

		for (int i = left; i <= right; i++) {
			sumOfDivisors = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sumOfDivisors += j;
				}
			}
			if (Math.abs(i - sumOfDivisors) <= k) {
				perfectNumberCounter++;
			}
		}

		return perfectNumberCounter;
	}

	public static void main(String[] args) {
		AlmostPerfectNumber almostPerfectNumber = new AlmostPerfectNumber();
		System.out.println(almostPerfectNumber.count(11, 20, 50));
	}

}
