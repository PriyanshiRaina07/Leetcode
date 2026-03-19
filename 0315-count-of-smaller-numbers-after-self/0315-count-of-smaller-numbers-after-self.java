class Solution {//nlogn
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
        public void update(int node, int left, int right, int idx){//ye idx wahi hai jisko update krna hi
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
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        //make clone;
        int[]sorted = nums.clone();
        //sort the array
        Arrays.sort(sorted);

        HashMap<Integer,Integer> map = new HashMap<>();
        int idx = 0;
        //ek ek value fetch and assign the value;
        for(int val : sorted){
            if(!map.containsKey(val)){
                map.put(val,idx++);
            }
        }
        //segmet tree
        segmentTree seg = new segmentTree(idx);
        Integer []ans = new Integer[n];
        //right -> left
        for(int i = n-1; i >= 0; i--){
            int val = map.get(nums[i]);
            ans[i] = seg.query(0,0,idx-1,0,val-1);//node,left,right,rl,qr
            seg.update(0,0,idx-1,val);
        }
        return  Arrays.asList(ans);
       
    }
}