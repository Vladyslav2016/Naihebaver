import java.util.Scanner;

public class Main {

    public static void main(String[] add) {
        Scanner scan = new Scanner(System.in);
        Graph g = new Graph();
        String Node;
        boolean x = true;
       
        
        System.out.println("������ ������ ������ �� �����");
        int m = scan.nextInt();
        int n = scan.nextInt();
        
        
        System.out.println("������� �������");
        for(int i = 0; i < m; i++) 
        {
        	Node = scan.next();
            g.addNode(Node);
        }
        
        
        System.out.println("������� �����");
        for(int i = 0; i < n; i++) 
        {
        	String Node1 = scan.next();
        	String Node2 = scan.next();  
        	g.addEdge(Node1, Node2);
        }
        
        
        while(x) 
        {
        	System.out.println("1 - ������� ����");
        	System.out.println("2 - ������ ������� �� ID");
        	System.out.println("3 - �����");
        	int k = scan.nextInt();
        	
        	 if (k == 1) {
        		 g.Output();
               } else {
        	 if (k == 2){
        		 g.Search();
         } else{
     x=false;
        	}
      }  
   }   	 
     
  } 
}