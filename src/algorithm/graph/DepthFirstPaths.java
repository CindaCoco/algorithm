package algorithm.graph;

import algorithm.linear.stack.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int s;
    private int[] edgeTo;

    public DepthFirstPaths(Graph G,int s){
        marked = new boolean[G.V()];
        this.s = s;
        this.edgeTo = new int[G.V()];
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
                edgeTo[w] = v;//到达顶点w的最后一个顶点是v
                dfs(G,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }


    public Stack<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<>();
        //通过循环从顶点v开始，一直往前找找到起点
        for(int x = v;x!=s;x = edgeTo[x]){
            path.push(x);
        }

        path.push(s);
        return path;
    }

}
