package com.company;

public class Main {

    public static void main(String[] args) {
        new Solution().minimumDeleteSum("sjfqkfxqoditw",
                "fxymelgo");
    }
}

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int j = 1; j <= n; j++)
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
            }
        }
        return dp[m][n];
    }
}