package cn.techoc.easy.t001;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        var len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSumHash(int[] nums, int target) {
        var hashtable = new HashMap<Integer, Integer>(nums.length - 1);
        for (int i = 0; i < nums.length; ++i) {
            //如果hash表中存在元素
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            //不存在就将遍历到的元素放入hash表中
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        var target = 9;
        Solution solution = new Solution();
        int[] twoSum = solution.twoSum(nums, target);
        int[] twoSumHash = solution.twoSumHash(nums, target);

        System.out.println(Arrays.toString(twoSum));
        System.out.println(Arrays.toString(twoSumHash));
    }
}
