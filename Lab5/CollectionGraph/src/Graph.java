import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public  class Graph {
   
    Scanner scan = new Scanner(System.in);

    public static HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
    public ArrayList<GN> id = new ArrayList<GN>();

    
    public void addNode(String Node) {
        
            graph.put(Node, new ArrayList<String>()); 
            id.add(new GN<String>(Node));
        
    }

    
    public boolean hasNode(String Node) {
        return graph.containsKey(Node);
    }

    
    public boolean hasEdge(String Node1, String Node2) {
        if (!hasNode(Node1)) return false;
        List<String> edges = graph.get(Node1);
        return Collections.binarySearch(edges, Node2) != -1;
    }
    

    public void addEdge(String Node1, String Node2) {
        if(!hasEdge(Node1,Node2)){
        if (!hasNode(Node1)) {addNode(Node1); id.add(new GN<String>(Node1));}
        if (!hasNode(Node2)) {addNode(Node2); id.add(new GN<String>(Node2));}
        List<String> edges1 = graph.get(Node1);
        List<String> edges2 = graph.get(Node2);
        edges1.add(Node2);
        edges2.add(Node1);
        Collections.sort(edges1);
        Collections.sort(edges2);
    }}


  
    public void Output(){
        for (Map.Entry entry : graph.entrySet()) {
            System.out.println("Вершина: " + entry.getKey() + " зв'язана з: "
                    + entry.getValue());
        }

    }


    public void Search() {
        int k = scan.nextInt();
        System.out.println("Вершина з id "+k+": "+id.get(k-1).getob());
    }

}

