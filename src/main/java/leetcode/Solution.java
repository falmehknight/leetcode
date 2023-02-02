package leetcode;

import utils.Task;
import utils.TreeNode;
import utils.TreeNodeUtil;

import java.math.BigDecimal;
import java.util.*;

import static leetcode.Question4.findMedianSortedArrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 谭颍豪
 * @Date 2023/1/25 16:20
 * @Version 1.0
 **/
public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
//        Integer[] tree = new Integer[]{5,1,4,null,null,3,6};
//        TreeNode root = TreeNodeUtil.arrayToTreeNode(tree);
//        System.out.println("输入：");
//        BinarySearchTree.show(root);
//        System.out.println("输出：" + BinarySearchTree.judgeBST(root));
//        System.out.println("解释：输入为：" + Arrays.toString(tree));

//        int[] in = new int[]{1,5,6,7,8,9,10,11,12,13,14,15};
//        int[] remove = new int[]{14,9,5};
//        //测试插入
//        RBTree test = new RBTree();
//        for (int i : in) {
//            test.insertNode(i);
//        }
//        test.printRBTree();
//        for (int i : remove) {
//            test.deleteNode(i);
//        }
//        test.printRBTree();

//        int [] record = new int[7];
//        Arrays.fill(record,-1);
//        Task[] task = new Task[7];
//        task[6] = new Task(1,4,0);
//        task[5] = new Task(2,2,10);
//        task[4] = new Task(3,4,20);
//        task[3] = new Task(4,3,30);
//        task[2] = new Task(5,1,40);
//        task[1] = new Task(6,4,50);
//        task[0] = new Task(7,6,60);
//        int costSum = HandleTask.handleTask(task,record);
//        System.out.println("最终总的惩罚为："+costSum);
//        System.out.println("任务的顺序是：");
//        for (int i = 0; i < record.length; i++) {
//            System.out.printf("第%d天执行的任务是TASK",i+1);
//            if(record[i] > 0){
//                System.out.println(record[i]);
//            }
//            else {
//                System.out.println("其他未按时完成的任务");
//            }
//        }
        Integer[] v = new Integer[]{6,3,5,4,6};
        Integer[] w = new Integer[]{2,2,6,5,4};
        int n = 5;
        int weight = 10;
        Bag0_1.dynamicProgram(v,w,n,weight);
        Bag0_1.greedySolution(v,w,n,weight);





    }















}
