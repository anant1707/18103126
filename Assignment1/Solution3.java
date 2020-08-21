
import java.util.*;
public class Solution3 {
    public Graph graph;

    public class Graph{

        private final int V, E;
        private final Edge[] edges;

        public Graph(int V, int E) {
            this.V = V;
            this.E = E;
            this.edges = new Edge[E];
        }

        private class Edge{
            int src, dest, weight;

            Edge(int src, int dest, int weight){
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
        }
        
        private void addEdge(int[] src, int[] dest, int[] weight){
            for(int i=0; i<this.E; ++i)
                this.edges[i] = new Edge(src[i], dest[i], weight[i]);
        }
         
    }
    
    public Solution3(int V, int E, int[] src, int[] dest, int[] weight) {
        this.graph = new Graph(V, E);
        this.graph.addEdge(src, dest, weight);
    }
    
    public String BellmanFord(int src, int dest) 
        { 
            int[] dist = new int[this.graph.V]; 
            int[] edgeTo = new int[this.graph.V];

            for (int i = 0; i < this.graph.V; ++i) 
                dist[i] = Integer.MAX_VALUE; 
            dist[src] = 0;
            edgeTo[src] = -1;

            for (int i = 1; i < this.graph.V; ++i) { 
                for (int j = 0; j < this.graph.E; ++j) { 
                    int u = this.graph.edges[j].src; 
                    int v = this.graph.edges[j].dest; 
                    int weight = this.graph.edges[j].weight; 
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){ 
                        dist[v] = dist[u] + weight; 
                        edgeTo[v] = u;
                    }
                } 
            } 

            for (int j = 0; j < this.graph.E; ++j) { 
                int u = this.graph.edges[j].src; 
                int v = this.graph.edges[j].dest; 
                int weight = this.graph.edges[j].weight; 
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
                    return "Negative cycles exist"; 
                } 
            }
            
            Stack<Integer> stack = new Stack<>();
            int u = dest;
            stack.push(u);
            while(edgeTo[u] != -1){
                stack.push(edgeTo[u]);
                u = edgeTo[u];
            }
            
            StringBuilder path = new StringBuilder();
            while(!stack.isEmpty()){
                path.append(stack.pop());
                if(!stack.isEmpty()) path.append(" -> ");
            }
            return path.toString();
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Find shortest path/negative cycles in graph");
        System.out.println("Enter no. of vertices and edges respectively: ");
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[] src = new int[e], dest = new int[e], weight = new int[e];
        System.out.println("Enter source, destination and weight for each edge");
        for(int i=0; i<e; ++i){
            src[i] = sc.nextInt();
            dest[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }
        Solution3 sp = new Solution3(v, e, src, dest, weight);
        System.out.println("Enter source and destination: ");
        int s = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(sp.BellmanFord(s, d));   
    }
}