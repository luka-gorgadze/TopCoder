public class AkariDaisukiDiv2 {

	public int countTuples(String S) {
		int tupleCounter = 0;
		int lastXIndex;
		String X;

		// try all possible values for X
		for (int i = 1; i < S.length(); i++) {
			for (int j = i; j < S.length(); j++) {
				X = S.substring(i, j + 1);
				lastXIndex = i; // where was last X found
				while (true) {
					// find next occurrence of X
					lastXIndex = S.indexOf(X, lastXIndex + 1);

					// break if it wasn't found
					if (lastXIndex == -1) {
						break;
					}

					/*
					 * try to find another occurrence of X if this one leaves no space for Akari and
					 * Daisuki, else you've found one more suitable tuples
					 */
					if (i + X.length() >= lastXIndex || lastXIndex + X.length() == S.length()) {
						continue;
					} else {
						tupleCounter++;
					}

				}
			}
		}

		return tupleCounter;
	}

	public static void main(String[] args) {
		AkariDaisukiDiv2 akariDaisukiDiv2 = new AkariDaisukiDiv2();
		System.out.println(akariDaisukiDiv2.countTuples("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

	}

}