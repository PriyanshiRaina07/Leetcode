class NumArray {
    int[] seg;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        seg = new int[4*n];
        build(0,0,n-1);

    }
    public void build(int idx, int left, int right){
        if(left == right){
            seg[idx] = nums[left];
            return;
        }
        int mid = left+(right - left)/2;
        int leftChild = 2*idx+1;
        int rightChild = 2*idx+2;
        build(leftChild,left,mid);
        build(rightChild,mid+1,right);

        seg[idx] = seg[leftChild] + seg[rightChild];
    }
    
    public void update(int index, int val) {
        updatePoint(0,0,n-1,index,val);
    }
    private void updatePoint(int idx,int left,int right,int index,int val){

        if(left == right){
            seg[idx] = val;
            return;
        }

        int mid = left + (right-left)/2;

        int leftChild = 2*idx + 1;
        int rightChild = 2*idx + 2;

        if(index <= mid){
            updatePoint(leftChild,left,mid,index,val);
        } else {
            updatePoint(rightChild,mid+1,right,index,val);
        }

        seg[idx] = seg[leftChild] + seg[rightChild];
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
     private int query(int idx,int left,int right,int qs,int qe){

        if(right < qs || left > qe) return 0;

        if(left >= qs && right <= qe) return seg[idx];

        int mid = left + (right-left)/2;

        int leftSum = query(2*idx+1,left,mid,qs,qe);
        int rightSum = query(2*idx+2,mid+1,right,qs,qe);

        return leftSum + rightSum;
    }    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */