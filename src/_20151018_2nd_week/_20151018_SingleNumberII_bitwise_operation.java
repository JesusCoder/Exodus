package _20151018_2nd_week;

/**I used my very original HashMap traversal method to have implemented it all my self two years ago,
 * but now I want to play around with bit manipulation, so re-write it as below.
 * The previous AC'ed code: {@link _20150918_SingleNumberII_revisit}*/

/**Given an array of integers, every element appears three times except for one. Find that single one.*/
public class _20151018_SingleNumberII_bitwise_operation {

	/**I copied this algorithm from discuss.
	 * I don't fully understand this at all.*/
	public int singleNumber(int[] nums){
        int ones = 0, twos = 0, threes = 0;
        for(int i = 0; i < nums.length; i++){
            //twos hold the number that appear twice
            twos |= ones & nums[i];
            
            //ones hold the number that appear once
            ones ^= nums[i];
            
            //threes hold the number that appears three times
            threes = ones & twos;
            
            //if nums[i] appears three times, doing so will clear ones and twos
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
	}
}
