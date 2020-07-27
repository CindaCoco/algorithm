package algorithm.graph.test;

import algorithm.graph.BreadFirstSearch;
import algorithm.graph.DepthFirstSearch;
import algorithm.graph.Graph;

public class GraphTest {
    public static void main(String[] args) {
        Graph G=new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(5,3);
        G.addEdge(5,4);
        G.addEdge(3,4);
        G.addEdge(4,6);
        G.addEdge(7,8);
        G.addEdge(9,10);
        G.addEdge(9,11);
        G.addEdge(9,12);
        G.addEdge(11,12);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(G,0);
        int count = depthFirstSearch.count();
        System.out.println("与起点0相通的顶点数量为："+count);
        boolean marked1 = depthFirstSearch.marked(5);
        System.out.println("顶点5和顶点0是否相通？"+marked1);
        boolean marked2 = depthFirstSearch.marked(7);
        System.out.println("顶点7和顶点0是否相通？"+marked2);


        BreadFirstSearch breadFirstSearch = new BreadFirstSearch(G,0);
        int count1 = breadFirstSearch.count();
        System.out.println("与起点0相通的顶点数量为："+count1);
        boolean marked3 = breadFirstSearch.marked(5);
        System.out.println("顶点5和顶点0是否相通？"+marked3);
        boolean marked4 = breadFirstSearch.marked(7);
        System.out.println("顶点7和顶点0是否相通？"+marked4);


        
    }
}
