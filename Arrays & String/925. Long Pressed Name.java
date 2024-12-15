class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();
        int i = 0 , j = 0;
        while(i < n && j < m)
        {
            char ch_i = name.charAt(i);
            char ch_j = typed.charAt(j);
            if(ch_i == ch_j)
            {
                i++;
                j++;
            }
            else // check for long-pressed condition
            {
               if(j != 0 && typed.charAt(j - 1) == ch_j)
               j++;
               else
               return false;
            }
        }
        if(i != n)
        return false;
        else
        {
            while(j < m)
            {
                if(typed.charAt(j - 1) != typed.charAt(j))
                return false;

                j++;
            }
            return true;
        }
    }
}
// TC : O(M)
// SC : O(1)
