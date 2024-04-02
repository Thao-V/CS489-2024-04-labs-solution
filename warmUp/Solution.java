import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution{
  public static void main(String [] args){
    int [] nums = {2, 2, 7, 11, 15};
    int target = 9;
    List<Integer> res = twoSum(nums, target);
    System.out.println(res.toString());
    List<List<Integer>> res2 = findAllPairsOfTwoSum(nums, target);
    System.out.println(res2.toString());
  }
  private static List<Integer> twoSum(int []nums, int target){
    List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> mp = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      if(mp.containsKey(target - nums[i])){
        res.add(mp.get(target - nums[i]));
        res.add(i);
        break;
      }

      mp.put(nums[i], i);
    }
    return res;
  }

  private static List<List<Integer>> findAllPairsOfTwoSum(int [] nums, int target){
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, List<Integer>> mp = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      int key = target - nums[i];
      if(mp.containsKey(key)){
        for(Integer index: mp.get(key)){
          res.add(Arrays.asList(index, i));
        }
      }
      if(!mp.containsKey(nums[i])){
        mp.put(nums[i], new ArrayList<>());
      }
      mp.get(nums[i]).add(i);
    }
    return res;
  }
}