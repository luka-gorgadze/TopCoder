public class Archimedes {

    public double approximatePi(int numSides) {
        // why not 2 * Math.PI, because law of sines d is diameter of triangles circumference
        double angle = Math.PI / numSides;
        double perimeterOfPolygon = numSides * 2 * Math.sin(angle);
        return perimeterOfPolygon / 2 ;
    }

    public double approximatePiWithCosNotWorking(int numSides) {
        double angle = (2 * Math.PI) / numSides;
        double lengthOfSide = Math.sqrt(2 - 2 * Math.cos(angle));
        double perimeterOfPolygon = numSides * lengthOfSide;
        return perimeterOfPolygon / 2;
    }

    public static void main(String[] args) {
        Archimedes archimedes = new Archimedes();
        System.out.println(archimedes.approximatePi(17280));
    }

}
