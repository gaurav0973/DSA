//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
class Solution{   
public:
    long maximumSumSubarray(int k, vector<int> &arr , int n){
        
        long sum = 0;
        long maxi = -1e9;
        int start = 0;
        int end = 0;
        while( end < n){
            int windowSize = end - start + 1;
            sum += arr[end];
            if(windowSize < k)
                end++;
            else if(windowSize == k){
                maxi = max(maxi,sum);
                sum -= arr[start];
                start++;
                end++;
            }
        }
        return maxi;
    }
};

//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N,K;
        cin >> N >> K;;
        vector<int>Arr;
        for(int i=0;i<N;++i){
            int x;
            cin>>x;
            Arr.push_back(x);
        }
        Solution ob;
        cout << ob.maximumSumSubarray(K,Arr,N) << endl;
    }
    return 0; 
} 
// } Driver Code Ends