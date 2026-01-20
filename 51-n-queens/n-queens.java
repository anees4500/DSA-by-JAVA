import java.util.*;

class Solution {

    public boolean dia(char[][] chess, int i, int j) {
        if (i < 0 || j < 0 || i >= chess.length || j >= chess.length) {
            return false;
        }
        return chess[i][j] == 'Q';
    }

    public boolean isSafe(char[][] chess, int i, int j) {

        int k = i;
        int l = j;

        // ↖ left diagonal
        while (k - 1 >= 0 && l - 1 >= 0) {
            if (dia(chess, k - 1, l - 1)) {
                return false;
            }
            k--;
            l--;
        }

        k = i;
        l = j;

        // ⬆ same column
        while (k - 1 >= 0) {
            if (dia(chess, k - 1, l)) {
                return false;
            }
            k--;
        }

        k = i;
        l = j;

        // ↗ right diagonal
        while (k - 1 >= 0 && l + 1 < chess.length) {
            if (dia(chess, k - 1, l + 1)) {
                return false;
            }
            k--;
            l++;
        }

        return true;
    }

    public void print(char[][] chess, List<List<String>> answer) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < chess.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chess.length; j++) {
                sb.append(chess[i][j]);
            }
            list.add(sb.toString());
        }

        answer.add(new ArrayList<>(list));
    }

    public void ans(char[][] chess, int r, int n, List<List<String>> answer) {

        if (r == n) {
            return;
        }

        for (int c = 0; c < n; c++) {
            if (isSafe(chess, r, c)) {
                chess[r][c] = 'Q';

                if (r == n - 1) {
                    print(chess, answer);
                } else {
                    ans(chess, r + 1, n, answer);
                }

                chess[r][c] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> answer = new ArrayList<>();
        char[][] chess = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }

        ans(chess, 0, n, answer);
        return answer;
    }
}
