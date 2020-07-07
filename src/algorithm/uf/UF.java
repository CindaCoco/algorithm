package algorithm.uf;

public class UF {
    private int[] eleAndGroup;
    private int count;
    public UF(int N){
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
        return eleAndGroup[p];
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public void union(int p,int q){
        if(connected(p,q)){
            return ;
        }

        int pGroup = find(p);
        int qGroup = find(q);
        for (int i = 0; i < eleAndGroup.length; i++) {
            if(eleAndGroup[i] == pGroup){
                eleAndGroup[i] = qGroup;
            }
        }
        this.count--;

    }


}
