
import java.util.Arrays;

public class AfraidOfEven {

	public int[] restoreProgression(int[] seq) {
		int[] copy = new int[seq.length];
		int difference;
		int target;
		boolean isPossible;
		boolean existsElement;

		for (int i = seq[0]; i <= 1000000000; i *= 2) {
			for (int j = seq[1]; j <= 1000000000; j *= 2) {
				isPossible = true;
				System.arraycopy(seq, 0, copy, 0, seq.length);
				difference = j - i;
				target = j;
				for (int k = 2; k < seq.length; k++) {
					existsElement = false;
					target += difference;
					for (int z = seq[k]; z <= 1000000000; z *= 2) {
						if (z == target) {
							existsElement = true;
							copy[k] = z;
							break;
						}
					}
					if (existsElement == false) {
						isPossible = false;
						break;
					}
				}
				if (isPossible) {
					copy[0] = i;
					copy[1] = j;
					return copy;
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {
		AfraidOfEven afraidOfEven = new AfraidOfEven();
		int[] seq = { 7, 47, 5, 113, 73, 179, 53 };
		System.out.println(Arrays.toString(afraidOfEven.restoreProgression(seq)));

	}

}