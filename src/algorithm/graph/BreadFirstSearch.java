package algorithm.graph;

import algorithm.linear.queue.Queue;

public class BreadFirstSearch {
    private boolean[] marked;
    private int count;
    private Queue<Integer> waitSearch;

    public BreadFirstSearch(Graph G, int s){
        this.marked = new boolean[G.V()];
        this.count = 0;
        this.waitSearch = new Queue<>();
        bfs(G, s);
    }

    private void bfs(Graph G, int v){
        marked[v] = true;
        waitSearch.enqueue(v);
        while(!waitSearch.isEmpty()){
            Integer wait = waitSearch.dequeue();
            for(Integer w : G.adj(wait)){
                if(!marked[w]){
                    bfs(G, w);
                }
            }
        }
        count ++;
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
