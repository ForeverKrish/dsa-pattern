# Container With Most Water

**Question:**
Given `height` array representing vertical lines at coordinates, find two lines that form a container holding the maximum water. Return the maximum area.

**Explanation:**
Initialize `lo=0, hi=n−1`. Compute area = width × min(height[lo], height[hi]). Move the pointer at the shorter line inward to potentially find a taller boundary. O(n) time, O(1) space.