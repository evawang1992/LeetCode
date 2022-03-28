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
        if(root == null) return "X,";
        String cur = ""+root.val;
        return cur + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArr = data.split(",");
        Queue<String> q = new LinkedList<>();
        for(String s : strArr){
            q.offer(s);
        }
        return dfs(q);
        
    }
    TreeNode dfs(Queue<String> q){
        if(q.isEmpty()) return null;
        String s = q.poll();
        if(s.equals("X")) return null;
        TreeNode newNode = new TreeNode(Integer.valueOf(s));
        newNode.left = dfs(q);
        newNode.right = dfs(q);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));