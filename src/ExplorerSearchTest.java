import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases

    // expected to throw illegalArgumentException
    @Test
    public void testNoStartPoint() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(0, actual);
    }

    @Test 
    public void testOnlyStartPointInArray() {
        int[][] island = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30 ,actual); // starting points are walkable 
    }

    @Test 
    public void testReachableAreaHelper_smallIsland() {
        int[][] island = {
            {0,1,2},
            {1,1,3},
            {2,1,1}
        };

        boolean[][] visited = new boolean[island.length][island[0].length];
        int count = ExplorerSearch.reachableAreaHelper(island, visited, 0, 0);

        assertEquals(6, count);

    }

    @Test
    public void testFindStart_oneStart() {
        int[][] island = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };

        int[] expected = {1, 1};
        int[] actual = ExplorerSearch.findStart(island);
        assertArrayEquals(expected, actual);
    }
}
