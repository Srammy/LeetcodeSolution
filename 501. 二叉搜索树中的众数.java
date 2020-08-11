/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> nodeAppeartimesMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        inOrder(root, nodeAppeartimesMap);
        int maxAppeartimes = 0;
        for (int i : nodeAppeartimesMap.values()) {
            if (i > maxAppeartimes) {
                maxAppeartimes = i;
            }
        }
        Iterator<Integer> keys = nodeAppeartimesMap.keySet().iterator();
        while(keys.hasNext()){
            int key = keys.next();
            if (nodeAppeartimesMap.get(key) == maxAppeartimes) {
                res.add(key);
            }
        }

        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    private void inOrder(TreeNode node, Map<Integer, Integer> nodeAppeartimesMap) {
        if (node == null) return;
        inOrder(node.left, nodeAppeartimesMap);
        if (!nodeAppeartimesMap.containsKey(node.val)) {
            nodeAppeartimesMap.put(node.val, 1);
        } else {
            int appeartimes = nodeAppeartimesMap.get(node.val);
            appeartimes++;
            nodeAppeartimesMap.put(node.val, appeartimes);
        }
        inOrder(node.right, nodeAppeartimesMap);
    }
}