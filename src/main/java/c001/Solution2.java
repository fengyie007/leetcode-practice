package c001;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by wenjie.cao on 3/4/15.
 */
public class Solution2 {

    public static void main(String[] args) {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("data.txt");
        List<String> strings = null;
        try {
            strings = IOUtils.readLines(new InputStreamReader(resourceAsStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] split = strings.get(0).split(",");
        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            data.add(Integer.parseInt(s));
        }
        int target = 16021;
        long start = System.currentTimeMillis();
//        int[] ints = twoSum(new int[]{3, 2, 4}, 6);
        int[] ints = twoSum(data.toArray(new Integer[data.size()]), target);
        System.out.println("time:" + (System.currentTimeMillis() - start) + "ms");
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(Integer[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (!map.containsKey(number)) {
                map.put(number, i);
            }

            int delta = target - number;
            if (map.containsKey(delta)) {
                int start = i;
                int end = map.get(delta);
                if (start > end) {
                    int temp = end;
                    end = start;
                    start = temp;
                }else if(start == end){
                    continue;
                }
                return new int[]{start + 1, end + 1};
            }
        }
        return null;
    }
}
