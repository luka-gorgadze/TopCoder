
public class AlphabetPath {

	public String doesItExist(String[] letterMaze) {
		int row = 0;
		int column = 0;
		boolean foundA = false;
		char currentCharacter;

		// find indices of A
		for (row = 0; row < letterMaze.length; row++) {
			for (column = 0; column < letterMaze[row].length(); column++) {
				if (letterMaze[row].charAt(column) == 'A') {
					foundA = true;
					break;
				}
			}
			if (foundA) {
				break;
			}
		}

		// try to reach Z from A, if at some point can't advance return "NO"
		currentCharacter = 'A';
		while (currentCharacter != 'Z') {
			if (row != 0) {
				if (letterMaze[row - 1].charAt(column) == currentCharacter + 1) {
					row--;
					currentCharacter++;
					continue;
				}
			}
			if (row != letterMaze.length - 1) {
				if (letterMaze[row + 1].charAt(column) == currentCharacter + 1) {
					row++;
					currentCharacter++;
					continue;
				}
			}
			if (column != 0) {
				if (letterMaze[row].charAt(column - 1) == currentCharacter + 1) {
					column--;
					currentCharacter++;
					continue;
				}
			}
			if (column != letterMaze[row].length() - 1) {
				if (letterMaze[row].charAt(column + 1) == currentCharacter + 1) {
					column++;
					currentCharacter++;
					continue;
				}
			}
			return "NO";
		}

		return "YES";
	}

	public static void main(String[] args) {
		AlphabetPath alphabetPath = new AlphabetPath();
		String[] letterMaze = { "ACBDEFGHIJKLMNOPQRSTUVWXYZ" };
		System.out.println(alphabetPath.doesItExist(letterMaze));
	}

}
