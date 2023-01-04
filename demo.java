/**************************************************************************************
 * Name: Rajesh S
 * Assignment2: Q . Your son took a vacation through Europe without telling you. When the kid returned from the vacation you asked him where did he go. The kid told you: Dad I went to these cities: Amsterdam, Kiev, Zurich, Prague, Berlin, Barcelona.
 * I used only train as transportation and these were the available tickets:
 * Paris-Skopje, Zurich-Amsterdam, Prague-Zurich, Barcelona-Berlin, Kiev-Prague, Skopje-Paris, Amsterdam-Barcelona, Berlin-Kiev, Berlin-Amsterdam.
 * You know that your kid started with Kiev
 * Write a data structure and algorithm that will give you the route which your son was traveling.
 * Data_structure used: Graph
 * Inference:  The son has train tickets from paris to skopje and skopje to Paris which he woul have 
 * travelled only if he has train tickets from any place to paris or skonpje. As the train ticket has 
 * paris to skopje and skopje to paris, it is only possible that he would have missed the train ticket of 
 * anyplace as source to either paris or skopje
 *****************************************************************************************************/

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
        // n is max of the edge value
        int n = 0;  
        for (Edge e: edges)   
        {      
            n = Integer.max(n, Integer.max(e.src, e.dest));  
        }  
        /*
         * For creating the list of list 
         * Eg. [0: [],
         *     [1: [],
         *     [2: [],
         *     [3: [],
         *     [4: [],]
         *          */
        for (int i = 0; i <= n; i++)   
        {  
            adjlist.add(i, new ArrayList<>());  
        }   
        /*
         * Adding the scource and destination to the adj list
         * Eg. [src: adjlist.get[0...n].add(destination)]
         * This will give us: 
         *                  [0: [1],
         *                   1: [2],....]
         */
        for (Edge current: edges)  
        {  
            adjlist.get(current.src).add(current.dest);  
        }  
    }  

    /*
     * To display the graph that is created
     * Takes 1 arg, that is graph object
     */
    
    public static void Displaygraph(Graph graph)  
    {  
        // places to print since the node value are from 0 to n
        String[] places = {"Kiev", "Prague", "Zurich", "Amsterdam", "Barcelona", "Berlin"};
        int s = 0;  
        int n = graph.adjlist.size();  

        /*
         * Here the val of s is src and d is destination
         * when we say graph.adjlist.get(s) we are getting 
         * the destination list[] for curresponding source
         * Eg: [src: [destination1, destination2, ...]
         */
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

/*
 * calling the req function
 */
public class demo  
{  
    public static void main (String args[])  
    {  
        System.out.println("\nThe Route goes like this\n");
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(3, 4), new Edge(4, 5), new Edge(5, 0));  
        Graph graph = new Graph(edges);  
        Graph.Displaygraph(graph);  
}  
}  