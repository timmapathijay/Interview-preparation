class Solution {
    public void swap(int[] nums , int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        // Dutch National Flag Algorithm 
        // With the help of pointers define the region
        int j_0 = 0;
        int j_2 = nums.length - 1;
        int i = 0;
        while(i <= j_2)
        {
           if(nums[i] == 0)
           {
              swap(nums , i , j_0);
              j_0 += 1;
              i += 1;
           } 
           else if(nums[i] == 1)
            i += 1;  
           else
           {
             swap(nums , i , j_2);
             j_2 -= 1;
           }
        }  
    }
}
// TC : O(N)
// SC : O(1)
