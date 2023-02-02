package leetcode;

/**
 * @ClassName Question53
 * @Description TODO
 * @Author 谭颍豪
 * @Date 2023/1/26 16:03
 * @Version 1.0
 **/
public  class Question53 {
    static class Status{
        public int lSum,rSum,mSum,iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;  //以左端点为起点的最大子段和
            this.rSum = rSum;  //以右端点为起点的最大子段和
            this.mSum = mSum;  //整个区间的最大子段和
            this.iSum = iSum;  //区间和
        }
    }
    public static int maxSubArray(int [] nums){
        return getInfo(nums,0, nums.length-1).mSum;
    }
    //划分区间
    public static Status getInfo(int[] a, int l, int r){
        if (l == r) return new Status(a[l],a[l],a[l],a[l]);  //如果只有一个元素，则直接返回即可。
        int m = (l+r)/2; //从中间划分一下左区间和右区间
        Status lSub = getInfo(a,l,m);
        Status rSub = getInfo(a,m+1,r);
        return pushUp(lSub,rSub);
    }

    // 通过合并左右区间的信息得到[l，r]区间的信息，即得到四个值即可
    public static Status pushUp(Status l, Status r){
        int iSum = l.iSum + r.iSum;
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);//两种可能，要么等于右区间的rSum,要么跨越了界限，等于右区间的区间和和左区间的rSum
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int mSum = Math.max(Math.max(l.mSum,r.mSum),l.rSum+r.lSum);//分为跨越区间和不跨越区间，分别计算三个值比较大小即可
        return new Status(lSum,rSum,mSum,iSum);
    }

}
