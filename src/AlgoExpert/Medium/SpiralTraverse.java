package AlgoExpert.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    private static List<Integer> spiralTraverse(int[][] input) {

        List<Integer> list = new ArrayList<>();
        int startRow = 0, endRow = input.length - 1;
        int startCol = 0, endCol = input[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++)
                list.add(input[startRow][i]);
            for (int i = startRow + 1; i <= endRow; i++)
                list.add(input[i][endCol]);
            for (int i = endCol - 1; i >= startCol; i--)
                list.add(input[endRow][i]);
            for (int i = endRow - 1; i > startRow; i--)
                list.add(input[i][startCol]);

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return list;
    }
    public static void main(String[] args) {

        int[][] input = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5},
                {0, 0, 0, 0, 0,}
        };
        List<Integer> list = spiralTraverse(input);

        for (int item : list)
            System.out.print(item + "    ");


    }

}
