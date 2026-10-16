class Solution {
    static final long MOD = 1000000007L;
    public int sumCounts(int[] nums) {
        int n = nums.length;
        int size = 4 * n;
        long[] sum = new long[size];
        long[] sumSq = new long[size];
        long[] lazy = new long[size];
        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int left = last[nums[i]] + 1;
            update(1, 0, n - 1, left, i, 1,
                   sum, sumSq, lazy);

            ans = (ans + sumSq[1]) % MOD;
            last[nums[i]] = i;
        }
        return (int) ans;
    }
    void update(int node, int start, int end,
                int l, int r, long val,
                long[] sum, long[] sumSq, long[] lazy) {
        if (l > end || r < start) return;
        if (l <= start && end <= r) {
            long len = end - start + 1L;
            sumSq[node] = (sumSq[node]
                    + 2 * val % MOD * sum[node] % MOD
                    + len * val % MOD * val % MOD) % MOD;
            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] += val;
            return;
        }
        push(node, start, end, sum, sumSq, lazy);
        int mid = (start + end) / 2;
        update(node * 2, start, mid, l, r, val,
               sum, sumSq, lazy);
        update(node * 2 + 1, mid + 1, end, l, r, val,
               sum, sumSq, lazy);
        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sumSq[node] = (sumSq[node * 2]
                     + sumSq[node * 2 + 1]) % MOD;
    }
    void push(int node, int start, int end,
              long[] sum, long[] sumSq, long[] lazy) {
        long val = lazy[node];
        if (val == 0 || start == end) return;
        int mid = (start + end) / 2;
        apply(node * 2, start, mid, val, sum, sumSq, lazy);
        apply(node * 2 + 1, mid + 1, end, val, sum, sumSq, lazy);
        lazy[node] = 0;
    }
    void apply(int node, int start, int end, long val,
               long[] sum, long[] sumSq, long[] lazy) {
        long len = end - start + 1L;
        sumSq[node] = (sumSq[node]
                + 2 * val % MOD * sum[node] % MOD
                + len * val % MOD * val % MOD) % MOD;
        sum[node] = (sum[node] + len * val) % MOD;
        lazy[node] += val;
    }
}