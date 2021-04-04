//--------------------方法1：选择排序----------------------------
class Solution {
    public void sortColors(int[] nums) {
        selectSort(nums);
    }

    private void selectSort(int[] array) {
       for(int i = 0; i < array.length - 1; i++) {  //进行array.length - 1轮比较
           int min = array[i];  // 最小值
           int minIndex = i;  // 最小值的位置
           for(int j = i + 1; j < array.length; j++) {
               if(array[j] < min) {
                   min = array[j];
                   minIndex = j;
               }
           }

           array[minIndex] = array[i];
           array[i] = min;
       }
   }
}
//-----------------方法2：单指针------------------------------
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }

        for (int i = left; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}