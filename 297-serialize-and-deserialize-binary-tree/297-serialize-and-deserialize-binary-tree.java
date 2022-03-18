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
        if(root == null) return "#,";
        String l = serialize(root.left);
        String r = serialize(root.right);
        String s = root.val+",";
        return s+l+r;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q= new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return deserializeQueue(q);
    }
    
    TreeNode deserializeQueue(Queue<String> q){
        
            String s = q.poll();
        if(s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserializeQueue(q);
        root.right = deserializeQueue(q);
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));