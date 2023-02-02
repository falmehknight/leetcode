package utils;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author 谭颍豪
 * @Date 2023/1/29 12:26
 * @Version 1.0
 **/
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}
