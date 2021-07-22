package AlgoExpert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object element : array) {
            if (element instanceof Integer)
                sum += (int) element;
            else
                sum += productSum((List<Object>) element, multiplier + 1);
        }
        return sum * multiplier;
    }

    public static void main(String[] args) {

        List<Object> array = new ArrayList<>();
        List<Object> array2 = new ArrayList<>();
        List<Object> array3 = new ArrayList<>();

        array3.add(5);
        array2.add(4);
        array2.add(array3);
        array.add(6);
        array.add(array2);


        System.out.println(productSum(array, 1));


    }


}
