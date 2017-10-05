package Pocket_Gem;
import java.util.*;

/**
 * Created by xiaochen on 10/2/17.
 */
public class Longest_Sequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;

            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int length = left + right + 1;
            map.put(num - left, length);
            map.put(num + right, length);
            map.put(num, length);
            max = Math.max(length, max);
        }
        return max;
    }
}
