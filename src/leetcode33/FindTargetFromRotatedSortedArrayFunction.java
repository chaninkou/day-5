package leetcode33;

public class FindTargetFromRotatedSortedArrayFunction {
	
	// This will be log(n) because we don't have to go through the whole array, we are using binary search 2.0 to do it
	// This will only work if its half sorted
	public int search(int[] nums, int target) {
		// First, check if the array is empty or null
		if (nums.length == 0 || nums == null) {
			return -1;
		}

		// Setting up start from 0 to the end
		int left = 0;
		int right = nums.length - 1;

		// Included because we are only return mid to be our answer inside this loop
		while (left <= right) {
			int mid = left + (right - left) / 2;

			// Once if middle index is the target, return mid
			if (nums[mid] == target) {
				return mid;
			}
			
			// There is a pattern, nums[left] < target < nums[mid]
			// nums[mid] < target <= nums[right]
			if (nums[left] <= nums[mid]) {
				// Checking if the target is on the left side
				if (nums[left] <= target && target < nums[mid]) {
					// Drop right side if target is on left
					right = mid - 1;
				} else {
					// Drop left side if target is on right
					left = mid + 1;
				}
			} else { // if mid point is bigger than right side or pivot is on
						// the left
				if (nums[mid] < target && target <= nums[right]) {
					// Drop left side if target is on right
					left = mid + 1;
				} else {
					// Drop right side if target is on left
					right = mid - 1;
				}
			}

		}

		// -1 mean target not inside
		return -1;
	}
}
