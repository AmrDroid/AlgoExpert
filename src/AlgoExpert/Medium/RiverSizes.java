package AlgoExpert.Medium;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        ArrayList<Integer> sizes = new ArrayList<>();
        boolean visited[][] = new boolean[height][width];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (visited[row][column]) continue;
                traversNode(matrix, row, column, sizes, visited);
            }
        }


        return new ArrayList<>();
    }

    private static void traversNode(int[][] matrix, int row, int column, ArrayList<Integer> sizes, boolean[][] visited) {


    }

    private static List<Integer[]> getNeighborsOfCurrentNode(int matrix[][], int row, int column, boolean visited[][]) {
        int height = matrix.length;
        int width = matrix[0].length;
        List<Integer[]> neighbors = new ArrayList<>();

        if (!visited[row + 1][column] && row < height - 1) neighbors.add(new Integer[]{row + 1, column});

        if (!visited[row][column + 1] && column < width - 1) neighbors.add(new Integer[]{row, column + 1});

        if (!visited[row - 1][column] && row > 0) neighbors.add(new Integer[]{row - 1, column});

        if (!visited[row][column - 1] && column > 0) neighbors.add(new Integer[]{row, column - 1});

        return neighbors;

    }
}
