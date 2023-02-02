import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class CompleteBinaryTree {
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(node.left);
            }

            if (node.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
    
        CompleteBinaryTree solution = new CompleteBinaryTree();
        System.out.println(solution.isComplete(root));
    }
    

}
