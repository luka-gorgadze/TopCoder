

public class Alliteration {

	public int count(String[] words) {
		int alliterationsCounter = 0;
		boolean soFarAlliteration = false;

		for (int i = 1; i < words.length; i++) {
			if (Character.toLowerCase(words[i].charAt(0)) != Character.toLowerCase(words[i - 1].charAt(0))) {
				soFarAlliteration = false;
			} else if (soFarAlliteration == false) {
				soFarAlliteration = true;
				alliterationsCounter++;
			}
		}

		return alliterationsCounter;
	}

	public static void main(String[] args) {
		Alliteration alliteration = new Alliteration();
		String[] words = { "Round", "the", "rugged", "rock", "the", "ragged", "rascal", "ran" };
		System.out.println(alliteration.count(words));

	}

}
