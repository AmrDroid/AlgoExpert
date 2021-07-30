package AlgoExpert.Medium;

import java.util.ArrayList;

public class MoveElementToEnd {
    private static Object[] moveElementToEnd(int[] numbers, int i) {

        if (numbers.length == 0) return null;

        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int num : numbers) {
            if (num != i)
                list.add(num);
            else
                count++;
        }
        while (count > 0) {
            list.add(i);
            count--;
        }
        return list.toArray();

    }


    public static void main(String[] args) {
        int A[] = {1, 2, 5, 4, 5, 6, 5, 8, 5, 4, 45, 6, 10, 8};

        Object[] res = moveElementToEnd(A, 5);
        for (Object item : res)
            System.out.print(item + "    ");

    }


}
