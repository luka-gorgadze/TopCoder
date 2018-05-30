public class ApplesAndOrangesEasy {

    public static void main(String[] args) {
        ApplesAndOrangesEasy applesAndOrangesEasy = new ApplesAndOrangesEasy();
        int[] info = { 3, 8 };
        System.out.println(applesAndOrangesEasy.maximumApples(10, 3, info));
    }

    public int maximumApples(int N, int K, int[] info) {
        int maximumApples = info.length;
        int[] applesInKRange = new int[N + 1];
        boolean[] wasApple = new boolean[N + 1];

        for(int index : info) {
            wasApple[index] = true;
            putApples(applesInKRange, index, K);
        }

        for(int i = 1; i < applesInKRange.length; i++) {
            if(wasApple[i] == false && canPutApples(applesInKRange, i, K)) {
                putApples(applesInKRange, i, K);
                maximumApples++;
            }
        }

        return maximumApples;
    }

    private boolean canPutApples(int[] applesInKRange, int index, int K) {
        for(int i = index; i < index + K && i < applesInKRange.length; i++) {
            if(applesInKRange[i] >= K / 2) {
                return false;
            }
        }
        return true;
    }

    private void putApples(int[] applesInKRange, int index, int K) {
        for(int i = index; i < index + K && i < applesInKRange.length; i++) {
            applesInKRange[i]++;
        }
    }

}
