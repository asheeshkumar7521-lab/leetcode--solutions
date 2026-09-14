class Solution:
    def findAnagrams(self, s, p):
        result = []

        if len(p) > len(s):
            return result

        p_count = [0] * 26
        window_count = [0] * 26

        # Count characters in p
        for ch in p:
            p_count[ord(ch) - ord('a')] += 1

        left = 0

        for right in range(len(s)):
            window_count[ord(s[right]) - ord('a')] += 1

            # Keep window size equal to len(p)
            if right - left + 1 > len(p):
                window_count[ord(s[left]) - ord('a')] -= 1
                left += 1

            # Check anagram
            if window_count == p_count:
                result.append(left)

        return result
        