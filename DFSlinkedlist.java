import java.util.*;
class DFSlinkedlist
{ 
    int V;
    LinkedList<Integer> vertice[];
    DFSlinkedlist(int v)
    {
        V=v;
        vertice=new LinkedList[V];
        for(int i=0;i<V;i++)
        {
            vertice[i]=new LinkedList();
        }
    }
    void add(int s,int d)
    {
        vertice[s].add(d);
    }
    void dfs(int node)
    {
        boolean visit[]= new boolean[V];
        dfsrecur(visit,node);
    }
    void dfsrecur(boolean visit[],int node)
    {
        visit[node]=true;
        System.out.println(node+" ");
        Iterator<Integer> i=vertice[node].listIterator();
        while(i.hasNext())
        {
            int n=i.next();
            if(visit[n]==false)
              dfsrecur(visit,n);
            }
    }
     public static void main()
    {
        Scanner in=new Scanner(System.in);
        int v=in.nextInt();
        DFSlinkedlist g=new DFSlinkedlist(v);
        int n=in.nextInt();
        for(int i=1;i<=n;i++)
        { 
            g.add(in.nextInt(),in.nextInt());
        }
        int node=in.nextInt();
        g.dfs(node);
    }
    }