package algorithm.graph;

public class DepthFirstSearch {
    private boolean[] marked;

    private int count;
    //构造深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相邻顶点。
    public DepthFirstSearch(Graph G,int s){
        this.marked = new boolean[G.V()];
        this.count = 0;
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
                dfs(G,w);
            }
        }
        count++;
    }
    //判断w顶点与s顶点是否相通
    public boolean marked(int w){
        return marked[w];
    }

    //获取与顶点s相通的所有顶点的总数
    public int count(){
        return count;
    }
}
