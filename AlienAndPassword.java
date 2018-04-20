
public class AlienAndPassword {

	public int getNumber(String S) {
		int differentPasswords = 1;
		char previous = S.charAt(0);

		/*
		 * if same characters are in string next to each other, removal of each of them
		 * will give us same password
		 */
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) != previous) {
				differentPasswords++;
				previous = S.charAt(i);
			}
		}

		return differentPasswords;
	}

	public static void main(String[] args) {
		AlienAndPassword aap = new AlienAndPassword();
		System.out.println(aap.getNumber("AGAAGAHHHHFTQLLAPUURQQRRRUFJJSBSZVJZZZ"));
	}

}
