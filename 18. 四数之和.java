////链接：https://leetcode-cn.com/problems/4sum/solution/liang-chong-fang-fa-diao-da-nshu-zhi-he-esxsi/
//---------------方法1----------------------
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<4)  return res;
        //初始化左右可移动的指针
        int left=0;
        int right=0;
        int sum=0;
        Arrays.sort(nums);
        //四个指针都要去重！！！！！
        for(int i=0;i<nums.length-3;i++){
            //指针i去重
            if(i>0 && nums[i]==nums[i-1])    continue;
            for(int j=i+1;j<nums.length-2;j++){
                //指针j去重
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                //设置左右指针位置
                left=j+1;
                right=nums.length-1;
                while(left<right){
                    sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);

                        res.add(list);
                        //指针left和right去重
                        while(left<right && nums[left]==nums[left+1])   left++;
                        while(left<right && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if(sum<target){
                        left++;
                    }
                    else if(sum>target){
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
//------------------方法2：回溯---------------------
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList();
        if(nums.length==0)  return res;
        List<Integer> list=new ArrayList();
        int width=0;    //用于回溯递归结束条件的确定，width==4时返回
        Arrays.sort(nums);

        backtrack(nums,0,target,width,res,list);
        return res;
    }

    public void backtrack(int[] nums,int start,int target,int width,List<List<Integer>> res,List<Integer> list){
        //注意一：必须凑齐四个数字才能退出，且恰好达到target值才能作为一个结果返回
        if(width==4){
            if(target==0){
                res.add(new ArrayList(list));
            }
            return;
        }

        for(int i=start;i<nums.length;i++){
            //注意二：去除重复解
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            backtrack(nums,i+1,target-nums[i],width+1,res,list);
            list.remove(list.size()-1);
        }
    }
}