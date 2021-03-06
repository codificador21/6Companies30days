class Solution {
    public int minSwaps(int[][] grid) {
    //use linkedlist to save the continuous zero count from right to left
    LinkedList<Integer> list = new LinkedList<>();
    int r = grid.length, c = grid[0].length;
    for (int i = 0; i < r; i++) {
        int count = 0;
        for (int j = c - 1; j >= 0; j--) {
            if (grid[i][j] != 0) break;
            count++;
        }
        list.add(count);
    }
    int res = 0;
    for (int i = 0; i < r; i++) {
        int t = -1;
        //find the first zero count which is >= (r - 1 - i)
        //the index is the step
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) >= (r - 1 - i)) {
                t = list.remove(j);
                res += j;
                break;
            }
        }
        if (t == -1) return -1;
    }
    return res;
}
}
/*Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.

A grid is said to be valid if all the cells above the main diagonal are zeros.

Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.

The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).

 

Example 1:


Input: grid = [[0,0,1],[1,1,0],[1,0,0]]
Output: 3
Example 2:


Input: grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
Output: -1
Explanation: All rows are similar, swaps have no effect on the grid.
Example 3:


Input: grid = [[1,0,0],[1,1,0],[1,1,1]]
Output: 0*/