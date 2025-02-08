class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Boyer Moore's Voting Algorithm 
        // Distinct elements Triplets [At max 2 majority elements]
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int value_1 = nums[0];
        int freq_1 = 1;
        int value_2 = nums[0];
        int freq_2 = 0;
        for(int i = 1 ; i < n ; i++)
        {
            if(nums[i] == value_1)
            freq_1 += 1;
            else if(nums[i] == value_2)
            freq_2 += 1;
            else
            {
                if(freq_1 == 0)
                {
                    value_1 = nums[i];
                    freq_1 = 1;
                }
                else if(freq_2 == 0)
                {
                    value_2 = nums[i];
                    freq_2 = 1;
                }
                else
                {
                    freq_1 -= 1;
                    freq_2 -= 1;
                }
            }
        }
        freq_1 = 0;
        freq_2 = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] == value_1)
            freq_1 += 1;
            else if(nums[i] == value_2)
            freq_2 += 1;
        }
        if(freq_1 > n / 3)
        ans.add(value_1);

        if(freq_2 > n / 3)
        ans.add(value_2);

        return ans;
        
    }
}
// TC : N + N => O(2N)
// SC : O(1)
