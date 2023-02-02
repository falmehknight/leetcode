package leetcode;

import com.sun.javaws.IconUtil;

import javax.imageio.stream.ImageInputStream;
import java.util.Arrays;

/**
 * @ClassName Bag0_1
 * @Description 0-1背包问题，两种解法
 * @Author 谭颍豪
 * @Date 2023/1/31 22:27
 * @Version 1.0
 **/
public class Bag0_1 {
    /**
     *
     * @Author TanYingHao
     * @Description 动态规划解决0-1背包问题
     * @Date 22:30 2023/1/31
     * @Param [v：商品价值集合, w：商品重量集合, n：商品数, weight：背包总重量]
     **/
    public static void dynamicProgram(Integer[] v, Integer[] w, int n, int weight){
        int[][] val = new int[n+1][weight+1];
        for (int i = 0; i < n+1; i++) {  //初始化为0
            for (int j = 0; j < weight+1; j++) {
                val[i][j] = 0;
            }
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=weight ; j++) {
                if(w[i-1] > j) {  //放不进背包里,这里注意w是从0开始的
                    val[i][j] = val[i-1][j];
                }
                else {
                    val[i][j] = Math.max(val[i-1][j],val[i-1][j-w[i-1]]+v[i-1]);
                }
            }
        }
        //打印动态规划表用来分析
        for (int[] ints : val) {
            for (int j = 0; j <=weight; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @Author TanYingHao
     * @Description 贪心解决0-1背包问题
     * @Date 22:59 2023/1/31
     * @Param [v, w, n, weight]
     **/
    public static void greedySolution(Integer[] v, Integer[] w, int n, int weight){
        double value = 0; //记录背包里面放入的总价值
        double[] prices = new double[n];  //记录各个商品的单位价格
        for (int i = 0; i < n; i++) {
            prices[i] = (double) v[i]/w[i];
        }

        int count = 0; //记录步数
        while(weight>0 && count<n){  //如果背包为空或者商品都被试着装进过背包则结束
            count++;
            int m =findMax(prices); //找到剩余物体中单位价值最高的物体所在的下标
            if(w[m] <= weight){  //如果可以被装入里面
                value += v[m];
                weight -= w[m];
                System.out.println("第"+count+"步装入的商品价值为："+v[m]+",重量为："+w[m]+",剩余的背包容量是"+weight
                        + ",当前背包总价值是"+value);
            }
            else {
                System.out.println("第"+count+"步不符合条件,所以未装入商品,剩余的背包容量是"+weight
                        + ",当前背包总价值是"+value);
            }
            prices[m] = 0.0;  //已被拿走的就删去
        }
        System.out.println("商品最后装的总价值为："+value);
    }

    private static int findMax(double[] p){
        int max = 0;
        for (int i = 1; i <p.length ; i++) {
            if(p[i] - p[max] > 0.000001){
                max = i;
            }
        }

        return max;
    }
}
