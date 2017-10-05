package Pocket_Gem;

/**
 * Created by xiaochen on 10/2/17.
 */
public class fistMissPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] > 0 && nums[index] < nums.length && nums[nums[index] - 1] != nums[index]) {
                swap(nums, index, nums[index] - 1);
                index--;  //without index-- cases like [-1,3,1,2] would fail
            }
            index++;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
