//! Leetcode 2824. Count Pairs Whose Sum is Less than Target...

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class count_pair {
    public static int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);

        int i = 0 ;
        int j = nums.size()-1;

        int count =0;
        while(i<j)
        {
            int sum = nums.get(i) + nums.get(j);

            if(sum < target)
            {
                count = count + (j-i);
                i +=1;
            }
            else
            {
                j=j-1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(-1,1,2,3,1));
        int target = 2;
        System.out.println(countPairs(nums , target ));
    }
}
