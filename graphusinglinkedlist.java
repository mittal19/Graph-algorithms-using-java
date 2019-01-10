import java.util.LinkedList;
import java.util.*;
class graphusinglinkedlist
{ 
    int V;
    LinkedList<Integer> vertices[];
    graphusinglinkedlist(int v)
    { 
        V=v;
        vertices=new LinkedList[V];
      for(int i=0;i<V;i++)
      { 
          vertices[i]=new LinkedList<>();
      }
    }
    void add(int src,int dest)
    { 
        vertices[src].addFirst(dest);
        vertices[dest].addFirst(src);
    }
    void display()
    {
        for(int i=0;i<V;i++)
        { 
            for(Integer p:vertices[i])
              System.out.print("->"+p);
            System.out.println();
        }
    }
    public static void main()
    {
        Scanner in=new Scanner(System.in);
        int v=in.nextInt();
        graphusinglinkedlist g=new graphusinglinkedlist(v);
        int n=in.nextInt();//enter no. of nodes
        for(int i=1;i<=n;i++)
        { 
            g.add(in.nextInt(),in.nextInt()); //enter vertices connected through edges
        }
        g.display();
    }
}
        
        
