//链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numAppearTimeMap = new HashMap<>();
        for (int i : nums) {
            if (!numAppearTimeMap.containsKey(i)) {
                numAppearTimeMap.put(i, 0);
            } else {
                int appearTime = numAppearTimeMap.get(i);
                appearTime++;
                numAppearTimeMap.put(i, appearTime);
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : numAppearTimeMap.entrySet()) {
            int num = entry.getKey();
            int appearTime = entry.getValue();

            if (queue.isEmpty() || queue.size() < k || appearTime > queue.peek()[1]) {
                queue.offer(new int[]{num, appearTime});
            }
            if (queue.size() > k) {
                queue.poll(); // 删除堆顶最大元素
            }  
        }

        int[] res = new int[k];
        int j = 0;
        for (int[] i : queue) {
            res[j++] = i[0];
        }

        return res;
    }
}