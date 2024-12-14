class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int ans = 0;
        for(int i = 0 ; i < n ; i++)
        {
            dp[i] = 1;
            for(int j = 0 ; j < i ; j++)
            {
                if(nums[j] < nums[i])
                dp[i] = Math.max(dp[i] , dp[j] + 1);
            }
            ans = Math.max(ans , dp[i]);
            
        }
        return ans;
    }
}
// TC : O(N^2)
// SC : O(N) [DP Array]

class Solution {
    public int lengthOfLIS(int[] nums) {
        // Binary Search Approach
        int n = nums.length;
        int dp[] = new int[n];
        int ans = 0;
        for(Integer value : nums)
        {
            int low = 0;
            int high = ans;
            while(low < high)
            {
                int mid = low + (high - low)/2;
                if(dp[mid] < value)
                low = mid + 1;
                else 
                high = mid;
            }
            dp[low] = value;
            if(low == ans) // Length Increase
            ans += 1;

        }
        return ans;
    }
}
// TC : O(N log(N))
// SC : O(N)[DP Array]
