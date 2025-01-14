import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum
 */
public class E1 {
    public static void main(String[] args) {
        int[] ret = new E1().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ret));
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[0];
    }
}
