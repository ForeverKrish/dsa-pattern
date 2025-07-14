# Jump Game II

**Question:**
Minimum number of jumps to reach the last index.

**Explanation:**
Greedy layer-by-layer: within the current jump’s range `[0…currEnd]`, track the farthest next reach; when you exhaust the current layer (`i == currEnd`), increment `jumps` and start the next.