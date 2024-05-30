//{ Driver Code Starts
//Initial template for C++ 
 
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

//User function template for C++

class Solution{
  public:		
	int lps(string s) {
	    
	    int n = s.size();
	    vector<int> lps(n,0);
	    int pre = 0;
	    int suff = 1;
	    while( suff < n){
	        //matching
	        if(s[pre] == s[suff]){
	            lps[suff] = pre + 1;
	            suff++;
	            pre++;
	        }
	        
	        //not matching
	        else{
	            //pre at index = 0
	            if(pre == 0){
	                lps[suff] = 0;
	                suff++;
	            }
	            else{
	                pre = lps[pre-1];
	            }
	        }
	    }
	    return lps[n-1];
	}
};

//{ Driver Code Starts.

int main() 
{
   

   	ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
   
   	int t;
   	cin >> t;
   	while(t--)
   	{
   		string str;
   		cin >> str;

   		Solution ob;

   		cout << ob.lps(str) << "\n";
   	}

    return 0;
}

// } Driver Code Ends