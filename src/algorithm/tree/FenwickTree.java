package algorithm.tree;

/**
 * 树状数组
 */
public class FenwickTree {
    private int[] tree;
    private int len;

    public FenwickTree(int n){
        this.len = n;
        this.tree = new int[n+1];
    }

    public FenwickTree(int[] nums){
        this.len = nums.length;
        this.tree = new int[this.len+1];
        for(int i=0;i<this.len;i++){
            update(i+1, nums[i]);
        }
    }

    public void update(int i, int delta){
        while(i<=this.len){
            tree[i] += delta;
            i += lowbit(i);
        }
    }
    public int query(int i){
        int sum = 0;
        while(i>0){
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }

    public int lowbit(int x){
        return x&(-x);
    }
}
