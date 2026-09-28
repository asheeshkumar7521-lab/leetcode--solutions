class Solution {
    static final int MOD = 1337;
    public int superPow(int a, int[] b) {
        a = a % MOD;
        int result = 1;
        for(int digit : b) {
            result = power(result, 10);
            result = (result * power(a, digit)) % MOD;
        }
        return result;
    }
    public int power(int a, int n) {
        int result = 1;
        while(n > 0) {
            if(n % 2 == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            n = n / 2;
        }
        return result;
    }
}