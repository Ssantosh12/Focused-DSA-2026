class Solution {
  public:
    vector<int> nextLargerElement(vector<int>& arr) {
        // code here
        int i,n=arr.size(),nextGreaterEle;
        
        stack<int> stk;
        vector<int> ans(n);
        
        for(i=n-1;i>=0;i--){
            nextGreaterEle=-1;
            
            // logic of finding next greater element
          // TODO: Explain understanding 
            while(!stk.empty()&&stk.top()<=arr[i])
                stk.pop();
            
            if(!stk.empty())
                nextGreaterEle=stk.top();
            
            ans[i]=nextGreaterEle;
            
            // then push current element
            stk.push(arr[i]);
        }
        return ans;
        
    }
};
