class Solution {
    public int trap(int[] height) {
        int n = height.length; // Length of the input array
        
        // Initialize leftMax array
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0]; // First element of leftMax is same as the first element of height
        
        // Fill leftMax array
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]); // Max height from the left up to index i
        }
        
        // Initialize rightMax array
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1]; // Last element of rightMax is same as the last element of height
        
        // Fill rightMax array
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]); // Max height from the right up to index i
        }
        
        // Calculate the total trapped water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]); // Water level at index i
            trappedWater += waterLevel - height[i]; // Trapped water at index i
        }
        
        return trappedWater; // Return the total trapped water
    }
}
