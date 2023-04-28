import java.util.Base64;

import javax.naming.PartialResultException;

/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        //冒泡
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < nums.length-1-i; j++) {
        //         if (nums[j] > nums[j+1]){
        //             int a = nums[j];
        //             nums[j] = nums[j+1];
        //             nums[j+1] = a;
        //         }
        //     }
        // }

        //选择
        // for (int i = 0; i < nums.length; i++) {
        //     int min = i;
        //     for (int j = i+1; j < nums.length; j++) {
        //         if (nums[j]<nums[min]){
        //             min = j;
        //         }
        //     }
        //     int a = nums[i];
        //     nums[i] = nums[min];
        //     nums[min] = a;
        // }

        //插入
        // for (int i = 1; i < nums.length; i++) {
        //     int tmp = nums[i];
        //     for (int j = i-1; j >= 0; j--) {
        //         if (nums[j]>tmp) {
        //             nums[j+1] = nums[j];
        //             nums[j] = tmp;
        //         }
        //     }
        // }

        //快排
        int left = 0;
        int right = nums.length-1;
        quickSort(nums,left,right);
        return nums;
    }
    public void quickSort(int[] nums, int left, int right ){
        if (left < right) {
            int povit = partition(nums,left,right);
            // System.out.println("povit:"+povit);
            quickSort(nums,left,povit-1);
            quickSort(nums,povit+1,right);
        }  
    }
    //lomuto分区-同向
    // public int partition(int[] nums, int left, int right ){
    //     int base = right;
    //     for (int i = left; i <= right; i++) {
    //         if (nums[i]<nums[base]){
    //             int tmp = nums[left];
    //             nums[left] = nums[i];
    //             nums[i] = tmp;
    //             left++;
    //         }
    //     }
    //     int tmp = nums[left];
    //     nums[left] = nums[base];
    //     nums[base] = tmp;
    //     return left;
    // }
    //hoare分区-相向
    // public int partition(int[] nums, int left, int right ){
    //     int base = right;
    //     while (left < right) {
    //         while (left < right&&nums[left]<=nums[base]){
    //             left++;
    //         }
    //         while (left < right&&nums[right]>=nums[base]){
    //             right--;
    //         }
    //         if (left < right){
    //             int tmp = nums[left];
    //             nums[left] = nums[right];
    //             nums[right] = tmp;
    //         }
    //     }
    //     int tmp = nums[left];
    //     nums[left] = nums[base];
    //     nums[base] = tmp;
    //     return left;
    // }
    //hoare分区-挖坑
    public int partition(int[] nums, int left, int right ){
        int base = nums[right];
        // System.out.println("right:"+right);
        // System.out.println("left:"+left);
        while (left < right) {
            while (left < right && nums[left]<=base){
                left++;
            }
            if (left < right){
                nums[right] = nums[left]; 
                right--;
            }          
            while (left < right && nums[right]>=base) {
                right--;
            }
            if (left < right){
                nums[left] = nums[right];
                left++;  
            }
                    
        }
        nums[left] = base;
        return left;
    }
}
// @lc code=end

