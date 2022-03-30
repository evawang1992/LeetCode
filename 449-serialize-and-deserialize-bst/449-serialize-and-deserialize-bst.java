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
        // if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    public void serialize(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val+",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)return null;
        String[] sarr = data.split(",");
        Queue<String> q = new LinkedList<String>(Arrays.asList(sarr));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    TreeNode deserialize(Queue<String> q, int lower, int upper){
        if(q.isEmpty()) return null;
        int num = Integer.valueOf(q.peek());
        if(num < lower || num > upper) return null;
        q.poll();
        TreeNode newNode = new TreeNode(num);
        newNode.left = deserialize(q, lower, num);
        newNode.right = deserialize(q, num, upper);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;