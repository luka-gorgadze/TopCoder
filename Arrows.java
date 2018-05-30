public class Arrows {

    private int searchLeftArrows(String s, int longestArrow, char body) {
        int currentArrow = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar == body) {
                currentArrow++;
            } else if(currentChar == '>') {
                if (longestArrow < currentArrow + 1) {
                    longestArrow = currentArrow + 1;
                }
                currentArrow = 0;
            } else {
                currentArrow = 0;
            }
        }
        return longestArrow;
    }

    private int searchRightArrows(String s, int longestArrow, char body) {
        int currentArrow = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            if(currentChar == body) {
                currentArrow++;
            } else if(currentChar == '<') {
                if (longestArrow < currentArrow + 1) {
                    longestArrow = currentArrow + 1;
                }
                currentArrow = 0;
            } else {
                currentArrow = 0;
            }
        }
        return longestArrow;
    }

    public int longestArrow(String s) {
        int longestArrow = -1;
        longestArrow = searchLeftArrows(s, longestArrow, '-');
        longestArrow = searchLeftArrows(s, longestArrow, '=');
        longestArrow = searchRightArrows(s, longestArrow, '-');
        longestArrow = searchRightArrows(s, longestArrow, '=');
        return longestArrow;
    }
}
