package leetcode;

/**
 * @ClassName CountingSort
 * @Description TODO
 * @Author 谭颍豪
 * @Date 2023/1/28 11:46
 * @Version 1.0
 **/
public class CountingSort {
    public static void countingSort(int[] nums1, int[] nums2, int l, int r){
        int[] temp = new int[r+1];
        int size = nums1.length;
        System.out.println("过程中辅助数组的变化：");
        helpPrint(temp,l);  //打印大于下限值的地方
        for (int j : nums1) {
            temp[j] += 1;  //计数，记录所有出现元素的次数，并放入对应的辅助数组中
        }
        helpPrint(temp,l);
        for (int i = 1; i <=r ; i++) {
            temp[i] += temp[i-1];  //将辅助数组变化成记录元素应该在新数组中所处的位置
        }
        helpPrint(temp,l);
        for (int i = size-1; i >=0 ; i--) {
            int pos = --temp[nums1[i]];
            nums2[pos] =nums1[i];
        }
        System.out.println("最后排好序的结果为：");
        for (int i : nums2) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
    public static void helpPrint(int[] a,int l){
        for (int i = l; i <a.length ; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
