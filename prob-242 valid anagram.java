import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths are different, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // Sort both arrays
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Compare the sorted arrays
        return Arrays.equals(sArray, tArray);
    }
}
