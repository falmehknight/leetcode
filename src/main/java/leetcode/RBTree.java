package leetcode;

import utils.RBTreeNode;

/**
 * @ClassName RBTree
 * @Description 实现红黑树的插入和删除操作
 * @Author 谭颍豪
 * @Date 2023/1/29 17:04
 * @Version 1.0
 **/
public class RBTree {
    public RBTree() {
    }

    // 得到根节点。
    public RBTreeNode getRoot(){
        return RBTreeNode.nil.left == null ? RBTreeNode.nil : RBTreeNode.nil.left;
    }
    /**
     *
     * @Author TanYingHao
     * @Description 给一个元素插入到红黑树中
     * @Date 21:43 2023/1/29
     * @Param [value]
     **/
    public void insertNode(int value){
        RBTreeNode t = new RBTreeNode(value);
        insertNode(t);
    }

    public void insertNode(RBTreeNode z){
        z.left = RBTreeNode.nil;
        z.right = RBTreeNode.nil;
        z.color = RBTreeNode.RED;
        RBTreeNode y = RBTreeNode.nil ;
        RBTreeNode x = getRoot() ;
        while(x != RBTreeNode.nil){  //找合适的位置来插入z
            y = x;
            if(z.value < x.value){
                x = x.left;
            }
            else x = x.right;
        }
        z.parent = y;
        if(y == RBTreeNode.nil){ //如果一开始树是空的
            RBTreeNode.nil.left = z;
        }
        else if(z.value < y.value){ //如果节点值小于父节点的值，则为父节点的左孩子
            y.left = z;
        }
        else y.right = z;
        fixInsert(z);
    }
    /**
     *
     * @Author TanYingHao
     * @Description 恢复因插入而被破坏的红黑树性质
     * @Date 21:52 2023/1/29
     * @Param [p]
     **/

    private void fixInsert(RBTreeNode p){
        while (p.parent.color == RBTreeNode.RED){
            if(p.parent == p.parent.parent.left){
                RBTreeNode y = p.parent.parent.right;  //叔叔在右
                if( y.color == RBTreeNode.RED){   // case1:p的叔结点是红色的
                    p.parent.color = RBTreeNode.BLACK;
                    y.color = RBTreeNode.BLACK;
                    p.parent.parent.color = RBTreeNode.RED;
                    p = p.parent.parent;
                }
                else if(p == p.parent.right){  //case2: p的叔结点是黑色的且p是一个右孩子
                    p = p.parent;
                    rotateLeft(p);
                }
                else{
                    p.parent.color = RBTreeNode.BLACK; //case3: p的叔结点是黑色且p是一个左孩子
                    p.parent.parent.color = RBTreeNode.RED;
                    rotateRight(p.parent.parent);
                }

            }
            else {
                RBTreeNode y = p.parent.parent.left;  //叔叔在左
                if( y.color == RBTreeNode.RED){   // case1:p的叔结点是红色的
                    p.parent.color = RBTreeNode.BLACK;
                    y.color = RBTreeNode.BLACK;
                    p.parent.parent.color = RBTreeNode.RED;
                    p = p.parent.parent;
                }
                else if(p == p.parent.left){  //case2: p的叔结点是黑色的且p是一个左孩子  ,case2经过调整变为case3
                    p = p.parent;
                    rotateRight(p);
                }
                else {                      //case3: p的叔结点是黑色且p是一个右孩子
                    p.parent.color = RBTreeNode.BLACK;
                    p.parent.parent.color = RBTreeNode.RED;
                    rotateLeft(p.parent.parent);
                }
            }
        }
        getRoot().color = RBTreeNode.BLACK;  //这里是为了以防最后使得根节点为红，无法继续往上变红色
    }

    /**
     *
     * @Author TanYingHao
     * @Description  左旋调整
     * @Date 22:12 2023/1/29
     * @Param [p]
     *
     **/
    private void rotateLeft(RBTreeNode x){
        RBTreeNode y = x.right;
        x.right = y.left;
        if (y.left != RBTreeNode.nil){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == RBTreeNode.nil){  //如果x本身是根节点，需要更新根节点
            RBTreeNode.nil.setLeft(y);
        }
        else if(x == x.parent.left){
            x.parent.setLeft(y);
        }
        else x.parent.setRight(y);
        y.left = x;
        x.parent = y;
    }

    /**
     *
     * @Author TanYingHao
     * @Description 右旋调整
     * @Date 13:05 2023/1/30
     * @Param [x]
     **/
    private void rotateRight(RBTreeNode x){
        RBTreeNode y = x.left;
        x.left = y.right;
        if(y.right != RBTreeNode.nil){
            y.right.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == RBTreeNode.nil){ //如果x本身是根节点，需要更新
            RBTreeNode.nil.setLeft(y);
        }
        else if(x == x.parent.left){
            x.parent.setLeft(y);
        }
        else x.parent.setRight(y);
        x.parent = y;
        y.right = x;
    }

    /**
     *
     * @Author TanYingHao
     * @Description 根据指定的值返回对应的节点
     * @Date 12:13 2023/1/31
     * @Param [value]
     **/
    public RBTreeNode findNode(RBTreeNode p,int value){
        if(p == RBTreeNode.nil) return RBTreeNode.nil;
        if(p.value == value) return p;
        else if(p.value > value) return findNode(p.left,value);
        else return findNode(p.right,value);
    }
    /**
     *
     * @Author TanYingHao
     * @Description 指定值删除对应的节点
     * @Date 12:18 2023/1/31
     * @Param [value]
     **/

    public void deleteNode(int value){
         deleteNode(findNode(getRoot(),value));
    }

    /**
     *
     * @Author TanYingHao
     * @Description 红黑树删除指定的节点
     * @Date 17:04 2023/1/30
     * @Param [z]
     **/
    public void deleteNode(RBTreeNode z){
        RBTreeNode y = z;  //追踪将要删除或者移入的节点
        int yOriginalColor = y.color;
        RBTreeNode x = new RBTreeNode();  //来追踪用来替换的节点
        if(z.left == RBTreeNode.nil){ //无左孩子
            x = z.right;
            transplantRB(z,z.right);
        }
        else if(z.right == RBTreeNode.nil){ //无右孩子
            x = z.left;
            transplantRB(z,z.left);
        }
        else{   //有两个节点
            y = treeMinimum(z.right);
            yOriginalColor = y.color;
            x = y.right;  //y是最小，其只可能有右孩子或者无孩子
            if(y.parent == z){
              x.parent = y;  //此时不需要断链
            }
            else {
                transplantRB(y,y.right); //将y.right放到y原来的位置
                y.right = z.right; //y放到z的位置，将z右孩子连接到y上面
                y.right.parent = y;
            }
            transplantRB(z,y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if(yOriginalColor == RBTreeNode.BLACK){
            deleteFixup(x);
        }
    }

    /**
     *
     * @Author TanYingHao
     * @Description 用v替换u
     * @Date 17:12 2023/1/30
     * @Param [u, v]
     **/
    private void transplantRB(RBTreeNode u, RBTreeNode v){
        if(u.parent == RBTreeNode.nil){
            RBTreeNode.nil.setLeft(v); //u是根节点的话，更新一下根节点
        }
        else if(u == u.parent.left){
            u.parent.left = v;
        }
        else u.parent.right = v;
        v.parent = u.parent;
    }
    /**
     *
     * @Author TanYingHao
     * @Description  用来找到树中的最小值对应的结点
     * @Date 17:13 2023/1/30
     * @Param [p]
     * @return utils.RBTreeNode
     **/
    public RBTreeNode treeMinimum(RBTreeNode p){
       while(p.left != RBTreeNode.nil){
           p = p.left;
       }
       return p;
    }

    /**
     *
     * @Author TanYingHao
     * @Description 修复因删除而导致的红黑树性质破坏
     * @Date 17:21 2023/1/30
     * @Param [x]
     **/
    private void deleteFixup(RBTreeNode x){
        RBTreeNode w = new RBTreeNode(); //x的兄弟
        while (x != getRoot() && x.color == RBTreeNode.BLACK){//如果x的颜色也为黑，则加上删去的y的黑色，说明现在x有两层黑
            if(x == x.parent.left){  //如果x是父亲节点的左孩子
                w = x.parent.right;
                if(w.color == RBTreeNode.RED){  //case1:兄弟为红,这时可以调整颜色并左旋，将新兄弟变为黑从而转换为其他情况
                    w.color = RBTreeNode.BLACK;
                    x.parent.color = RBTreeNode.RED;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }
                if(w.left.color == RBTreeNode.BLACK && w.right.color == RBTreeNode.BLACK){//case2:x兄弟w为黑，且w子节点均为黑
                    w.color = RBTreeNode.RED; //其和x均删去一层黑
                    x = x.parent; //将黑色传递给x的父节点
                }
                else if(w.right.color == RBTreeNode.BLACK){ // case3: x兄弟w为黑，w左孩子为红，右孩子为黑
                    w.left.color = RBTreeNode.BLACK;
                    w.color = RBTreeNode.RED;
                    rotateRight(w);
                    w = x.parent.right; //更新兄弟转换为情况四
                }
                else {   //case4: w为黑，w右孩子为红色
                    w.color = x.parent.color;
                    x.parent.color = RBTreeNode.BLACK;
                    w.right.color = RBTreeNode.BLACK;
                    rotateLeft(x.parent);
                    x = getRoot(); //结束循环
                }
            }
            else {   //如果x是父亲节点的右孩子
                w = x.parent.left;
                if(w.color == RBTreeNode.RED){  //case1:兄弟为红,这时可以调整颜色并左旋，将新兄弟变为黑从而转换为其他情况
                    w.color = RBTreeNode.BLACK;
                    x.parent.color = RBTreeNode.RED;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }
                if(w.left.color == RBTreeNode.BLACK && w.right.color == RBTreeNode.BLACK){//case2:x兄弟w为黑，且w子节点均为黑
                    w.color = RBTreeNode.RED; //其和x均删去一层黑
                    x = x.parent; //将黑色传递给x的父节点
                }
                else if(w.left.color == RBTreeNode.BLACK){ // case3: x兄弟w为黑，w左孩子为黑，右孩子为红
                    w.right.color = RBTreeNode.BLACK;
                    w.color = RBTreeNode.RED;
                    rotateLeft(w);
                    w = x.parent.left; //更新兄弟转换为情况四
                }
                else {   //case4: w为黑，w左孩子为红色
                    w.color = x.parent.color;
                    x.parent.color = RBTreeNode.BLACK;
                    w.left.color = RBTreeNode.BLACK;
                    rotateRight(x.parent);
                    x = getRoot(); //结束循环
                }
            }
        }
        x.color = RBTreeNode.BLACK;
    }

    //以下三个函数是用来打印红黑树的
    private void padding (String ch,int n){
        for (int i = 0; i < n; i++) {
            System.out.printf(ch);
        }
    }
    /**
     *
     * @Author TanYingHao
     * @Description 中序遍历打印红黑树
     * @Date 11:54 2023/1/31
     * @Param [p, level]
     **/
    private void printNode(RBTreeNode p,int level){
        if(p == RBTreeNode.nil){
            padding("\t",level);
            System.out.println("NIL");
        }
        else{
            printNode(p.right,level+1);
            padding("\t",level);
            if(p.color == RBTreeNode.BLACK){
                System.out.printf("(%d)\n", p.value);
            }
            else {
                System.out.printf("%d\n",p.value);
            }
            printNode(p.left,level+1);
        }
    }
    public void printRBTree(){
        printNode(getRoot(),0);
        System.out.println("----------------------------------------");
    }




}
