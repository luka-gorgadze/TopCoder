

public class AnswerEvaluation {

	public int getScore(String[] keywords, int[] scores, String answer) {
		int score = 0;
		String[] words = answer.split(" ");

		for (int i = 0; i < keywords.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if(keywords[i].equals(words[j])) {
					score += scores[i];
					break;
				}
			}
		}
		
		return score;
	}

}