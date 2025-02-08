class Solution {
    public int majorityElement(int[] nums) {
        //Boyer Moore's Voting Algorithm 
        // At max 1 majority element
        // Distinct Element Pairing
        int majorityElement = nums[0];
        int freq = 1;
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i] == majorityElement)
                freq += 1;
            else
            {
                if(freq == 0)
                {
                    majorityElement = nums[i];
                    freq = 1;
                }
                else
                freq -= 1;
            }    
        }
        return majorityElement;
    }
}
// TC : O(N)
// SC : O(1)
