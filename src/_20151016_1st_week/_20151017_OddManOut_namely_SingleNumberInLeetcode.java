package _20151016_1st_week;

import java.util.HashSet;
import java.util.Set;

/**This is the 2nd question from Hacking a Google interview question, Person B.
 * But essentially, it's the same as the Single Number I on Leetcode.*/
public class _20151017_OddManOut_namely_SingleNumberInLeetcode {

/**Question:
 * Given an unsorted array of integers, every element appears twice except for one. Find that single one.*/
	
	/**
	 * solution 1: using XOR, idea: for every bit, use bit manipulation. 0^0^0 =
	 * 0, 1^1^1 = 1, 0^0^1 = 1, 1^1^0 = 0. Thus, after the bit manipulation of
	 * XOR, the every bit of result is the bit of single number.
	 */
	/**
	 * A better explanation: first , we have to know the bitwise XOR in java
	 * 
	 * e.g. decimal integer 5 is 1010 when represented in binary form, so when doing
	 * 5^5, we get 0000 in binary form.
	 * This is because the rules for exclusive or is that
	 * when the two bits are the same, the exclusive or result is false (0), when the two bits are different,
	 * the result is true (1).
	 * So 1010
	 *  ^ 1010
	 *  equals
	 *    0000
	 * 
	 * 
	 * 0 ^ N = N 
	 * N ^ N = 0 
	 * 
	 * So..... if N is the single number
	 * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
	 * = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
	 * = 0 ^ 0 ^ ..........^ 0 ^ N
	 * = N
	 */
	private int singleNumberXOR(int[] nums){
		int result = 0;
		for(int num : nums){
			result ^= num;
		}
		return result;
	}
	
	/**solution 2: using HashSet. This is the solution that this handout provides, I just read
	 * its hint and easily wrote it out by myself! Cool! This is really a good one!*/
	private int singleNumberHashSet(int[] nums){
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		for(int num : nums){
			if(set.add(num) == true) {
				sum += num;
			} else {
				sum -= num;
			}
		}
		return sum;
	}

	/**Made both of the the above solutions accepted on Leetcode, so no main function to test here.*/
}
