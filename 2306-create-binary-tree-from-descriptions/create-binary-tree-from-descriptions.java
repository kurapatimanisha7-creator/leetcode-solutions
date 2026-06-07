import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store value -> TreeNode mapping
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        // Set to store all values that are children
        Set<Integer> children = new HashSet<>();
        
        for (int[] d : descriptions) {
            int parentVal = d[0];
            int childVal = d[1];
            boolean isLeft = d[2] == 1;
            
            // Ensure parent node exists
            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            // Ensure child node exists
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));
            
            TreeNode parentNode = nodeMap.get(parentVal);
            TreeNode childNode = nodeMap.get(childVal);
            
            // Link parent and child
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            // Record that this node is a child
            children.add(childVal);
        }
        
        // The root is the only node in nodeMap that is never a child
        for (int parentVal : nodeMap.keySet()) {
            if (!children.contains(parentVal)) {
                return nodeMap.get(parentVal);
            }
        }
        
        return null;
    }
}