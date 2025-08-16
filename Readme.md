# 📐 Maths

# 🔍 Binary Search

## Simple Binary Search
## Lower and upper Bound
## smallest in rotated sorted array
## Binary search on answer
## Median in two sorted arrays

# 🔁 Cyclic Sort

# 🔀 Merge Sort

# 🔗 Linked List

# 🛢️ Heaps

# 🚪 Sliding Window

## Fixed size window
- [Max Sum Subarray of size K
](https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1?page=1&category=CPP,sliding-window&sortBy=submissions)
## Variable size window
- [Minimum Window Substring
](https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1?page=1&category=sliding-window&difficulty=Hard&sortBy=submissions)
- [K Sized Subarray Maximum
](https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1?page=1&category=CPP,sliding-window&sortBy=submissions)
-[First negative in every window of size k
](https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1?page=1&category=CPP,sliding-window&sortBy=submissions) 
- [Max of min for every window size
](https://www.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1?page=2&category=CPP,sliding-window&sortBy=submissions)
- [Substrings with K Distinct
](https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1?page=1&category=CPP,sliding-window&sortBy=submissions)
- [Count distinct elements in every window
](https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1?page=1&category=CPP,sliding-window&sortBy=submissions)
- [Smallest Subarray with Sum Greater than X
](https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1?page=1&category=CPP,sliding-window&sortBy=submissions)
- [Longest subarray with Atmost two distinct integers
](https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1?page=1&category=CPP,sliding-window&sortBy=submissions)
- [Largest subarray of 0's and 1's
](https://www.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1?page=1&category=CPP,sliding-window&sortBy=submissions)
- [Smallest distinct window
](https://www.geeksforgeeks.org/problems/smallest-distant-window3132/1?page=1&category=CPP,sliding-window&sortBy=submissions)
## Number of subarray + condition
- [Binary Subarray with Sum
](https://www.geeksforgeeks.org/problems/binary-subarray-with-sum/1)
- [Count Subarray with K Odds
](https://www.geeksforgeeks.org/problems/count-subarray-with-k-odds/1)
- [Count the number of Subarrays
](https://www.geeksforgeeks.org/problems/count-the-number-of-subarrays/1?page=1&category=sliding-window&difficulty=Hard&sortBy=submissions)

## k-sum pattern

- [Indexes of Subarray Sum
](https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&category=CPP,sliding-window&sortBy=submissions)
-[Subarray with 0 Sum
](https://www.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1?page=1&category=CPP,sliding-window&sortBy=submissions)

# 👬 Two Pointers

# ➕ Prefix Sum

# 🗄️ Stack and Queues

## Hard Problems
- [Trapping Rain Water](https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1?page=1&category=CPP,stack&sortBy=submissions)

### Solution
1. **Brute Force**
- leftMaxElement
- rightMaxElement
- s = min(leftMaxElement, rightMaxElement)
- ans += max(0, s - height[i])

2. **Two Pointer Approach**: 
- l = 0 , r = n-1
- leftMax = 0, rightMax = 0
- while(l <= r)
    - leftMax = max(leftMax, height[l])
    - rightMax = max(rightMax, height[r])
    - if(leftMax <= rightMax)  ➡️🤔 matlb right wala bada hai => ans left se aayega
        - ans += max(0, leftMax - height[l])
        - l++
    - else
        - ans += max(0, rightMax - height[r])
        - r--


- [Histogram Max Rectangular Area](https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1?page=1&category=Stack,Queue&difficulty=Hard&sortBy=submissions)
### Solution
1. **Brute Force**
   - find prevSmallerElement
   - find nextSmallerElement
   - Traverse(i=0 - n-1)
        - width = (nse[i] - pse[i] - 1)
        - area = width * height[i]
        - maxArea = max(maxArea, area)

2. **Optimal Approach**


- [Longest Valid Parentheses](https://www.geeksforgeeks.org/problems/longest-valid-parentheses5657/1?page=1&category=Stack,Queue&difficulty=Hard&sortBy=submissions)

### solution
1. **Brute Force**
   - store invalid indexes => O(n)
   - diffrence b/w two consecutive invalid indexes will give the length of max valid substring
2. **Optimal Approach**


- [Max rectangle](https://www.geeksforgeeks.org/problems/max-rectangle/1?page=1&category=Stack,Queue&difficulty=Hard&sortBy=submissions)

### solution
- Prereq : Max area in a histogram
- Use the same approach as finding the max area in a histogram for each row of the matrix.
- Note : update the row values to represent the height of the bars in the histogram.



# 🌳 Trees

# 🧠 DP

# 🌐 Graphs

# 🕸️ Tries
