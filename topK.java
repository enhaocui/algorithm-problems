package Pocket_Gem;
import java.util.*;

/**
 * Created by xiaochen on 10/3/17.
 */
public class topK {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) return list;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        List<Map.Entry<Integer, Integer>> temp = new ArrayList<>(map.entrySet());
        temp.sort((a, b) -> {
            return b.getValue() - a.getValue();
        });

        for (int i = 0; i < k && i < temp.size(); i++) {
            list.add(temp.get(i).getKey());
        }
        return list;
    }

    public List<Integer> topKFrequentBucket(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) return list;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }

        for (int i = nums.length; i >= 0 && list.size() < k; i--) {
            if (buckets[i] != null) {
                list.addAll(buckets[i]);
            }
        }
        return list;
    }

}
