package leetcode

/*
 * @lc app=leetcode.cn id=704 lang=golang
 *
 * [704] 二分查找
 */

// @lc code=start
func search(nums []int, target int) int {
	min := 0
	max := len(nums) - 1
	for i := 0; i < len(nums); i++ {
		if max-min <= 0 {
			break
		}
		mid := min + (max-min)/2
		if nums[mid] == target {
			return mid
		}
		if nums[mid] > target {
			max = mid - 1
		}
		if nums[mid] < target {
			min = mid + 1
		}
	}
	return -1
}

// @lc code=end
