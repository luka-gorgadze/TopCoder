public class AttendanceShort {

    public String[] shortList(String[] names, String[] attendance) {
        boolean[] notAttended = new boolean[names.length];
        String[] shortList;
        int shortListLength = 0;
        int countA;
        int countM;

        for (int i = 0; i < names.length; i++) {
            countA = 0;
            countM = 0;

            for (int j = 0; j < attendance[i].length(); j++) {
                switch (attendance[i].charAt(j)) {
                    case 'A':
                        countA++;
                        break;
                    case 'M':
                        countM++;
                        break;
                }
            }

            if(countA / (double)(attendance[i].length() - countM) > 0.25) {
                notAttended[i] = true;
                shortListLength++;
            }
        }

        shortList = new String[shortListLength];
        int shortListIndex = 0;
        for(int i = 0; i < names.length; i++) {
            if(notAttended[i]) {
                shortList[shortListIndex] = names[i];
                shortListIndex++;
            }
        }

        return shortList;
    }
}


