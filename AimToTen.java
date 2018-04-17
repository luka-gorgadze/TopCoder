
public class AimToTen {

	public int need(int[] marks) {
		int countMarks = 0;
		int sum = 0;

		// count sum of all marks
		for (int i = 0; i < marks.length; i++) {
			sum += marks[i];
		}

		// add another 10 until average isn't less than 9.5
		while (((double) sum) / (marks.length + countMarks) < 9.5D) {
			sum += 10;
			countMarks++;
		}
		
		return countMarks;
	}

	public static void main(String[] args) {
		AimToTen att = new AimToTen();
		int[] marks = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(att.need(marks));
	}

}
