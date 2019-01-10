import java.util.*;
class dfs 
{
    LinkedList<Integer> link[];
    int S;
    int count=1;
    dfs(int s)
    {
        S=s;
        link=new LinkedList[S+1];
        for(int i=1;i<=S;i++)
        {
            link[i]=new LinkedList<>();
        }
    }

    void add(int a,int b)
    {
        link[a].add(b);
        link[b].add(a);
    }

    void dfsrec(int n,boolean visit[])
    {
        //System.out.println("count"+count+"node"+n);
        visit[n]=true;
        Iterator<Integer> it=link[n].listIterator();
        while(it.hasNext())
        {
            int ele=it.next();
            if(visit[ele]==false)
            {
                count++;
                dfsrec(ele,visit);
            }
        }
    }

    void res()
    {
        System.out.println(S-count);
    }

    public static void main(String[] args)
    {

        Scanner in=new Scanner(System.in);
        int nodes=in.nextInt();
        int edge=in.nextInt();
        dfs obj=new dfs(nodes);
        for(int i=0;i<edge;i++)
        {
            int a=in.nextInt();
            int b=in.nextInt();
            obj.add(a,b);
        }
        int x=in.nextInt();
        boolean visit[]=new boolean[nodes+1];
        obj.dfsrec(x,visit);
        obj.res();
    }
}