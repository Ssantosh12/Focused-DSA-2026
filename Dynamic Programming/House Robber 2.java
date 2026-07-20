class Solution {
    // here we have two subproblem definitions for two scenarios
    // subproblem defn without one: max money upto ith without first element/house
    int maxMoneyWihtoutFirst(int index, int[] nums){
        // base case: here nums[1] is treated as first element
        if(index==1)
            return nums[1];
        else if(index<1)
            return 0;
        
        // transition: max of tow choices, choices are we can take or not take current
        // if we take curent, nums[index]+dp[index-2] , if we don't, dp[index-1]
        return Math.max(nums[index]+maxMoneyWihtoutFirst(index-2,nums),maxMoneyWihtoutFirst(index-1,nums));
    }

    // subproblem definition: max money upto ith index with no restriction on first
    int maxMoneyUptoIndex(int index, int[] nums){
        // base case: here nums[0] is the first element
        if(index==0)
            return nums[0];
        else if(index<0)
            return 0;
        
        // transition: max of tow choices, choices are we can take or not take current
        // if we take curent, nums[index]+dp[index-2] , if we don't, dp[index-1]
        return Math.max(nums[index]+maxMoneyUptoIndex(index-2,nums),maxMoneyUptoIndex(index-1,nums));
    }

    public int rob(int[] nums) {
        // here we have two choices,choose last house money or not choose
        int choice1=nums[nums.length-1]+maxMoneyWihtoutFirst(nums.length-3,nums);
        int choice2=maxMoneyUptoIndex(nums.length-2,nums);

        return Math.max(choice1, choice2);
    }
}
