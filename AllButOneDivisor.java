

public class AllButOneDivisor {

	public int getMinimum(int[] divisors) {
		int divisorCounter;
		int maximumPossibleAnswer = 11 * 12 * 13 * 14 * 15;
		for (int i = 0; i < maximumPossibleAnswer; i++) {
			divisorCounter = 0;
			for (int j = 0; j < divisors.length; j++) {
				if(i % divisors[j] == 0) {
					divisorCounter++;
				}
			}
			// if exactly k - 1 divisors - we found the answer
			if(divisorCounter == divisors.length - 1) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		AllButOneDivisor allButOneDivisor = new AllButOneDivisor();
		int[] divisors = {6,7,8,9,10};
		System.out.println(allButOneDivisor.getMinimum(divisors));
	}

}