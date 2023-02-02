package utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName TreeNodeUtil
 * @Description 节点用的一些工具方法
 * @Author 谭颍豪
 * @Date 2023/1/29 12:36
 * @Version 1.0
 **/
public class TreeNodeUtil {

    /**
     *
     * @Author TanYingHao
     * @Description 一维数组转换为二叉树结构
     * @Date 12:38 2023/1/29
     * @Param [array]
     * @return utils.TreeNode
     **/
    public static TreeNode arrayToTreeNode(Integer[] array){
        if(array.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length ; i++) {
            TreeNode node = queue.peek();
            if(isLeft){
                if(array[i] != null ){
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            }
            else {
                if(array[i] != null){
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

}
