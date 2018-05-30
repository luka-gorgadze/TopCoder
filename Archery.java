public class Archery {

    public double expectedPoints(int N, int[] ringPoints) {
        double expectedPoint = 0;
        double[] ringArea = new double[ringPoints.length];
        double[] ringProbability = new double[ringPoints.length];
        double totalArea = 1;
        double numberOfRings = N + 1;
        ringArea[0] = (1 / numberOfRings) * (1 / numberOfRings);
        for(int i = 1; i < ringArea.length; i++) {
            ringArea[i] = ((i + 1) / numberOfRings) * ((i + 1) / numberOfRings) - ((i) / numberOfRings) * ((i) / numberOfRings);
        }
        for(int i = 0; i < ringProbability.length; i++) {
            ringProbability[i] = ringArea[i] / totalArea;
        }

        for(int i = 0; i < ringProbability.length; i++) {
            expectedPoint += ringProbability[i] * ringPoints[i];
        }

        return expectedPoint;
    }

    public static void main(String[] args) {
        Archery archery = new Archery();
        int[] ringPoints = {1, 1, 1, 1};
        System.out.println(archery.expectedPoints(3, ringPoints));
    }

}
