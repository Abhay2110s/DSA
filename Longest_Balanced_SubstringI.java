//https://leetcode.com/problems/longest-balanced-substring-i/description/?envType=daily-question&envId=2026-02-12
import java.util.*;

public class Longest_Balanced_SubstringI {
       public int longestBalanced(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            Arrays.fill(cnt, 0);
            int mx = 0, v = 0;
            for (int j = i; j < n; ++j) {
                int c = s.charAt(j) - 'a';
                if (++cnt[c] == 1) {
                    ++v;
                }
                mx = Math.max(mx, cnt[c]);
                // If the max frequency * number of unique chars equals the current window size,
                // it means all unique characters in this window appear exactly 'mx' times.
                if (mx * v == j - i + 1) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Longest_Balanced_SubstringI sol = new Longest_Balanced_SubstringI();
        
        // Test Cases
        String test1 = "aabbcc";
        String test2 = "abcabcabc";
        String test3 = "abccba";

        System.out.println("Longest Balanced (aabbcc): " + sol.longestBalanced(test1));
        System.out.println("Longest Balanced (abcabcabc): " + sol.longestBalanced(test2));
        System.out.println("Longest Balanced (abccba): " + sol.longestBalanced(test3));
    }
}

