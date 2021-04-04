//--------------方法1------------------------
class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int insertIndex = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] < target) {
                insertIndex = i + 1;
            } else if (nums[i] == target) {
                return i;
            } else {
                return i;
            }
        }

        return insertIndex;
    }
}
//-----------------方法2：二分查找---------------------
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}