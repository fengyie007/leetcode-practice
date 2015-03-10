package kmp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wenjie.cao on 3/9/15.
 */
public class Solution {

    public static void main(String[] args) {
        String a = "BBC ABCDAB ABCDABCDABDE";
        String b = "ABCDABD";
        long start = System.currentTimeMillis();
        int x = new Solution().indexOf(a, b);
        System.out.println("time:" + (System.currentTimeMillis() - start) + "ms");
        System.out.println(x);
        if (x != -1)
            System.out.println(a.substring(x, b.length() + x));
    }

    public int indexOf(String str, String searchStr) {
        int ia = 0, ib = 0;
        int result = -1;
        int matchCount = 0;
        Map<Integer, Integer> partMatchTable = getPartMatchTable(searchStr);
        int count = 0;
        while (ia < str.length() && ib < searchStr.length()) {
            char a = str.charAt(ia);
            char b = searchStr.charAt(ib);

            count++;
            if (a == b) {
                matchCount++;
                if (matchCount == searchStr.length()) {
                    result = ia - matchCount + 1;
                    break;
                }
                ia++;
                if (matchCount < searchStr.length())
                    ib++;
            } else {
                if (matchCount > 0) {
//                    ia -= matchCount;ia ++;
                    ia = ia - partMatchTable.get(matchCount);
                } else {
                    ia++;
                }
                ib = 0;
                matchCount = 0;
            }
        }
        System.out.println("count:" + count);
        return result;
    }

    public Map<Integer, Integer> getPartMatchTable(String searchStr) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        int index = 1;
        while (index < searchStr.length()) {
            String substr = searchStr.substring(0, index);
            result.put(substr.length(), getPartMatchValue(substr));
            index++;
        }
        return result;
    }

    public int getPartMatchValue(String searchStr) {
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        int index = 1;
        while (index < searchStr.length()) {
            set1.add(searchStr.substring(0, index));
            set2.add(searchStr.substring(index, searchStr.length()));
            index++;
        }
        set1.retainAll(set2);
        int result = 0;
        if (!set1.isEmpty()) {
            result = set1.iterator().next().length();
        }
        return result;
    }
}