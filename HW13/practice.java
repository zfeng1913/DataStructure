import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Your implementations of the Boyer Moore string searching algorithm.
 */
public class practice {
    /**
     * Boyer Moore algorithm that relies on a last occurrence table.
     * This algorithm Works better with large alphabets.
     *
     * Make sure to implement the buildLastTable() method, which will be
     * used in this boyerMoore() method.
     *
     * Note: You may find the getOrDefault() method from Java's Map class useful.
     *
     * You may assume that the passed in pattern, text, and comparator will not be null.
     *
     * @param pattern    The pattern you are searching for in a body of text.
     * @param text       The body of text where you search for the pattern.
     * @param comparator You MUST use this to check if characters are equal.
     * @return           List containing the starting index for each match found.
     */
    public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
        int i = 0;
        int m = text.length();
        int n = pattern.length();
        List<Integer> ans = new ArrayList();
        Map<Character, Integer> last = buildLastTable(pattern);
        while (i <= m-n){
          int j = n-1;

          while (j >=0 && comparator.compare(text.charAt(i), pattern.charAt(j)) == 0){
            j--;
          }
          if (j==-1){
            ans.add(i);
            i++;
          }else{
            int shift = last.getOrDefault(text.charAt(i), -1);
            if (shift <j){
              i += j - shift;
            }else{
              i++;
            }

          }

        }
        return ans;
    }
    public static int[] buildFailureTable(CharSequence pattern, CharacterComparator comparator) {
      int[] f = new int[pattern.length()];
      f[0] = 0;
      int i = 0;
      int j = 1;
      int m = pattern.length();
      while (j < m){
        if (comparator.compare(pattern.charAt(i), pattern.charAt(j)) == 0){
          f[j] = i+1;
          i++;
          j++;
        }else if (i==0){
          f[j] = 0;
          j++;
        }else{
          i = f[i-1];
        }
      }
      return f;
    }
    public static List<Integer> kmp(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
      int j = 0;
      int m = pattern.length();
      int n = text.length();
      int[] f = buildFailureTable(pattern, comparator);
      int k = 0;
      List<Integer> ans = new ArrayList();
      while(k<=m-n){
        while(comparator.compare(pattern.charAt(j),text.charAt(k))==0){
            j++;
          }
        if (j == 0){
          k++;
        }else{
          if(j ==m){
            ans.add(k);
          }
          k += j - f[j-1];
          j = f[j-1];
        }
      }
      return ans;
    }

    /**
     * Builds the last occurrence table that will be used to run the Boyer Moore algorithm.
     *
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     *
     * Ex. pattern = octocat
     *
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     *
     * If the pattern is empty, return an empty map.
     * You may assume that the passed in pattern will not be null.
     *
     * @param pattern A pattern you are building last table for.
     * @return A Map with keys of all of the characters in the pattern mapping
     *         to their last occurrence in the pattern.
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
      Map<Character, Integer> last = new HashMap();
      for (int i=0;i<pattern.length();i++){
        last.put(pattern.charAt(i),i);
      }
      return last;

}
}
