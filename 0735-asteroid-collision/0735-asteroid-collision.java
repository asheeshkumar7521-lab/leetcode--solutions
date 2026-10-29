class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> sc = new Stack<>();
        for (int a : asteroids) {
            while (!sc.isEmpty() && a < 0 && sc.peek() > 0) {
                if (sc.peek() > Math.abs(a)) {
                    a = 0;
                    break;
                } else if (sc.peek() == Math.abs(a)) {
                    a = 0;
                    sc.pop();
                    break;
                } else {
                    sc.pop();
                }
            }
            if (a != 0) {
                sc.push(a);
            }
        }
        int[] ans = new int[sc.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = sc.pop();
        }
        return ans;
    }
}