// Number of Ways to Rearrange Sticks With K Sticks Visible
class rearrange_sticks{
    public static int rearrangeSticks(int n, int k) {
        int MOD = 1_000_000_007;
        long[][] dp = new long[n + 1][k + 1];

        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + 
                           (i - 1) * dp[i - 1][j]) % MOD;
            }
        }

        return (int) dp[n][k];
    }

    public static void main(String[] args) {
        int n = 3 ;
        int k = 2 ;
        System.out.println(rearrangeSticks(n, k));
    }

}