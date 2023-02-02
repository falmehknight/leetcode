package utils;

/**
 * @ClassName RBTree
 * @Description TODO
 * @Author 谭颍豪
 * @Date 2023/1/29 16:58
 * @Version 1.0
 **/
public class RBTreeNode {
    public static final RBTreeNode nil = new RBTreeNode(0,null,RBTreeNode.BLACK,null,null);  //哨兵节点，
    public static final int RED = 1;
    public static final int BLACK = 0;

    public int value;
    public RBTreeNode parent;
    public int color ;
    public RBTreeNode left;
    public RBTreeNode right;

    public RBTreeNode() {
    }


    public RBTreeNode(int value) {
        this.value = value;
    }


    public RBTreeNode(int value, RBTreeNode parent, int color, RBTreeNode left, RBTreeNode right) {
        this.value = value;
        this.parent = parent;
        this.color = color;
        this.left = left;
        this.right = right;
    }

    public void setLeft(RBTreeNode left) {
        this.left = left;
    }

    public void setRight(RBTreeNode right) {
        this.right = right;
    }

    public void setParent(RBTreeNode parent) {
        this.parent = parent;
    }
}
