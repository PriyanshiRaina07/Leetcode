class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        int pre = 0;
        int count = 0;
        for(int num:nums){
            pre+=num;

            int rem = pre % k;
            if(rem < 0) rem+=k;

            count += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    
    }
}