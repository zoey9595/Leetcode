package Easy;

import java.util.Arrays;
import java.util.HashMap;

public class _001TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        /* Brute force
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if ((nums[i]+nums[j]) == target) {
                    int[] output = new int[2];
                    output[0] = i;
                    output[1] = j;
                    return output;
                }
            }
        }
        return null;
        */

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] input1 = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(input1,target)));
        int[] input2 = {3,2,4};
        target = 6;
        System.out.println(Arrays.toString(twoSum(input2,target)));

    }
}
