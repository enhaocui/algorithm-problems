package Pocket_Gem;

/**
 * Created by xiaochen on 10/2/17.
 */
public class sortColors4 {
    static int left, right;
    public static void sortColors2(int[] colors) {
        // write your code here
        left = 0;
        right = colors.length - 1;
        sortColors(colors, 1, 4);
        sortColors(colors, 2, 3);
    }

    public static void sortColors(int[] nums, int min, int max) {
        if (nums == null || nums.length == 0) return;
        int index = left;
        while (index <= right) {
            if (nums[index] == max) {
                swap(nums, index, right);
                right--;
            } else if (nums[index] == min) {
                swap(nums, index, left);
                left++;
                index++;
            } else {
                index++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] colors = new int[]{2,1,3,4,1,4,2,3,4,1,4};
        sortColors2(colors);
        for (int color : colors) System.out.print(color + " ");
    }
}
