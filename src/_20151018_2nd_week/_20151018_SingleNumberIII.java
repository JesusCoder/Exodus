package _20151018_2nd_week;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Question: Given an array of numbers nums, in which exactly two elements
 * appear only once and all the other elements appear exactly twice. Find the
 * two elements that appear only once.
 */
public class _20151018_SingleNumberIII {
	
	/**Cool! I coded this algorithm up from scratch all by myself and made it accepted on the 1st time!
	 * Praise the Lord!*/
	public int[] singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < nums.length; i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], 1);
			} else {
				map.remove(nums[i]);
			}
		}
		int[] result = new int[2];
		List<Integer> temp = new ArrayList<Integer>();
		for(int num : map.keySet()){
			temp.add(num);
		}
		for(int i = 0 ; i < 2; i++){
			result[i] = temp.get(i);
		}
		return result;
	}

}
