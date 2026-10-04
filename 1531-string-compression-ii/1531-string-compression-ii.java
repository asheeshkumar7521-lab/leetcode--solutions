class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = 10000;
            }
        }
        for (int j = 0; j <= k; j++) {
            dp[n][j] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int del = 0; del <= k; del++) {
                if (del > 0) {
                    dp[i][del] = dp[i + 1][del - 1];
                }
                int same = 0;
                int deleted = 0;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        same++;
                    } else {
                        deleted++;
                    }
                    if (deleted > del) {
                        break;
                    }
                    int len = 1;
                    if (same >= 100) {
                        len += 3;
                    } else if (same >= 10) {
                        len += 2;
                    } else if (same >= 2) {
                        len += 1;
                    }
                    dp[i][del] = Math.min(
                        dp[i][del],
                        len + dp[j + 1][del - deleted]
                    );
                }
            }
        }
        return dp[0][k];
    }
}