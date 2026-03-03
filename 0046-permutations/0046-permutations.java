class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(); //tp prevent 'temp '
        boolean[] visit = new boolean[nums.length];
        helper(nums, temp, ans, visit);
        return ans;
    }
     public void helper(int[] nums, List<Integer> temp, List<List<Integer>> ans, boolean[] visit){

        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(visit[i]) continue;
            visit[i] = true;
            temp.add(nums[i]);
            helper(nums, temp,ans,visit);
            visit[i] = false;
            temp.remove(temp.size()-1);
            
        }
    }
}             
