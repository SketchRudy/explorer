import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too

        boolean[][] visited = new boolean[island.length][island[0].length];
        return -1;
    }

    public static int reachableAreaHelper(int[][] island, boolean[][] visited, int row, int col) {
        // out of bounds
        if (row >= island.length || row < 0 || col < 0 || col >= island[0].length) {
            return 0;
        }
        
        // if it's water or mountain
        if (island[row][col] == 2 || island[row][col] == 3) {
            return 0;
        }

        // if it's already visited
        if (visited[row][col]) {
            return 0;
        }

        // add it to visited
        visited[row][col] = true;

        int count = 1;
        count += reachableAreaHelper(island, visited, row, col);

        return count; 
    }

    public static int[] findStart(int[][] island) {
        for (int r = 0; r < island.length; r++) {
            for (int c = 0; c < island[0].length; c++) {
                if (island[r][c] == 0) {
                    return new int[] { r, c };
                }
            }
        }
        throw new IllegalArgumentException("No starting point: 0 ,  found on island");
    }
}
