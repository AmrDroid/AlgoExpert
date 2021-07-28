package AlgoExpert.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        ArrayList<Integer> sizes = new ArrayList<>();
        boolean [][]visited = new boolean[height][width];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (visited[row][column]) continue;
                traversNode(matrix, row, column, sizes, visited);
            }
        }
        return sizes;
    }

    private static void traversNode(int[][] matrix, int row, int column, ArrayList<Integer> sizes, boolean[][] visited) {

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{row, column});
        int currentSize = 0;

        while (!queue.isEmpty()) {
            Integer[] arr = queue.poll();
            row = arr[0];
            column = arr[1];

            if (visited[row][column]) continue;
            visited[row][column] = true;

            if (matrix[row][column] == 0) continue;

            List<Integer[]> neighbors = getNeighborsOfCurrentNode(matrix, row, column, visited);

            ++currentSize;
            queue.addAll(neighbors);
        }
        if (currentSize > 0)
            sizes.add(currentSize);


    }

    private static List<Integer[]> getNeighborsOfCurrentNode(int [][]matrix, int row, int column, boolean [][]visited) {
        int height = matrix.length;
        int width = matrix[0].length;
        List<Integer[]> neighbors = new ArrayList<>();

        if (row < height - 1 && !visited[row + 1][column]) neighbors.add(new Integer[]{row + 1, column});

        if (column < width - 1 && !visited[row][column + 1]) neighbors.add(new Integer[]{row, column + 1});

        if (row > 0 && !visited[row - 1][column]) neighbors.add(new Integer[]{row - 1, column});

        if (column > 0 && !visited[row][column - 1]) neighbors.add(new Integer[]{row, column - 1});

        return neighbors;

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
