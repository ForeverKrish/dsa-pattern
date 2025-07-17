package leetcode.matrix;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int[] d : dirs) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        live += board[ni][nj] & 1;
                    }
                }
                if (live == 3 || (live == 2 && (board[i][j] & 1) == 1)) {
                    board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife sol = new GameOfLife();
        int[][] b = {
            {0,1,0},
            {0,0,1},
            {1,1,1},
            {0,0,0}
        };
        sol.gameOfLife(b);
        System.out.println(java.util.Arrays.deepToString(b));
        // Expect [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
    }
}