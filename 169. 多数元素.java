//-----------------------------方法1：用map记录每个元素的出现次数----------------------
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numAppearTimeMap = new HashMap<>();
        for (int num : nums) {
            if (!numAppearTimeMap.containsKey(num)) {
                numAppearTimeMap.put(num, 1);
            } else {
                int numAppearTime = numAppearTimeMap.get(num);
                numAppearTime++;
                numAppearTimeMap.put(num, numAppearTime);
            }
        }

        int max = 0;
        int num = 0;

        for (Map.Entry<Integer, Integer> entry : numAppearTimeMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                num = entry.getKey();
            }
        }

        return num;
    }
}
//---------------------------方法2：排序，找中间的数---------------------
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
//---------------------------方法3：Boyer-Moore 投票算法-------------------------------------
//链接：https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
class Solution {
    public int majorityElement(int[] nums) {
        int majorNum = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                majorNum = num;
            }

            if (num == majorNum) {
                count++;
            } else {
                count--;
            }
        }

        return majorNum;
    }
}