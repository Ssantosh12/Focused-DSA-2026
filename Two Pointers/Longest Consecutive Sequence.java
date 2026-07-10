class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n<2)
            return n;

        // we use O(nlogn) algorithm for this by sorting the array first in ascending
        // by sorting, consecutive sequences will come together as segments/subarrays
        int left,right,longestConsecutiveSeq=1,segRepeatingEle=0;
        Arrays.sort(nums);

        left=0;
        for(right=1;right<=n-1;right++){
            if(nums[right]==nums[right-1])
                segRepeatingEle++;
            // we check if validty of segment between left and right breaks
            else if(nums[right]!=nums[right-1]+1){
                // segment from left to right-1 was valid (consecutive)
                longestConsecutiveSeq=Math.max(longestConsecutiveSeq,((right-1)-left+1)-segRepeatingEle);

                // shift left pointer to correct place to make segment valid again
                left=right;
                segRepeatingEle=0;
            }

            // since we made sure segment from left to right was valid
            if(right==n-1)
                longestConsecutiveSeq=Math.max(longestConsecutiveSeq,(right-left+1)-segRepeatingEle);
        }
        return longestConsecutiveSeq;
    }
}
