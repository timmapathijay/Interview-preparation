class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes on the basis of width , if widths are same sort in decreasing order of height
        Arrays.sort(envelopes , (a , b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0] );
        // Apply LIS on height
        int n = envelopes.length;
        int dp[] = new int[n];
        int ans = 0;
        for(int i = 0 ; i < n ; i++)
        {
            dp[i] = 1;
            for(int j = 0 ; j < i ; j++)
            {
                if(envelopes[j][1] < envelopes[i][1])
                dp[i] = Math.max(dp[i] , dp[j] + 1);
            }    
            ans = Math.max(ans , dp[i]);
        }
        return ans;
    }
}
// TC : N log(N) [Sorting] + N^2 [LIS] => O(N^2)
// SC : O(N)[DP Array]

// Binary Search Approach [LIS]
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes on the basis of width , if widths are same sort in decreasing order of height
        Arrays.sort(envelopes , (a , b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0] );
        // Apply LIS on height
        int n = envelopes.length;
        int dp[] = new int[n];
        int ans = 0;
        for(int i = 0 ; i < n ; i++)
        {
            int start = 0 , end = ans;
            while(start < end)
            {
                int mid = start + (end - start)/2;
                if(dp[mid] < envelopes[i][1])
                start = mid + 1;
                else
                end = mid;
            }
            dp[start] = envelopes[i][1];
            if(start == ans)
            ans += 1;
        }
        return ans;
    }
}
// TC : N log(N) [Sorting] + N log (N) [LIS] => O(N log (N))
// SC : O(N)[DP Array]
