package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassPhotos {


    public static boolean photos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        if (redShirtHeights == null || blueShirtHeights == null)
            return false;

        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        int rSize = redShirtHeights.size();
        int bSize = blueShirtHeights.size();

        boolean redShirtFirst = redShirtHeights.get(rSize - 1) < blueShirtHeights.get(bSize - 1);
        //1 3 5 7 9
        //2 4 5 8 10
        if (redShirtFirst) {
            for (int idx = rSize - 1; idx > 0; idx--) {
                if (redShirtHeights.get(idx) >= blueShirtHeights.get(idx))
                    return false;
            }
        } else {
            for (int idx = bSize - 1; idx > 0; idx--) {
                if (redShirtHeights.get(idx) <= blueShirtHeights.get(idx))
                    return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        ArrayList<Integer> redList = new ArrayList<>(Arrays.asList(1, 7, 9, 3, 4));
        ArrayList<Integer> blueList = new ArrayList<>(Arrays.asList(10, 5, 8, 2, 4));
        System.out.println(photos(redList, blueList));
    }
}
