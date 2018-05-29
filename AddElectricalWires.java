

public class AddElectricalWires {

	private int[] belongsToGrid;
	private int[] gridSize;

	private void dfs(int currentNode, int grid, String[] wires) {
		belongsToGrid[currentNode] = grid;
		gridSize[grid]++;
		for (int i = 0; i < wires[currentNode].length(); i++) {
			if (wires[currentNode].charAt(i) == '1' && belongsToGrid[i] == -1) {
				dfs(i, grid, wires);
			}
		}
	}

	public int maxNewWires(String[] wires, int[] gridConnections) {
		int biggestGridsSize = 0;
		int newConnections = 0;
		belongsToGrid = new int[wires.length];
		for (int i = 0; i < belongsToGrid.length; i++) {
			belongsToGrid[i] = -1;
		}
		gridSize = new int[gridConnections.length];

		for (int i = 0; i < gridConnections.length; i++) {
			dfs(gridConnections[i], i, wires);
		}

		for (int i = 0; i < wires.length; i++) {
			for (int j = i + 1; j < wires.length; j++) {
				if (belongsToGrid[i] == belongsToGrid[j] && wires[i].charAt(j) == '0') {
					newConnections++;
				}
			}
		}

		for (int i = 0; i < gridSize.length; i++) {
			if (biggestGridsSize < gridSize[i]) {
				biggestGridsSize = gridSize[i];
			}
		}

		for (int i = 0; i < wires.length; i++) {
			if (belongsToGrid[i] == -1) {
				newConnections += biggestGridsSize;
			}
		}

		return newConnections;
	}

	public static void main(String[] args) {
		AddElectricalWires addElectricalWires = new AddElectricalWires();
		String[] wires = { "01000", "10100", "01010", "00100", "00000" };
		int[] gridConnections = { 2, 4 };
		System.out.println(addElectricalWires.maxNewWires(wires, gridConnections));

	}

}
