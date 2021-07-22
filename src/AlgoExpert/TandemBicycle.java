package AlgoExpert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle {

    //O(nlog(n)) time | O(1) space, where n is the number of riders.
    public static int tandemBicycle(ArrayList<Integer> redShirtsSpeed, ArrayList<Integer> blueShirtsSpeed, boolean fastest) {
        Collections.sort(redShirtsSpeed);
        if (fastest)
            Collections.reverse(blueShirtsSpeed);
        else
            Collections.sort(blueShirtsSpeed);

        int totalSpeed = 0;
        for (int i = 0; i < redShirtsSpeed.size(); i++) {
            totalSpeed += Math.max(redShirtsSpeed.get(i), blueShirtsSpeed.get(i));

        }
        return totalSpeed;
    }

    public static void main(String[] args) {

        ArrayList<Integer> red = new ArrayList<>(Arrays.asList(8, 5, 3));
        ArrayList<Integer> blue = new ArrayList<>(Arrays.asList(7, 2, 4));

        System.out.println(tandemBicycle(red, blue, false));
        System.out.println(tandemBicycle(red, blue, true));
    }





}
