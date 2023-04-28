package aaa

/*
 * @lc app=leetcode.cn id=912 lang=golang
 *
 * [912] 排序数组
 */

// @lc code=start
func sortArray(nums []int) []int {
	left := 0
	rihgt := len(nums) - 1
	quicksort(nums, left, rihgt)
	return nums
}

func quicksort(nums []int, left int, right int) {
	if left < right {
		pivot := partition(nums, left, right)
		// fmt.Println("povit:", pivot)
		quicksort(nums, left, pivot-1)
		quicksort(nums, pivot+1, right)
	}
}

//lomuto
// func partition(nums []int, left int, right int) int {
// 	base := right
// 	for i := left; i < right; i++ {
// 		if nums[i] < nums[base] {
// 			nums[i], nums[left] = nums[left], nums[i]
// 			left++
// 		}
// 	}
// 	nums[base], nums[left] = nums[left], nums[base]
// 	return left
// }

//hoare
func partition(nums []int, left int, right int) int {
	base := right
	for {
		if left >= right {
			break
		}
		for {
			if left >= right || nums[left] > nums[base] {
				break
			}
			left++
		}
		for {
			if left >= right || nums[right] < nums[base] {
				break
			}
			right--
		}
		if left < right {
			nums[left], nums[right] = nums[right], nums[left]
		}
	}
	nums[base], nums[left] = nums[left], nums[base]
	return left
}

// @lc code=end
