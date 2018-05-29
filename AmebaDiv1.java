
import java.util.HashSet;
import java.util.Set;

public class AmebaDiv1 {

	public int count(int[] X) {
		Set<Integer> notBelongNumbers = new HashSet<Integer>();

		for (int i = 0; i < X.length; i++) {
			if (!isPossible(X, X[i], X.length)) {
				notBelongNumbers.add(X[i]);
			}
		}

		return notBelongNumbers.size();
	}

	private boolean isPossible(int[] X, int number, int index) {
		boolean numberFound = false;
		for (int i = 0; i < index; i++) {
			if (X[i] == number) {
				numberFound = true;
			}
		}
		if (numberFound == false) {
			return true;
		}
		if (number % 2 == 1) {
			return false;
		}

		for (int i = index - 1; X[i] != number; i--) {
			if (X[i] == number / 2 && isPossible(X, number / 2, i)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		AmebaDiv1 amebaDiv1 = new AmebaDiv1();
		int[] X = {854,250,934,1000,281,250,281,467,854,562,934,1000,854,500,562};
		System.out.println(amebaDiv1.count(X));
	}

}
