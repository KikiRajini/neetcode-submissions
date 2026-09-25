class Solution {
    /**
     * Finds the maximum element in every sliding window of size k.
     * 
     * WHY MONOTONIC DEQUE OVER PRIORITY QUEUE (MAX-HEAP)?
     * - PriorityQueue auto-sorts in O(log k), but removing stale elements outside 
     *   the window takes O(k), leading to O(N * k) worst-case time (TLE).
     * - Monotonic Deque maintains indices of elements in strictly DECREASING order.
     *   Each index is pushed/popped at most once -> O(1) amortized, O(N) overall.
     * 
     * DEQUE METHOD MAP:
     * - peekFirst() : Reads current max (always sits at the front/head).
     * - pollFirst() : Evicts max when it slides out of the window on the left.
     * - peekLast()  : Checks smallest element in window (at the back/tail).
     * - pollLast()  : Kills smaller elements that can never be max (dominated).
     * - offerLast() : Appends new index to the back to wait its turn for future windows.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];

        int[] result = new int[n - k + 1];
        int resIdx = 0;
        
        // Stores INDICES of elements in monotonic decreasing value order:
        // nums[deque.peekFirst()] > nums[...] > nums[deque.peekLast()]
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. EVICT STALE HEAD:
            // Valid window range for right index 'i' is [i - k + 1 ... i].
            // Index 'deque.peekFirst()' <= (i - k) sits strictly to the left 
            // of the window bound (i - k + 1), so it must be removed.
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. ENFORCE MONOTONIC DECREASING ORDER:
            // Remove smaller elements from the back because 'nums[i]' is both 
            // LARGER and NEWER. Those smaller elements can NEVER be the max 
            // for this or any future window.
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 3. ADD CURRENT INDEX AT THE BACK
            deque.offerLast(i);

            // 4. RECORD MAXIMUM:
            // Once the first full window of size k is formed (i >= k - 1),
            // the front of the deque naturally holds the maximum index.
            if (i >= k - 1) {
                result[resIdx++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}