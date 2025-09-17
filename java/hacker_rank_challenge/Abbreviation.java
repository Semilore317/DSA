package hacker_rank_challenge;
//
public class Abbreviation {
//    public static String abbreviation(String a, String b){
//        /* NAIVE APPROACH */
//        // operations that can be done:
//                // 1. capitalize select letters in a
//                // 2. delete the remaining lowercase letters in a
//
//                // two pointer approach
//
//                int i = 0; // pointer for a
//                int j = 0; // pointer for b
//
//                while (i < a.length()) {
//                    char charA = a.charAt(i);
//
//                    // if there's a match
//                    if (j < b.length() && Character.toUpperCase(charA) == b.charAt(j)) {
//                        if (Character.isUpperCase(charA) && charA != b.charAt(j)) {
//                            return "NO"; // can't change an uppercase char
//                        }
//                        i++;
//                        j++;
//                    } else if (Character.isLowerCase(charA)) {
//                        i++; // skip this lowercase character - basically "delete" it
//                    }
//                    else {
//                        return "NO"; // uppercase letter that doesn't match
//                    }
//                }
//
//                return j == b.length() ? "YES" : "NO";
//    }

//    public static String abbreviation(String a, String b) {
//        /* DYNAMIC PROGRAMMING APPROACH - MEMOIZATION */
//        private static boolean canConvert(String a, String b, int i, int j, Boolean[][] memo) {
//            // Base case: reached end of b
//            if (j == b.length()) {
//                // Make sure remaining a[i:] is all lowercase (can be deleted)
//                while (i < a.length()) {
//                    if (Character.isUpperCase(a.charAt(i))) return false;
//                    i++;
//                }
//                return true;
//            }
//
//            // Base case: ran out of a before b
//            if (i == a.length()) return false;
//
//            // Memoization check
//            if (memo[i][j] != null) return memo[i][j];
//
//            char ca = a.charAt(i);
//            char cb = b.charAt(j);
//            boolean res = false;
//
//            // Case 1: Match (after capitalizing if needed)
//            if (Character.toUpperCase(ca) == cb) {
//                res = canConvert(a, b, i + 1, j + 1, memo);
//            }
//
//            // Case 2: Skip lowercase character
//            if (!res && Character.isLowerCase(ca)) {
//                res = canConvert(a, b, i + 1, j, memo);
//            }
//
//            memo[i][j] = res;
//            return res;
//        }
//    }

    public static String abbreviation(String a, String b) {
        /* DYNAMIC PROGRAMMING APPROACH - TABULATION*/
        int m = a.length();
        int n = b.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                //we can convert the first i characters of a to match the first j characters of b.
                if (dp[i][j]) {
                    // case 1: If the current characters match (or can be capitalized to match)
                    if (j < n && Character.toUpperCase(a.charAt(i)) == b.charAt(j)) {
                        dp[i + 1][j + 1] = true;
                    }
                    // case 2: If the character in `a` is lowercase, we can skip it
                    if (Character.isLowerCase(a.charAt(i))) {
                        dp[i + 1][j] = true;
                    }
                }
            }
        }

        if (dp[m][n]) {
            return "YES";
        }else{
            return "NO";
        }
    }
    public static void main(String[] args) {
        String a = "daBcd";
        String b = "ABC";
        System.out.println(abbreviation(a, b));
    }
}
//a  = "daB; // delete "d" and make "a" -> "A"
// b = "AB";
/*
   b ->   ""     A      AB    ABC
a   ""   true  false  false  false
    "d"  true  false  false  false
   "da"  true   true  false  false
  "daB" false  false   true  false
 "daBc" false  false   true   true
"daBcd" false  false   true   true
 */