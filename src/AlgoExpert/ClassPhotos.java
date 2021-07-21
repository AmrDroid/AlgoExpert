package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassPhotos {

    //O(nlog(n)) time | O(1) space, where n is the number of integers.
    public static boolean photos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        if (redShirtHeights == null || blueShirtHeights == null)
            return false;

        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        int rSize = redShirtHeights.size();
        int bSize = blueShirtHeights.size();

        boolean redShirtFirst = redShirtHeights.get(rSize - 1) < blueShirtHeights.get(bSize - 1);
        //1 3 6 7 9
        //2 4 5 8 10
        for (int idx = rSize - 1; idx > 0; idx--) {
            if (redShirtFirst && redShirtHeights.get(idx) >= blueShirtHeights.get(idx))
                return false;
            if (!redShirtFirst && redShirtHeights.get(idx) <= blueShirtHeights.get(idx))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {

        ArrayList<Integer> redList = new ArrayList<>(Arrays.asList(1, 7, 9, 3, 4));
        ArrayList<Integer> blueList = new ArrayList<>(Arrays.asList(10, 5, 8, 2, 4));
        System.out.println(photos(redList, blueList));
        System.out.println(photos2(redList, blueList));
    }




    public static boolean photos2(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        if (redShirtHeights == null || blueShirtHeights == null)
            return false;


//        Collections.sort(redShirtHeights,Collections.reverseOrder());
//        Collections.sort(blueShirtHeights,Collections.reverseOrder());

        Collections.reverse(redShirtHeights);
        Collections.reverse(blueShirtHeights);

        int rSize = redShirtHeights.size();
        int bSize = blueShirtHeights.size();

        boolean redShirtFirst = redShirtHeights.get(rSize - 1) < blueShirtHeights.get(bSize - 1);
        //1 5 6 7 9
        //2 4 5 8 10
        for (int idx = 0; idx <redShirtHeights.size(); idx++) {
            if (redShirtFirst && redShirtHeights.get(idx) >= blueShirtHeights.get(idx))
                return false;
            if (!redShirtFirst && redShirtHeights.get(idx) <= blueShirtHeights.get(idx))
                return false;
        }
        return true;
    }
}
