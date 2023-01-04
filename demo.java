import java.util.*;  


// This is edge of graph
class Edge   
{  
    int src, dest;  
    Edge(int src, int dest)   
    {  
        this.src = src;  
        this.dest = dest;
    }  
}  
//a class to represent a graph object  
class Graph  
{  
    List<List<Integer>> adjlist = new ArrayList<>();  
    public Graph(List<Edge> edges)  
    {  
        int n = 0;  
        for (Edge e: edges)   
        {      
            n = Integer.max(n, Integer.max(e.src, e.dest));  
        }  
        for (int i = 0; i <= n; i++)   
        {  
            adjlist.add(i, new ArrayList<>());  
        }   
        for (Edge current: edges)  
        {  
            adjlist.get(current.src).add(current.dest);  
        }  
    }  
    
    public static void showGraph(Graph graph)  
    {  
        String[] places = {"Kiev", "Prague", "Zurich", "Amsterdam", "Barcelona", "Berlin"};
        int s = 0;  
        int n = graph.adjlist.size();  
        while (s < n)  
        {
            for (int d: graph.adjlist.get(s))  
            {  
                System.out.println("(" + places[s] + " -- > " + places[d] + ")\t"); 
            }  
            System.out.println();  
            s++;  
        }  
    }  
}
public class demo  
{  
    public static void main (String args[])  
    {  
        System.out.println("\nThe Route goes like this\n");
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(3, 4), new Edge(4, 5), new Edge(5, 0));  
        Graph graph = new Graph(edges);  
        Graph.showGraph(graph);  
}  
}  