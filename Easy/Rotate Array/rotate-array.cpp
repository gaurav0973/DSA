//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution{
    public:
    
    //Function to rotate an array by d elements in counter-clockwise direction. 
    void rotateArr(int arr[], int d, int n){
        //0. make sure k have the valid rotation
        d = d%n;
        
        
        //1. reverse the entire array
        reverse(arr, 0, n-1);

        //2.reverse first k elemnt
        reverse(arr, 0, n-d-1);

        //reverse elemnts after k elemnts
        reverse(arr, n-d, n-1);
        
    }
    void reverse(int arr[], int start, int end){
        int sp = start;
        int ep = end;
        while(sp < ep){
            swap(arr[sp], arr[ep]);
            sp++;
            ep--;
        }
    }
};

//{ Driver Code Starts.

int main() {
	int t;
	//taking testcases
	cin >> t;
	
	while(t--){
	    int n, d;
	    
	    //input n and d
	    cin >> n >> d;
	    
	    int arr[n];
	    
	    //inserting elements in the array
	    for(int i = 0; i < n; i++){
	        cin >> arr[i];
	    }
	    Solution ob;
	    //calling rotateArr() function
	    ob.rotateArr(arr, d,n);
	    
	    //printing the elements of the array
	    for(int i =0;i<n;i++){
	        cout << arr[i] << " ";
	    }
	    cout << endl;
	}
	return 0;
}
// } Driver Code Ends