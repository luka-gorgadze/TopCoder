

public class AmoebaDivTwo {

	public int count(String[] table, int K) {
		int placeCounter = 0;
		boolean canBePlaced;

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j <= table[i].length() - K; j++) {
				canBePlaced = true;
				for (int m = j; m < j + K; m++) {
					if (table[i].charAt(m) != 'A') {
						canBePlaced = false;
					}
				}
				if (canBePlaced == true) {
					placeCounter++;
				}
			}
		}

		if (K != 1) {
			for (int i = 0; i <= table.length - K; i++) {
				for (int j = 0; j < table[i].length(); j++) {
					canBePlaced = true;
					for (int m = i; m < i + K; m++) {
						if (table[m].charAt(j) != 'A') {
							canBePlaced = false;
						}
					}
					if (canBePlaced == true) {
						placeCounter++;
					}
				}
			}
		}
		
		return placeCounter;
	}

	public static void main(String[] args) {
		AmoebaDivTwo amoebaDivTwo = new AmoebaDivTwo();
		String[] table = { "AAM", "MAM", "AAA" };
		System.out.println(amoebaDivTwo.count(table, 1));

	}

}
