package problems;

import java.util.*;

/** Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set). */
@Deprecated
public class LeetCode_0090_SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = null;
        if (nums == null) {
            return result;
        }

        list = new ArrayList<>();
        result.add(list);

        if (nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            map.put(nums[i], count == null? 1 : count + 1);
        }

        int size = 0;
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        //int[] tmp = new int[entrySet.size()];
        //int index = 0;
        //tmp[index] = 1;
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            //index ++;
            //tmp[index] = tmp[index - 1] * (entry.getValue() + 1);
            size = result.size();
            for (int i = 0; i < size; i++) {
                for (int j = 1; j <= entry.getValue(); j++) {
                    list = new ArrayList<>(result.get(i));
                    for (int k = 0; k < j; k++) {
                        list.add(entry.getKey());
                    }
                    result.add(list);
                }
            }
        }

        return result;
    }

}
