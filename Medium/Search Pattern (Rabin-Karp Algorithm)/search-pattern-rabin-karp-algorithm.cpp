//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    public:
        vector<int> search(string pattern, string text) {
        const int PRIME = 101;  // A prime number for calculating hash values
        vector<int> resultIndices;
        int textLen = text.size();
        int patternLen = pattern.size();

        // If the pattern is longer than the text, no match is possible
        if (patternLen > textLen) {
            return resultIndices;
        }

        // Helper function to calculate hash value of a given string
        auto calculateHash = [&](const string &str, int end) {
            long long hashValue = 0;
            for (int i = 0; i <= end; ++i) {
                hashValue += (str[i] - 'a' + 1) * pow(PRIME, i);
            }
            return hashValue;
        };

        // Helper function to recalculate hash by sliding window technique
        auto recalculateHash = [&](const string &str, int oldIndex, int newIndex, long long oldHash) {
            long long newHash = oldHash - (str[oldIndex] - 'a' + 1);
            newHash /= PRIME;
            newHash += (str[newIndex] - 'a' + 1) * pow(PRIME, patternLen - 1);
            return newHash;
        };

        // Helper function to check if two substrings are equal
        auto checkEqual = [&](const string &str1, const string &str2, int start1, int end1, int start2, int end2) {
            if (end1 - start1 != end2 - start2) {
                return false;
            }
            while (start1 <= end1 && start2 <= end2) {
                if (str1[start1] != str2[start2]) {
                    return false;
                }
                ++start1;
                ++start2;
            }
            return true;
        };

        // Calculate the hash values for the pattern and the first window of the text
        long long patternHash = calculateHash(pattern, patternLen - 1);
        long long textHash = calculateHash(text, patternLen - 1);

        // Iterate through the text to find all occurrences of the pattern
        for (int i = 0; i <= textLen - patternLen; ++i) {
            // Check if the current window's hash matches the pattern's hash
            if (patternHash == textHash && checkEqual(text, pattern, i, i + patternLen - 1, 0, patternLen - 1)) {
                resultIndices.push_back(i + 1); // Use 1-based indexing
            }
            // Recalculate the hash value for the next window
            if (i < textLen - patternLen) {
                textHash = recalculateHash(text, i, i + patternLen, textHash);
            }
        }

        return resultIndices;
    }
     
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string S, pat;
        cin >> S >> pat;
        Solution ob;
        vector <int> res = ob.search(pat, S);
        for (int i : res) cout << i << " ";
        cout << endl;
    }
    return 0;
}

// Contributed By: Pranay Bansal

// } Driver Code Ends