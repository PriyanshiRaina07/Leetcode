
class Solution {

    int[] seg;
    int n;

    void build(int idx, int l, int r, int[] arr) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }

        int mid = (l + r) / 2;

        build(2 * idx + 1, l, mid, arr);
        build(2 * idx + 2, mid + 1, r, arr);

        seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]);
    }

    int queryFirstGreater(int idx, int l, int r, int ql, int target) {

        if (r < ql || seg[idx] <= target)
            return -1;

        if (l == r)
            return l;

        int mid = (l + r) / 2;

        int left = queryFirstGreater(2 * idx + 1, l, mid, ql, target);
        if (left != -1)
            return left;

        return queryFirstGreater(2 * idx + 2, mid + 1, r, ql, target);
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {

        n = heights.length;
        seg = new int[4 * n];

        build(0, 0, n - 1, heights);

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {

            int a = queries[i][0];
            int b = queries[i][1];

            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }

            if (a == b) {
                ans[i] = a;
            }

            else if (heights[a] < heights[b]) {
                ans[i] = b;
            }

            else {

                int target = Math.max(heights[a], heights[b]);

                int res = queryFirstGreater(0, 0, n - 1, b + 1, target);

                ans[i] = res;
            }
        }

        return ans;
    }
}