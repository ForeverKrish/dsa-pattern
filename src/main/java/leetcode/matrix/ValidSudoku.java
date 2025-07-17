package leetcode.matrix;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9], cols = new int[9], boxes = new int[9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                int d = ch - '1';
                int mask = 1 << d;
                int b = (r / 3) * 3 + (c / 3);
                if ((rows[r] & mask) != 0 || (cols[c] & mask) != 0 || (boxes[b] & mask) != 0) {
                    return false;
                }
                rows[r] |= mask;
                cols[c] |= mask;
                boxes[b] |= mask;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku sol = new ValidSudoku();
        char[][] valid = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] invalid = new char[9][9];
        for(int i=0;i<9;i++) invalid[i] = valid[i].clone();
        invalid[0][0] = '8';
        System.out.println(sol.isValidSudoku(valid));   // Expect true
        System.out.println(sol.isValidSudoku(invalid)); // Expect false
    }
}