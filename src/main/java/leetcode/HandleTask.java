package leetcode;

import utils.Task;

/**
 * @ClassName HandleTask
 * @Description 贪心处理最佳任务调度
 * @Author 谭颍豪
 * @Date 2023/1/31 17:33
 * @Version 1.0
 **/
public class HandleTask {
    public static int handleTask(Task[] arr,int[] record){
        //sort(arr); //按惩罚顺序从小到大排序
        int punishment = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].ddl-1; j >=0 ; j--) {
                if(record[j] == -1){  //第j天无任务
                    record[j] = arr[i].id;
                    break;
                }
                if(j==0){
                    punishment += arr[i].cost;
                }
            }
        }
        return punishment;
    }

    public static void sort(Task[] arr){

    }
}
