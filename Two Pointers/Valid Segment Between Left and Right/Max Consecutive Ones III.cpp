class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        // we are using the understanding of containing valid segment between left and right 
        // HERE, in these kind of problems we also use resources to keep segment valid
        // using the resoruce (flip 0 to 1) in limited k number of times we keep segment valid

        int left,right,n=nums.size(),maxConsecutiveOnes=0;
        // use queue data structure to store the list of indices where flips are used
        queue<int> flipsIndices;

        left=0;
        for(right=0;right<=n-1;right++){
            // check if invalid
            if(nums[right]==0){
                if(flipsIndices.size()<k){
                    // here we have unused operation/flip we simply use at current index
                    flipsIndices.push(right);
                }
                // here checking not empty is necessary for k=0
                else if(!flipsIndices.empty()){
                    // here left to right-1 was valid segment
                    maxConsecutiveOnes=max(maxConsecutiveOnes,(right-1)-left+1);

                    // now we again make the segment valid
                    left=flipsIndices.front()+1;
                    flipsIndices.pop();
                    flipsIndices.push(right);
                }
                else{
                    maxConsecutiveOnes=max(maxConsecutiveOnes,(right-1)-left+1);
                    left=right+1;
                }
            }
            // since we made sure that segment is valid between left and right
            // then segment from left to right is valid if right==n-1
            if(right==n-1)
                maxConsecutiveOnes=max(maxConsecutiveOnes,right-left+1);
        }
        return maxConsecutiveOnes;
    }
};
