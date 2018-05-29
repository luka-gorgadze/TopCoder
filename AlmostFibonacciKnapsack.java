
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlmostFibonacciKnapsack {
	List<Integer> result = new ArrayList<>();
	List<Integer> currentResult = new ArrayList<>();
	List<Long> almostFibonaccis = new ArrayList<>();
	//List<Long> almostFibonacciSums = new ArrayList<>();

	public int[] getIndices(long x) {
		almostFibonaccis.add(0L);
		almostFibonaccis.add(2L);
		almostFibonaccis.add(3L);
		for (int i = 3; i < 89; i++) {
			almostFibonaccis.add(almostFibonaccis.get(i - 1) + almostFibonaccis.get(i - 2) - 1);
		}
		/*
		almostFibonacciSums.add(0L);
		for (int i = 1; i < 89; i++) {
			almostFibonacciSums.add(almostFibonacciSums.get(i - 1) + almostFibonaccis.get(i));
		}
		*/
		dfs(88, x);
		if (result.isEmpty()) {
			int[] noResult = { -1 };
			return noResult;
		} else {
			int[] intResult = new int[result.size()];
			for (int i = 0; i < intResult.length; i++) {
				intResult[i] = result.get(i);
			}
			return intResult;
		}

	}

	private void dfs(int index, long x) {
		if (result.isEmpty() == false) {
			return;
		}
		if (x == 0) {
			result.addAll(currentResult);
			return;
		}
		if (index <= 0) {
			return;
		}
		/*
		if (x > almostFibonacciSums.get(index)) {
			return;
		}
		*/
		if (x >= almostFibonaccis.get(index)) {
			currentResult.add(index);
			dfs(index - 1, x - almostFibonaccis.get(index));
			currentResult.remove(currentResult.size() - 1);
		}
		if (result.isEmpty()) {
			dfs(index - 1, x);
		}
	}

	public static void main(String[] args) {
		AlmostFibonacciKnapsack almostFibonacciKnapsack = new AlmostFibonacciKnapsack();
		System.out.println(Arrays.toString(almostFibonacciKnapsack.getIndices(148)));
	}

}
