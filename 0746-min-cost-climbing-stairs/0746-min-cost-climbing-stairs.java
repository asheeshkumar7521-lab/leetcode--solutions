class Solution {
    int dp[]=new int[1000];
    public int minCostClimbingStairs(int[] cost) {
        Arrays.fill(dp,-1);
        int ZeroTh=climb(cost,0);
        int first=climb(cost,1);
        return Math.min(ZeroTh,first);
    }
    public int climb(int cost[],int i){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int f = climb(cost, i + 1);
        int s = climb(cost, i + 2);
        return dp[i]=Math.min(f,s)+cost[i];

    }       
}