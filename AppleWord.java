

public class AppleWord {

	public int minRep(String word) {
		int changeCounter = 0;
		String lowerCaseWord = word.toLowerCase();

		if (word.length() < 5) {
			return -1;
		}

		if (lowerCaseWord.charAt(0) != 'a') {
			changeCounter++;
		}
		for (int i = 1; i < lowerCaseWord.length() - 2; i++) {
			if (lowerCaseWord.charAt(i) != 'p') {
				changeCounter++;
			}
		}
		if (lowerCaseWord.charAt(lowerCaseWord.length() - 2) != 'l') {
			changeCounter++;
		}
		if (lowerCaseWord.charAt(lowerCaseWord.length() - 1) != 'e') {
			changeCounter++;
		}

		return changeCounter;
	}

	public static void main(String[] args) {
		AppleWord appleWord = new AppleWord();
		System.out.println(appleWord.minRep("Apple"));

	}

}
