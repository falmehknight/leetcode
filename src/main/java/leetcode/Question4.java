package leetcode;
import java.util.*;
/**
 * @ClassName Question4
 * @Description  4.寻找两个正序数组的中位数.
 * @Author 谭颍豪
 * @Date 2023/1/26 16:01
 * @Version 1.0
 **/
public class Question4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        if(len%2 == 1)//根据长度的奇偶性进行不同处理。
            return findKthNum(nums1,nums2,0,0,len/2+1);
        else {
            return (findKthNum(nums1,nums2,0,0,len/2)+findKthNum(nums1,nums2,0,0,len/2+1))/2.0;
        }
    }
    public static int findKthNum(int[] nums1,int[] nums2,int s1,int s2,int k){//s1,s2表示nums1，nums2开始的位置
        int n = nums1.length-s1;
        int m = nums2.length-s2;
        if(n>m) return findKthNum(nums2,nums1,s2,s1,k); //保证第一个数组比第二个数组短
        if(n==0) return nums2[k-1+s2];//如果第一个数组为空了，则直接返回第二个数组的第k个元素即可
        if(k==1) return Math.min(nums1[s1],nums2[s2]);//如果找第一个元素则就是两个数组第一个元素中的较小值
        int p = Math.min(n,k/2);//找到第一个数组的第k/2处，如果这个数比n都大了，则说明他到了结尾，最大只能取n
        int q = k-p;//每次其实就是尽量去掉一半的元素，所以这里是第二个元素对应的需要与一比较的地方
        if(nums1[p-1+s1]<nums2[q-1+s2]){//如果第二个数组对应元素大一点，则说明一数组可以去掉前p项
            return findKthNum(nums1,nums2,s1+p,s2,q);
        }
        else if(nums1[p-1+s1]>nums2[q-1+s2]){ //反之则去掉二数组
            return findKthNum(nums1,nums2,s1,s2+q,p);
        }
        else  return nums1[p-1+s1];  //如果相等，则说明这个元素就是要求的第k个元素
    }

}
