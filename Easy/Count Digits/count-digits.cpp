//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std;

// } Driver Code Ends
class Solution{
public:
    int evenlyDivides(int N) {
        int count = 0;
        int temp = N;
        while (N > 0) {
            int lastDigit = N % 10;
            if (lastDigit != 0 && temp % lastDigit == 0) {
                count++;
            }
            N /= 10;
        }
    
    return count;
    }

};

//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin>>N;
        Solution ob;
        cout << ob.evenlyDivides(N) << endl;
    }
    return 0; 
}
// } Driver Code Ends