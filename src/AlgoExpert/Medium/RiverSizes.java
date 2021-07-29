package AlgoExpert.Medium;

import java.util.*;

public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        boolean visited[][] = new boolean[height][width];
        List<Integer> sizes = new ArrayList<>();

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if(visited[row][column])continue;
                traverseNode(matrix, row, column, visited, sizes);
            }
        }
        return sizes;
    }

    private static void traverseNode(int[][] matrix, int row, int column, boolean[][] visited, List<Integer> sizes) {

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{row, column});
        int currentSize = 0;
        while (!queue.isEmpty()) {
            Integer[] item = queue.poll();
            row = item[0];
            column = item[1];

            if (visited[row][column]) continue;
            visited[row][column]=true;


            if (matrix[row][column] == 0) continue;

            ++currentSize;

            queue.addAll(getNeighbors(matrix, row, column, visited));
        }
        if (currentSize > 0)
            sizes.add(currentSize);
    }

    private static List<Integer[]> getNeighbors(int[][] matrix, int row, int column, boolean[][] visited) {
        List<Integer[]> list = new ArrayList<>();
        int height = matrix.length;
        int width = matrix[0].length;

        if (row > 0 && !visited[row - 1][column]) list.add(new Integer[]{row - 1, column});

        if (row < height - 1 && !visited[row + 1][column]) list.add(new Integer[]{row + 1, column});

        if (column > 0 && !visited[row][column - 1]) list.add(new Integer[]{row, column - 1});

        if (column < width - 1 && !visited[row][column + 1]) list.add(new Integer[]{row, column + 1});

        return list;
    }



    public static void main(String[] args) {

        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        List<Integer> sizes = riverSizes(input);

        for (int item : sizes)
            System.out.print(item + "    ");
    }


}
