import java.util.*;
class BFSLinkedList
{
     int V;
     LinkedList<Integer> vertices[];
     
    BFSLinkedList(int v)
    {  
        V=v;
        vertices=new LinkedList[V];
        for(int i=0;i<V;i++)
        { 
            vertices[i]=new LinkedList<>();
        }
    }
    void add(int s,int d)
    { 
        vertices[s].add(d);
    }
    void BFS(int s)
    {
        boolean visit[] =new boolean[V];
        LinkedList<Integer> queue=new LinkedList<>();
        visit[s]=true;
        queue.add(s);
        while(queue.size()!=0)
        {
            s=queue.poll();
            System.out.println(s+" ");
            Iterator<Integer> i=vertices[s].listIterator();
            while(i.hasNext())
            { 
                int n=i.next();
                if(!visit[n])
                {
                    visit[n]=true;
                    queue.add(n);
                }
             }
        }
    }
    public static void main()
    { 
        Scanner in=new Scanner(System.in);
        int v=in.nextInt();
        BFSLinkedList g=new BFSLinkedList(v);
        int n=in.nextInt();
        for(int i=0;i<n;i++)
        { 
            g.add(in.nextInt(),in.nextInt());
        }
        int node=in.nextInt();
        
        g.BFS(node);
    }
}