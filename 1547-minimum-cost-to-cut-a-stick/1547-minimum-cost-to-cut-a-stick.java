class Solution {
    int[][]dp;
    public int minCost(int n, int[] cuts) {
        int[]newCut = new int[cuts.length+2];
        newCut[0] = 0;          
        newCut[newCut.length-1] = n;

        Arrays.sort(cuts);
        for(int i=0;i<cuts.length; i++){
            newCut[i+1]=cuts[i];
        }
        dp = new int[newCut.length+ 1][newCut.length+1];
        for (int i = cuts.length; i >= 1; i--) {
            for (int j = 1; j <= cuts.length; j++) {
                if (i > j) continue;
                 int mini = Integer.MAX_VALUE;
                 for(int idx = i; idx <= j; idx++){
                    int cost = newCut[j+1]-newCut[i-1]+dp[i][idx-1]+dp[idx+1][j];
                    mini = Math.min(mini,cost);
   
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][cuts.length];
    }
}