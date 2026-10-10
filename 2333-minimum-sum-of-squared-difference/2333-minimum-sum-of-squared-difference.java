import java.util.*;
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        long[] freq = new long[100001];
        long total = 0;
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
            total += d;
            maxDiff = Math.max(maxDiff, d);
        }
        if (k >= total) {
            return 0;
        }
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            long count = freq[d];
            if (count == 0) {
                continue;
            }
            long use = Math.min(k, count);
            freq[d] -= use;
            freq[d - 1] += use;
            k -= use;
        }
        long ans = 0;
        for (int d = 1; d < freq.length; d++) {
            ans += freq[d] * d * d;
        }
        return ans;
    }
}
