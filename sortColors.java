package Pocket_Gem;

/**
 * Created by xiaochen on 10/2/17.
 */
public class sortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 2) {
                swap(nums, index, right);
                right--;
            } else if (nums[index] == 0) {
                swap(nums, index, left);
                left++;
                index++;
            } else {
                index++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
