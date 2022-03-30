/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return ",";
        return root.val+","+serialize(root.left)+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(arr));
        return deserializeTree(q);
        
    }
    
    TreeNode deserializeTree(Queue<String> q){
            if(q.isEmpty()) return null;
            String s = q.poll();
        if(s.isEmpty()) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserializeTree(q);
        root.right = deserializeTree(q);
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;