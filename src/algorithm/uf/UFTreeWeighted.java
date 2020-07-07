package algorithm.uf;

import java.util.Arrays;

public class UFTreeWeighted {

    //存储父节点的索引
    private int[] eleAndGroup;
    //用来存储每一个根节点对应的树中保存的结点的个数
    private int[] sz;
    private int count;
    public UFTreeWeighted(int N){
        this.count = N;
        this.eleAndGroup = new int[N];
        this.sz = new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }

        Arrays.fill(sz, 1);
    }

    public int count(){
        return count;
    }

    public int find(int p){
        while (true){
            if(p == eleAndGroup[p]){
                return p;
            }
            p = eleAndGroup[p];
        }
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return ;
        }

        //判断pRoot对应的树大还是qRoot对应的树大
        if(sz[pRoot]<sz[qRoot]){
            eleAndGroup[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else{
            eleAndGroup[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

        this.count--;

    }


}
