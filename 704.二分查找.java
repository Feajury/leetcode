
/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length-1;
        while (max-min>0){
            int mid = min+((max-min)/2);
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid]>target){
                max = mid-1;
            }
            if (nums[mid]<target){
                min = mid +1;
            }
        }
        return -1;

    }
}
// @lc code=end

