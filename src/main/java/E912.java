import java.util.Arrays;
import java.util.Random;

public class E912 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        new E912().sortArray2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 随机中位数
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomPartition(nums, l, r);
            quicksort(nums, l, pos - 1);
            quicksort(nums, pos + 1, r);
        }
    }

    public int randomPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 默认左侧中位数
     * @param nums
     * @return
     */
    public int[] sortArray2(int[] nums) {
        quicksort2(nums, 0, nums.length - 1);
        return nums;
    }

    public void quicksort2(int[] nums, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int x = nums[i];
            while (i < j) {
                while (i < j && nums[j] > x) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] < x) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = x;
            quicksort2(nums, l, i - 1);
            quicksort2(nums, i + 1, r);
        }
    }
}
