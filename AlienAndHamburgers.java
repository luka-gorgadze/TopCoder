
public class AlienAndHamburgers {

	private void swap(int[] type, int[] taste, int i, int j) {
		int tempType = type[i];
		int tempTaste = taste[i];
		type[i] = type[j];
		taste[i] = taste[j];
		type[j] = tempType;
		taste[j] = tempTaste;
	}

	public int getNumber(int[] type, int[] taste) {
		int totalTaste = 0;
		int totalJoy;
		int numberOfTypes = 0;
		boolean[] haveTasted = new boolean[100];

		// sort arrays according to taste, insertion sort
		for (int i = 1; i < taste.length; i++) {
			for (int j = i; j > 0; j--) {
				if (taste[j] > taste[j - 1]) {
					swap(type, taste, j, j - 1);
				}
			}
		}

		// eat all hamburgers with non-negative taste
		int i = 0;
		while (i < taste.length && taste[i] >= 0) {
			totalTaste += taste[i];
			if (haveTasted[type[i] - 1] == false) {
				haveTasted[type[i] - 1] = true;
				numberOfTypes++;
			}
			i++;
		}

		totalJoy = totalTaste * numberOfTypes;

		// check which bad taste hamburgers will increase joy
		while (i < taste.length && totalJoy < (totalTaste + taste[i]) * (numberOfTypes + 1)) {
			if (haveTasted[type[i] - 1]) {
				i++;
				continue;
			} else {
				totalTaste += taste[i];
				haveTasted[type[i] - 1] = true;
				numberOfTypes++;
				totalJoy = totalTaste * numberOfTypes;
				i++;
			}
		}

		return totalTaste * numberOfTypes;
	}

	public static void main(String[] args) {
		AlienAndHamburgers alienAndHamburgers = new AlienAndHamburgers();
		int[] type = { 1, 2, 3, 2, 3, 1, 3, 2, 3, 1, 1, 1 };
		int[] taste = { 1, 7, -2, 3, -4, -1, 3, 1, 3, -5, -1, 0 };
		System.out.println(alienAndHamburgers.getNumber(type, taste));
	}

}
