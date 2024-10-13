The problem involves calculating the amount of water that can be trapped between bars in a histogram after raining. The key insight is to understand that for each position, the water trapped depends on the height of the tallest bars to its left and right. By precomputing the maximum heights from the left and right for each position, we can efficiently calculate the water trapped at each position in linear time.


# Trapping Rain Water

## Problem Statement

You are given an array of non-negative integers called `height`, representing the elevation map. Each element in the array represents the height of a bar, and the width of each bar is 1. Your task is to calculate how much water can be trapped between these bars after it rains.

### Example

For the input `height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]`, the output should be `6`. 

This is because water can be trapped in the following way:

   #
 # #


## Approach

To find out how much water can be trapped between the bars after it rains, we will use two helper arrays: `leftMax` and `rightMax`. These arrays allow us to keep track of the maximum heights of bars on both sides of each position in the `height` array.

### Steps

1. **Create Helper Arrays**:
   - **`leftMax`**: This array will store the maximum height of bars from the left up to each index. At index `i`, `leftMax[i]` represents the tallest bar encountered from the left side.
   - **`rightMax`**: This array will store the maximum height of bars from the right up to each index, similarly reflecting the tallest bar encountered from the right side.

2. **Populate the `leftMax` Array**:
   - Start by setting the first element: `leftMax[0] = height[0]`.
   - For each subsequent bar (from left to right), update `leftMax[i]` to be the maximum of the current bar's height and the previous maximum height stored in `leftMax[i - 1]`.

3. **Populate the `rightMax` Array**:
   - Start by setting the last element: `rightMax[n - 1] = height[n - 1]`.
   - For each preceding bar (from right to left), update `rightMax[i]` to be the maximum of the current bar's height and the maximum height stored in `rightMax[i + 1]`.

4. **Calculate Trapped Water**:
   - For each bar, determine the potential water level above it using: `waterLevel = min(leftMax[i], rightMax[i])`.
   - The amount of water trapped at that index is the difference between this water level and the height of the bar: `trappedWater += waterLevel - height[i]`.

5. **Sum It Up**:
   - Finally, add the trapped water for all the bars to get the total amount of water that can be trapped after the rain.

### Example

Consider the following elevation map represented by the array:

height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]


- **Step 1**: Create `leftMax` and `rightMax` arrays.
  
leftMax = [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3] rightMax = [3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 1]


- **Step 2**: Calculate the trapped water for each index:

At index 0: waterLevel = min(0, 3) = 0 → trapped = 0 - 0 = 0 At index 1: waterLevel = min(1, 3) = 1 → trapped = 1 - 1 = 0 At index 2: waterLevel = min(1, 3) = 1 → trapped = 1 - 0 = 1 At index 3: waterLevel = min(2, 3) = 2 → trapped = 2 - 2 = 0 At index 4: waterLevel = min(2, 3) = 2 → trapped = 2 - 1 = 1 At index 5: waterLevel = min(2, 3) = 2 → trapped = 2 - 0 = 2 At index 6: waterLevel = min(2, 3) = 2 → trapped = 2 - 1 = 1 At index 7: waterLevel = min(3, 3) = 3 → trapped = 3 - 3 = 0 At index 8: waterLevel = min(3, 3) = 3 → trapped = 3 - 2 = 1 At index 9: waterLevel = min(3, 3) = 3 → trapped = 3 - 1 = 2 At index 10: waterLevel = min(3, 3) = 3 → trapped = 3 - 2 = 1 At index 11: waterLevel = min(3, 1) = 1 → trapped = 1 - 1 = 0


- **Total Trapped Water**: Summing up the trapped water from all indices gives us `6` units of water.

## Conclusion

This approach allows us to efficiently calculate the amount of water that can be trapped using O(n) time and O(n) space. The use of `leftMax` and `rightMax` arrays provides a clear way to determine the water levels above each bar based on the heights around it.
