package utils;

/**
 * @ClassName Task
 * @Description TODO
 * @Author 谭颍豪
 * @Date 2023/1/31 17:31
 * @Version 1.0
 **/
public class Task {
    public int id; //任务号
    public int ddl; //deadline
    public int cost; //惩罚

    public Task() {

    }

    public Task(int id, int ddl, int cost) {
        this.id = id;
        this.ddl = ddl;
        this.cost = cost;
    }

}
