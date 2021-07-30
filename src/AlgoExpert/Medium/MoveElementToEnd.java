package AlgoExpert.Medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MoveElementToEnd {
    private static List<Integer> moveElementToEnd(List<Integer> numbers, int i) {

        if (numbers.size() == 0) return null;

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
        return list;

    }
    ///////////////

    public static List<Integer> moveElementToEnd2(List<Integer> array, int toMove) {
        int lastIdx = array.size() - 1, firstIdx = 0;

        while (firstIdx < lastIdx) {
            while (lastIdx > firstIdx && array.get(lastIdx) == toMove)
                --lastIdx;

            if (array.get(firstIdx) == toMove) {
                array.set(firstIdx, array.get(lastIdx));
                array.set(lastIdx, toMove);
                --lastIdx;
            }

            ++firstIdx;
        }

        return array;
    }


    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(5);
        A.add(8);

        List<Integer> res = moveElementToEnd(A, 5);
        for (int item : res)
            System.out.print(item + "    ");

        System.out.println();

        List<Integer> res2 = moveElementToEnd2(A, 5);
        for (int item : res2)
            System.out.print(item + "    ");

    }


}
