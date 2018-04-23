import java.util.Arrays;

public class AddMultiply {

	public int[] makeExpression(int y) {
		int[] valuesOfX = new int[3];
		// try all possible values for x0 and x1, compute x2
		for(int i = -1000; i <= 1000; i++) {
			for(int j = -1000; j <= 1000; j++) {
				valuesOfX[2] = y - (i * j);
				// check if computed value of x2 is in range
				if(valuesOfX[2] >= -1000 && valuesOfX[2] <= 1000) {
					valuesOfX[0] = i;
					valuesOfX[1] = j;
					return valuesOfX;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		AddMultiply addMultiply = new AddMultiply();
		System.out.println(Arrays.toString(addMultiply.makeExpression(6)));

	}

}
