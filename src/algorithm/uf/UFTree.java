package algorithm.uf;

public class UFTree {

    //存储父节点的索引
    private int[] eleAndGroup;
    private int count;
    public UFTree(int N){
        this.count = N;

        this.eleAndGroup = new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
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

        eleAndGroup[pRoot] = qRoot;
        this.count--;

    }


}
