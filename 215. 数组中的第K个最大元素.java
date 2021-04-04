class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();

        for (int e : nums) {
            if (heap.isEmpty() || heap.size() < k || e > heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); 
            }
        }

        return heap.peek();
        
        // int[] res = new int[heap.size()];
        // int j = 0;
        // for (int e : heap) {
        //     res[j++] = e;
        // }
        // return res[0];
    }
}