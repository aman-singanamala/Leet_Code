//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {

    int search(String pat, String txt) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> m = new HashMap<>();

        // Initialize the frequency count for characters in the pattern.
        for (int i = 0; i < pat.length(); i++) {
            char c = pat.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        int i = 0;
        int j = 0;

        while (j < txt.length()) {
            char right = txt.charAt(j);

            // Include the right character in the window.
            m.put(right, m.getOrDefault(right, 0) + 1);

            // Expand the window until it reaches the size of the pattern.
            if (j - i + 1 < pat.length()) {
                j++;
            } else if (j - i + 1 == pat.length()) {
                // Check if the current window matches the pattern.
                if (m.equals(map)) {
                    count++;
                }

                // Slide the window and remove the left character from the window.
                char left = txt.charAt(i);
                m.put(left, m.get(left) - 1);
                if (m.get(left) == 0) {
                    m.remove(left);
                }

                i++;
                j++;
            }
        }

        return count;
    }
}
