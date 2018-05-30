public class Aquarium {

    public int peaceful(int minSize, int maxSize, int[] fishSizes) {
        int sizeCounter = 0;
        for (int size = minSize; size <= maxSize; size++) {
            boolean isPossibleSize = true;
            for (int fishSize : fishSizes) {
                if ((size <= fishSize / 2.0 && size >= fishSize / 10.0) || (fishSize <= size / 2.0 && fishSize >= size / 10.0)) {
                    isPossibleSize = false;
                    break;
                }
            }
            if(isPossibleSize) {
                sizeCounter++;
            }
        }
        return sizeCounter;
    }

    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();
        int[] fishSizes = { 1 };
        System.out.println(aquarium.peaceful(1, 12, fishSizes));
    }
}
