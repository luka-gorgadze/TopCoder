import java.util.HashSet;
import java.util.Set;

public class AustrianLotto {

    public int[] evaluate(String drawing, String[] picks) {
        int[] breakdown = new int[7];
        Set<String> picksSet = new HashSet<>();
        String[] drawings = drawing.split(" ");
        for(String drawingNumber : drawings) {
            picksSet.add(drawingNumber);
        }

        for(String pick : picks) {
            int numberOfMatches = 0;
            String[] pickNumbers = pick.split(" ");
            for(String pickNumber : pickNumbers) {
                if(picksSet.contains(pickNumber)) {
                    numberOfMatches++;
                }
            }
            breakdown[numberOfMatches]++;
        }

        return breakdown;
    }

}
