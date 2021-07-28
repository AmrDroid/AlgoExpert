package AlgoExpert.Easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ProductSum {


    //O(n) time | O(d) space, where n is the total number of elements in the array,
    // including the sub-elements, and d is the maximum depth of subarrays in the array.

    @SuppressWarnings("unchecked")
    public static int productSum(List<Object> array, int multiplier) {
        if (array == null || array.size() == 0) return 0;

        int sum = 0;
        for (Object element : array) {
            if (element instanceof Integer)
                sum += (int) element;
            else
                sum += productSum((List<Object>) element, multiplier + 1);
        }
        return sum * multiplier;
    }




    @SuppressWarnings("unchecked")
    public static int productSum2(List<Object> array, int depth) {
        if (array == null || array.size() == 0) return 0;
        int sum = 0;
        for (Object val : array) {
            if (val instanceof Integer) sum += (depth * (Integer) val);
            else sum += (depth * productSum2((List<Object>) val, depth + 1));
        }
        return sum;
    }

    public static void main(String[] args) {
        //[6, [4, [5]], 7]
        List<Object> array = new ArrayList<>();
        List<Object> array2 = new ArrayList<>();
        List<Object> array3 = new ArrayList<>();

        array3.add(5);
        array2.add(4);
        array2.add(array3);
        array.add(6);
        array.add(array2);
        array.add(7);

        System.out.println(productSum(array, 1));
        System.out.println(productSum2(array, 1));


    }


}
