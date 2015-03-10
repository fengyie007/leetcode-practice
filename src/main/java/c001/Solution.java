package c001;

import java.util.Arrays;

/**
 * Created by wenjie.cao on 3/4/15.
 */
public class Solution {

    public static void main(String[] args) {
//        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("data.txt");
//        List<String> strings = null;
//        try {
//            strings = IOUtils.readLines(new InputStreamReader(resourceAsStream));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String[] split = strings.get(0).split(",");
//        List<Integer> data = new ArrayList<Integer>();
//        for (int i = 0; i < split.length; i++) {
//            String s = split[i];
//            data.add(Integer.parseInt(s));
//        }
        int target = 16021;
        long start = System.currentTimeMillis();
        int[] ints = twoSum(new int[]{3, 2, 4}, 6);
//        int[] ints = twoSum(data.toArray(new Integer[data.size()]), target);
        System.out.println("time:" + (System.currentTimeMillis() - start) + "ms");
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] dest = new int[numbers.length];
        System.arraycopy(numbers, 0, dest, 0, numbers.length);
        Arrays.sort(dest);

        int start = 0, end = dest.length - 1;
        while (start < end) {
            int sum = dest[start] + dest[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                int orgStart = 0, orgEnd = 0;
                boolean flag = true;
                for (int i = 0; i < numbers.length; i++) {
                    int i1 = numbers[i];
                    if (i1 == dest[start] && flag) {
                        orgStart = i;
                        flag = false;
                    }
                    if (i1 == dest[end]) {
                        orgEnd = i;
                    }
                }
                if(orgStart > orgEnd){
                    int temp = orgEnd;
                    orgEnd = orgStart;
                    orgStart = temp;
                }
                return new int[]{orgStart + 1, orgEnd + 1};
            }
        }
        return null;
    }
}
