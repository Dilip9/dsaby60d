import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortVariations {

    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(1, 2));
        graph[1].add(new Edge(2, 3));
        graph[2].add(new Edge(2,4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4,5));

    }

    public static void topoLogicalSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topoLogicalSort(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void topSort(ArrayList<Edge>[] graph , int v){
        boolean[] vis = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topoLogicalSort(graph, i, vis, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()+"");
            
        }
    }



     public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        topSort(graph, v);  
        
    }
}
