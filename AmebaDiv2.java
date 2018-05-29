

public class AmebaDiv2 {

	public int simulate(int[] X, int A) {
		int amebasSize = A;
		for (int i = 0; i < X.length; i++) {
			if (amebasSize == X[i]) {
				amebasSize *= 2;
			}
		}
		
		return amebasSize;
	}

	public static void main(String[] args) {
		AmebaDiv2 amebaDiv2 = new AmebaDiv2();
		int[] X = {817,832,817,832,126,817,63,63,126,817,832,287,823,817,574};
		System.out.println(amebaDiv2.simulate(X, 63));
	}

}
