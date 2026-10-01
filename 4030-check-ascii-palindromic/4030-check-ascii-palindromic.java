class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder binary = new StringBuilder();

        for (char ch : s.toCharArray()) {
            String b = Integer.toBinaryString(ch);

            while (b.length() < 8) {
                b = "0" + b;
            }

            binary.append(b);
        }

        int i = 0;
        int j = binary.length() - 1;

        while (i < j) {
            if (binary.charAt(i) != binary.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}