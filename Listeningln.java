public class Listeningln {

    int[][] isPossible;
    char[][] direction;

    boolean recourse(String typed, String phrase, int index1, int index2) {
        if (isPossible[index1][index2] != 0) {
            if (isPossible[index1][index2] == 1) {
                return true;
            } else {
                return false;
            }
        }

        if(index2 == phrase.length()) {
            if(index1 == typed.length()) {
                isPossible[index1][index2] = 1;
                return true;
            } else {
                isPossible[index1][index2] = -1;
                return false;
            }
        }

        if(index1 == typed.length()) {
            for(int i = index2; i <= phrase.length(); i++) {
                isPossible[index1][index2] = 1;
                direction[index1][index2] = 'n';
            }
            return true;
        }

        if (typed.charAt(index1) == phrase.charAt(index2)) {
            if (recourse(typed, phrase, index1 + 1, index2 + 1)) {
                direction[index1][index2] = 'm';
                isPossible[index1][index2] = 1;
                return true;
            }
        }
        if (recourse(typed, phrase, index1, index2 + 1)) {
            direction[index1][index2] = 'n';
            isPossible[index1][index2] = 1;
            return true;
        }
        isPossible[index1][index2] = 0;
        return false;
    }

    public String find(String typed, String phrase, int index1, int index2) {
        if(index1 == typed.length() && index2 == phrase.length()) {
            return "";
        }
        if(direction[index1][index2] == 'm') {
            return find(typed, phrase, index1 + 1, index2 + 1);
        } else {
            return phrase.charAt(index2) + find(typed, phrase, index1, index2 + 1);
        }
    }

    public String probableMatch(String typed, String phrase) {
        isPossible = new int[typed.length() + 1][phrase.length() + 1];
        direction = new char[typed.length() + 1][phrase.length() + 1];
        boolean possibleMatchExists = recourse(typed, phrase, 0, 0);
        if(possibleMatchExists) {
            return find(typed, phrase, 0, 0);
        }
        return "UNMATCHED";
    }

    public static void main(String[] args) {
        Listeningln listeningln = new Listeningln();
        System.out.println(listeningln.probableMatch("tpt" , "teleport"));
    }

}
