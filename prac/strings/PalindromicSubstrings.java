package prac.strings;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    public static int countSubstrings(String str){
        int length = str.length();
        int ans = 0;

        for (int i = 0; i < length; i++) {
            int left = i;
            int right = i + 1;

            // Check for even-length palindromes
            while (right < length && left >= 0 && str.charAt(right) == str.charAt(left)) {
                ans++;
                left--;
                right++;
            }

            left = i - 1;
            right = i + 1;

            // Check for odd-length palindromes
            while (right < length && left >= 0 && str.charAt(right) == str.charAt(left)) {
                ans++;
                left--;
                right++;
            }
        }

        return ans + length; // Adding length to account for single characters as palindromes
    }

    public static int countSubstrings2(String str){
        int length = str.length();
        int ans = 0;

        for (int center = 0; center < 2 * length - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < length && str.charAt(left) == str.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }

        return ans;
    }
}
