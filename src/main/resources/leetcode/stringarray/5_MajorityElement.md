# Majority Element

**Question:**
Return the element that appears more than ⌊n/2⌋ times in the array.

**Explanation:**
Boyer–Moore Voting: keep a running candidate and count. When count drops to zero, pick a new candidate. Because the majority element exceeds half, it remains in the end.