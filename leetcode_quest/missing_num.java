import java.util.ArrayList;
import java.util.List;

public class missing_num {
    class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        int n = nums.length;

        int freq[] = new int[n + 1];

        // mark frequencies
        for (int num : nums) {
            freq[num]++;
        }

        // check missing numbers
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) {
                lst.add(i);
            }
        }

        return lst;
    }
            
    public static void main(String[] args) {
        int arr[] = {1,2,2,4};
        List<Integer> set = findDisappearedNumbers(arr);
        for(int num : set)
        {
            System.out.print(num + " ");
        }
    }
}
}
