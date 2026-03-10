class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] ans = new int[n];
        
        for(int i = 1; i <= n; i++){
            for(int j = i + 1; j <= n; j++){
                
                int d1 = Math.abs(i - j);
                int d2 = Math.abs(i - x) + 1 + Math.abs(y - j);
                int d3 = Math.abs(i - y) + 1 + Math.abs(x - j);
                
                int d = Math.min(d1, Math.min(d2, d3));
                
                ans[d - 1] += 2;
            }
        }
        
        return ans;
    }

    
}