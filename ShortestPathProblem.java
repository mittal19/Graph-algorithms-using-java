import java.util.*;
class  ShortestPathProblem 
{
    LinkedList<Node> link[];

    static class Node
    {
        int dest,w;
        Node(int d,int we)
        {
            dest=d;
            w=we;
        }
    }

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int v=in.nextInt();
        int e=in.nextInt();
        link=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            link[i]=new LinkedList<>();
        }
        for(int i=0;i<v;i++)
        {
            int src=in.nextInt();
            int dest=in.nextInt();
            int w=in.nextInt();
            link[i].add(new Node(src,w));
        }
        int dist[]=new int[v];
        int path[]=new int[v];
        int nextnode;
        int min=0;
        
