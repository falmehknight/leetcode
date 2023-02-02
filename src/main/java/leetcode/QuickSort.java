package leetcode;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author 谭颍豪
 * @Date 2023/1/26 19:54
 * @Version 1.0
 **/
public class QuickSort
{
    public static void quickSort(int[] a, int p, int r){
        int q = 0;
        if(p<r){
            q = partition(a,p,r);  //基准元素的位置q
            quickSort(a,p,q-1);
            quickSort(a,q+1,r);
        }
    }
    public static int partition(int[] a, int p, int r){
        int x = a[r]; //选择a[r]作为基准元素
        int j = p-1;
        for (int i = p; i < r; i++) {
            if(a[i]<x){ //将小于基准元素的值与前指针进行交换，保证前指针指向的之前均小于基准元素
                j++;
                swap(a,i,j);
            }
        }
        swap(a,j+1,r); //找到了基准元素应该放的位置。

        for (int k : a) {
            System.out.print(k);//打印排序的情况
            System.out.print(' ');
        }
        System.out.println();
        return j+1;
    }
    public static void swap(int[] a, int i, int j){
        int tmp=0;
        tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}
