class Solution {
    static class segmentTree{  //segment tree logic 
        int n;
        int []tree;
        public segmentTree(int n){
            this.n = n;
            tree = new int[4 * n];
        }
        public int query(int node, int left, int right, int ql, int qr){
            //no overlapping
            if(left > qr || right < ql)
               return 0;
            if(ql <= left && right <= qr){
                return tree[node];//fully
            }
            int mid = (left + right)/2;
            return query(2*node+1,left,mid,ql,qr)+query(2*node+2,mid+1,right,ql,qr);   
        }
        public void update(int node, int left, int right, int idx){//ye idx wahi hai    
            if(left == right){  //us point pra jao usko update kro
                tree[node]++;
                return;
            }
            int mid = (left+right)/2;
            if(idx <= mid){
                update(2*node+1,left,mid,idx);
            }else{
                update(2*node+2,mid+1,right,idx);
            }
            tree[node] = tree[2*node+1]+tree[2*node+2];
        }
    }    
        public int reversePairs(int[] nums) {
             int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for(int val : nums){
            set.add(val*1L);
            set.add(2L * val);
        }
        List<Long>list = new ArrayList<>(set);//treeset ka value set me pass
        HashMap<Long,Integer> map = new HashMap<>();
        int idx = 0;
        for(int i = 0; i <list.size();i++){
            if(!map.containsKey(list.get(i))){
                map.put(list.get(i),idx++);
            }
        }
        segmentTree seg = new segmentTree(idx);
        int ans = 0;
        for(int j = 0; j <n; j++ ){
            //arr[i] > 2*arr[j];
            int val = map.get((long)(nums[j]*2L));
            long searchVal = 2L*val;
            ans += seg.query(0,0,idx-1,val+1,idx-1);
            seg.update(0,0,idx-1,map.get((long)nums[j]));
        }
        return ans;

        }
       
    
}