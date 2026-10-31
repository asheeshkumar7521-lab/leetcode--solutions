import java.util.Arrays;
class Solution {
    static final int MOD = 1_000_000_007;
    int m, n;
    int[][] grid;
    int[][][] memo;
    int move(int i, int j, int dir) {
        if (memo[i][j][dir] != -3) {
            return memo[i][j][dir];
        }
        int ni = i + (dir == 1 ? 1 : 0);
        int nj = j + (dir == 0 ? 1 : 0);
        if (ni >= m || nj >= n) {
            return memo[i][j][dir] = -1;
        }
        if (grid[ni][nj] == 0) {
            return memo[i][j][dir] = ni * n + nj;
        }
        int nextDir = 1 - dir;
        return memo[i][j][dir] = move(ni, nj, nextDir);
    }
    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        memo = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -3);
            }
        }
        long[][] dp = new long[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }
                int right = move(i, j, 0);
                if (right != -1) {
                    int r = right / n;
                    int c = right % n;
                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }
                int down = move(i, j, 1);
                if (down != -1) {
                    int r = down / n;
                    int c = down % n;
                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }
            }
        }
        return (int) dp[m - 1][n - 1];
    }
}