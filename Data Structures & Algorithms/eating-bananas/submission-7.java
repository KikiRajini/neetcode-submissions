class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right; // Default to max speed

        while (left <= right) {
            // Use this to prevent potential integer overflow in (left + right) / 2
            int middle = left + (right - left) / 2;
            int totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / middle);
            }
            if (totalTime <= h) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle+ 1;
            }
        }
        return result;
}
}